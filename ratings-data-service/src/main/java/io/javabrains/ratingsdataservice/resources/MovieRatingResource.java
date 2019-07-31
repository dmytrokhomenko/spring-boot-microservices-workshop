package io.javabrains.ratingsdataservice.resources;

import io.javabrains.ratingsdataservice.modules.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class MovieRatingResource {

  @RequestMapping("/{movieId}")
  public MovieRating getMovieRating(@PathVariable String movieId){
    return new MovieRating(movieId, 10);
  }

  @RequestMapping("users/{userId}")
  public UserMovieRating getUserMovieRating(@PathVariable String userId) {
    List<MovieRating> movieRatings = List.of(new MovieRating("123", 10), new MovieRating("1234", 8));
    return new UserMovieRating(movieRatings);
  }
}
