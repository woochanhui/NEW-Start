package com.example.jpa.service;


import com.example.jpa.Repository.PostRepository;
import com.example.jpa.dto.PostDto;
import com.example.jpa.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;

    // ✅ CREATE
    @Transactional  // 쓰기 작업은 @Transactional 별도 선언
    public PostDto.Response createPost(PostDto.CreateRequest request) {
        Post post = Post.create(request.getTitle(), request.getContent(), request.getAuthor());
        Post savedPost = postRepository.save(post);
        return PostDto.Response.from(savedPost);
    }
}