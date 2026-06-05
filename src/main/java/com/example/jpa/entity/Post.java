package com.example.jpa.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private long id; //고유 번호

    @Column(nullable = false, length = 100)
    private String title; //제목

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content; //내용

    @Column(nullable = false)
    private String author; //작성자

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt; //생성일자

    @LastModifiedDate
    private LocalDateTime updatedAt; //수정일자

    public static Post create(String title, String content, String author) {
        Post post = new Post();
        post.title = title;
        post.content = content;
        post.author = author;
        return post;
    }

    // 수정 메서드
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
