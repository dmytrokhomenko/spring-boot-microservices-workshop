package io.javabrains.movieinfoservice.resources;

import io.javabrains.movieinfoservice.modules.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieResource {

  @RequestMapping("/{movieId}")
  public Movie getMovie(@PathVariable String movieId){
    return new Movie(movieId, "Impossible");
  }

}
