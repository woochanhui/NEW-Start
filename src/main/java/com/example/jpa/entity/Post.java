package com.example.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Post {

    @Id
    private long id; //

    private String title;

    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime updataAt;

}
