package com.team3.blogproject.service.web.interfaces;

import com.team3.blogproject.model.Post;
import org.springframework.data.domain.Page;

public interface PostService {

    void savePost(Post post);

    Post getPostById(long id);

    void deletePostById(long id);

    Page<Post> findPaginated(int pageNum, int pageSize);
}