package com.m2i.controller;

import com.m2i.model.Commentary;
import com.m2i.model.Post;
import com.m2i.service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class BlogController {

    private BlogService blogService;


    @GetMapping("/") //localhost:8080/
    public String home(Model model) {
        model.addAttribute("articles",blogService.getAllPost());
        return "index";
    }

    @GetMapping("/post") //localhost:8080/post
    public String newPost(Model model) {
        model.addAttribute("post", new Post());
        return "blog/post";
    }

    @PostMapping("/post")
    public String postPost(@Valid @ModelAttribute("post") Post post, BindingResult resulst) {
        if (resulst.hasErrors()) {
            return "blog/post";
        }

        blogService.newPost(post);
        return "redirect:/";
    }

    @GetMapping("/article{id}")
    public String article(@PathVariable UUID id, Model model) {
        Post post = blogService.getPostById(id);
        List<Commentary> commentaries = blogService.getCommentaryByPostId(id);
        model.addAttribute("post",post);
        model.addAttribute("comments",commentaries);
        model.addAttribute("commentary",new Commentary());
        return "article";
    }


}
