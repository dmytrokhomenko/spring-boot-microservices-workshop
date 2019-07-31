package io.javabrains.ratingsdataservice.modules;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MovieRating {
  private String movieId;
  private int rating;
}
