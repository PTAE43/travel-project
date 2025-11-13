package com.demo.travel.repository;

import com.demo.travel.entity.Trip;
import org.springframework.data.jpa.repository.*;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {
  @Query(value = """
        SELECT * FROM trips
        WHERE title ILIKE CONCAT('%', :q, '%')
           OR province ILIKE CONCAT('%', :q, '%')
           OR :q = ANY(tags)
        ORDER BY created_at DESC
      """, nativeQuery = true)
  List<Trip> search(String q);
}
