package com.team3.blogproject.service;

import com.team3.blogproject.model.Post;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PostService {

    void savePost(Post post);

    Post getPostById(long id);

    void deletePostById(long id);

    Page<Post> findPaginated(int pageNum, int pageSize);

    List<Post> findLatest5();
}