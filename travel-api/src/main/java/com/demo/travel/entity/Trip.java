package com.demo.travel.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.time.Instant;

@Entity
@Table(name = "trips")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    public String title;
    @Column(columnDefinition = "TEXT")
    public String description;

    @JdbcTypeCode(SqlTypes.ARRAY)
    @Column(columnDefinition = "text[]")
    public String[] photos;

    @JdbcTypeCode(SqlTypes.ARRAY)
    @Column(columnDefinition = "text[]")
    public String[] tags;

    public Double latitude;
    public Double longitude;
    public String province;

    @Column(name = "author_id")
    public Long authorId;

    public Instant created_at;
    public Instant updated_at;
}
