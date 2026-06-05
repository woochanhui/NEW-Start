package com.example.jpa.Repository;

import com.example.jpa.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    // 작성자로 검색하는 기능
    // 메서드 이름으로 쿼리 자동 생성
    List<Post> findByAuthor(String author);

    List<Post> findByTitleContaining(String keyword);

    // JPQL 직접 작성
    @Query("SELECT p FROM Post p WHERE p.title LIKE %:keyword% OR p.content LIKE %:keyword%")
    List<Post> searchByKeyword(@Param("keyword") String keyword);
}
