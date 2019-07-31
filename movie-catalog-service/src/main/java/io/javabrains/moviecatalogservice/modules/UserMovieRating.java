package io.javabrains.moviecatalogservice.modules;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class UserMovieRating {
  private List<MovieRating> ratingList;
}
