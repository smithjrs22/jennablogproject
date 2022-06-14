package com.team3.blogproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.team3.blogproject.model.User;
import com.team3.blogproject.repository.UserRepository;
import com.team3.blogproject.service.UserService;


@Controller
public class HomeController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @Autowired
    private UserService userService;

    //display table viewtable
    @GetMapping("/usernameTable")
    public String viewUsernameTable(Model model){
        //create attribute
        model.addAttribute("listUsers", userService.getAllUsers());
        return "usernameTable";

    }
    

}
