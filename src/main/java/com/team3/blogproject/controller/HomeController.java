package com.team3.blogproject.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.team3.blogproject.model.Post;
import com.team3.blogproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.team3.blogproject.model.User;
import com.team3.blogproject.repository.UserRepository;
import com.team3.blogproject.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @RequestMapping( value= { "/", "/home" } )
    public String index(Model model){
        
        List<Post> latest5Posts = this.postService.findLatest5();
        model.addAttribute("latest5Posts", latest5Posts);
        List<Post> latest3Posts = latest5Posts.stream().limit(3).collect(Collectors.toList());
        model.addAttribute("latest3Posts", latest3Posts);
        return "index"; 
    }

    @GetMapping("/usernameTable")
    public String viewUsernameTable(Model model){
        model.addAttribute("listUsers", userService.getAllUsers());
        return "usernameTable";

    }
    

}
