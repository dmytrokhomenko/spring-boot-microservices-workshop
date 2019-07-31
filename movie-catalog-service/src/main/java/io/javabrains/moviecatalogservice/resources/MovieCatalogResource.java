package io.javabrains.moviecatalogservice.resources;

import io.javabrains.moviecatalogservice.modules.CatalogItem;
import io.javabrains.moviecatalogservice.modules.Movie;
import io.javabrains.moviecatalogservice.modules.MovieRating;
import io.javabrains.moviecatalogservice.modules.UserMovieRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

  private RestTemplate restTemplate;
  private WebClient.Builder webClientBuilder;

  @RequestMapping("/{userId}")
  public List<CatalogItem> getCatalogByRest(@PathVariable String userId) {

    UserMovieRating ratings = restTemplate.getForObject("localhost:1997/rating/users/"+userId, UserMovieRating.class);

    return ratings.getRatingList().stream()
      .map(rating -> {
        Movie movie = restTemplate.getForObject("localhost:1996/movie/" + rating.getMovieId(), Movie.class);
        return new CatalogItem(movie.getName(), "description", rating.getRating());
      })
      .collect(Collectors.toList());
  }

  @RequestMapping("/byClient/{userId}")
  public List<CatalogItem> getCatalogByClient(@PathVariable String userId) {

    List<MovieRating> ratings = List.of(new MovieRating("123", 10), new MovieRating("1234", 8));


    return ratings.stream()
      .map(rating -> {

        Movie movie = webClientBuilder.build()
          .get()
          .uri("localhost:1996/movie/" + rating.getMovieId())
          .retrieve()
          .bodyToMono(Movie.class)
          .block();

        return new CatalogItem(movie.getName(), "description", rating.getRating());
      })
      .collect(Collectors.toList());

  }

}

