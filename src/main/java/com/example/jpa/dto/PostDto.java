package com.example.jpa.dto;

import jakarta.validation.constraints.NotBlank;

public class PostDto {
    public static class CreateRequest {

        @NotBlank(message = "작성자는 필수입니다.")
        private String author;
    }
}
