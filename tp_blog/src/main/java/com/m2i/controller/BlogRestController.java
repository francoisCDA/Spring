package com.m2i.controller;



import com.m2i.model.Commentary;
import com.m2i.model.Post;
import com.m2i.service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class BlogRestController {

    private final BlogService blogService;


    @GetMapping("/articles")
    public List<Post> getall() { return blogService.getAllPost();}

    @GetMapping("/article/{id}")
    public Post getPostById(@PathVariable UUID id) {return blogService.getPostById(id);}

    @GetMapping("/article/{id}/comments")
    public List<Commentary> getCommentariesByPostId(@PathVariable UUID id) {return blogService.getCommentaryByPostId(id);}


    @PostMapping("/articles")
    public Post postPost(@Valid @RequestBody Post post, BindingResult result){
        if (result.hasErrors()) {
            return null;
        }

        return blogService.newPost(post);

    }

    @PostMapping("/comment")
    public Commentary postCommentary(@PathVariable UUID postId, @Valid @RequestBody Commentary commentary, BindingResult result){
        if (result.hasErrors()) {
            return null;
        }

        return blogService.newCommentary(commentary);

    }


}
