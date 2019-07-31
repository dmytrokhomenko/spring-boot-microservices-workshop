package io.javabrains.moviecatalogservice.modules;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CatalogItem {
  private String name;
  private String desc;
  private int rating;
}
