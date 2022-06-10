package com.team3.blogproject.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team3.blogproject.models.Post;
import com.team3.blogproject.services.PostService;



@Controller
public class HomeController {
@Autowired
private PostService postService;


@GetMapping("/login")
public String login(){
    return "login";
}

@GetMapping("/")
public String home(){
    return "index";
}


}
