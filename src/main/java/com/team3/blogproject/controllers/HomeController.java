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

@RequestMapping("/posts/view/{id}")
public String view(@PathVariable("id") Long id, Model model) {
    Post post = postService.findById(id);
    model.addAttribute("post", post);
    return "posts/view";
}

@RequestMapping("/")
public String index(Model model) {
List<Post> latest5Posts = postService.findLatest5();
model.addAttribute("lastest5post", latest5Posts);


List<Post> latest3Posts = latest5Posts.stream()
.limit(3).collect(Collectors.toList());
model.addAttribute("latest3posts", latest3Posts);

return "index";
}

@GetMapping("/login")
public String login(){
    return "login";
}

@GetMapping("/")
public String home(){
    return "index";
}


}
