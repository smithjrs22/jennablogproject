package com.team3.blogproject.controller;

import com.team3.blogproject.model.Post;
import com.team3.blogproject.service.PostService;
import com.team3.blogproject.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import  com.team3.blogproject.model.User;

import java.util.List;
import java.util.stream.Collectors;


@Controller
@Validated
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        return findPaginated(1, model);
    }

    @GetMapping("/post/new")
    public String showNewPostForm(Model model) {
        Post post = new Post();
        model.addAttribute("post", post);
        return "forms/create_post";
    }

    @PostMapping("/savePost")
    public String savePost(@ModelAttribute("post") Post post) {

        // Get author
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userService.findByUserName(auth.getName());
        post.setAuthor(user);
        postService.savePost(post);
        return "redirect:/?submit";

    }

    @PostMapping("/updatePost")
    public String updatePost(@ModelAttribute("post") Post post) {

        // Get author
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userService.findByUserName(auth.getName());
        post.setAuthor(user);
        postService.savePost(post);
        return "redirect:/?update";

    }

    @GetMapping("/post/{id}/update")
    public String updatePost(@PathVariable(value = "id") long id, Model model) {
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "forms/update_post";
    }

    @GetMapping("/deletePost/{id}")
    public String confirmDelete(@PathVariable(value = "id") long id, Model model) {
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "forms/delete_post";
    }

    @GetMapping("/deletePost/{id}/confirm")
    public String deletePost(@PathVariable(value = "id") long id) {
        this.postService.deletePostById(id);
        return "redirect:/?deleted";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
            Model model) {
        int pageSize = 5;
        Page<Post> page = postService.findPaginated(pageNo, pageSize);
        List<Post> listPosts = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("listPosts", listPosts);

        // Get last 5 post
        List<Post> latest5Posts = this.postService.findLatest5();
        model.addAttribute("latest5Posts", latest5Posts);
        List<Post> latest3Posts = latest5Posts.stream().limit(3).collect(Collectors.toList());
        model.addAttribute("latest3Posts", latest3Posts);
        return "index";
    }

    @RequestMapping("/posts/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "posts/view";
    }
}