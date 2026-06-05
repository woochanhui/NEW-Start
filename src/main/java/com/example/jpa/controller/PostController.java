package com.example.jpa.controller;

import com.example.jpa.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.jpa.dto.PostDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // POST /api/posts - 게시글 생성
    @PostMapping
    public ResponseEntity<PostDto.Response> createPost(@Valid @RequestBody PostDto.CreateRequest request) {
        PostDto.Response response = postService.createPost(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
