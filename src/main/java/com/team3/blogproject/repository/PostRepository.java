package com.team3.blogproject.repository;

import com.team3.blogproject.model.Post;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    // List<Post> findLatest5Posts(PageRequest of);
}
