package com.demo.travel.dto;

import com.demo.travel.entity.Trip;
import java.util.Arrays;
import java.util.List;

public record TripDTO(
  Long id, String title, String description,
  List<String> photos, List<String> tags,
  Double latitude, Double longitude, String province
){
  public static TripDTO from(Trip t){
    return new TripDTO(
      t.id, t.title, t.description,
      t.photos==null?List.of():Arrays.asList(t.photos),
      t.tags==null?List.of():Arrays.asList(t.tags),
      t.latitude, t.longitude, t.province
    );
  }
}
