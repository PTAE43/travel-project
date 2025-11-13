package com.demo.travel.controller;

import com.demo.travel.dto.TripDTO;
import com.demo.travel.entity.Trip;
import com.demo.travel.repository.TripRepository;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class TripController {

    private final TripRepository repo;

    public TripController(TripRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "UP");
    }

    @GetMapping("/trips")
    public List<TripDTO> list() {
        return repo.findAll().stream()
                .sorted(Comparator.comparing((Trip t) -> t.created_at,
                        Comparator.nullsLast(Comparator.naturalOrder())).reversed())
                .map(TripDTO::from).toList();
    }

    @GetMapping("/trips/{id}")
    public TripDTO get(@PathVariable Long id) {
        return repo.findById(id).map(TripDTO::from)
                .orElseThrow(() -> new RuntimeException("Trip not found"));
    }

    @GetMapping("/trips/search")
    public List<TripDTO> search(@RequestParam String q) {
        if (q == null || q.isBlank())
            return list();
        return repo.search(q).stream().map(TripDTO::from).toList();
    }
}
