package com.m2i.controller;



import com.m2i.dto.CommentaryDTO;
import com.m2i.dto.PostDTO;
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
    public List<PostDTO> getall() { return blogService.getAllPost();}

    @GetMapping("/article/{id}")
    public PostDTO getPostById(@PathVariable UUID id) {return blogService.getPostById(id);}

    @GetMapping("/article/{id}/comments")
    public List<CommentaryDTO> getCommentariesByPostId(@PathVariable UUID id) {return blogService.getCommentaryByPostId(id);}


    @PostMapping("/articles")
    public PostDTO postPost(@Valid @RequestBody PostDTO post, BindingResult result){
        if (result.hasErrors()) {
            return null;
        }

        return blogService.newPost(post);

    }

    @PostMapping("/comment")
    public CommentaryDTO postCommentary(@PathVariable UUID postId, @Valid @RequestBody CommentaryDTO commentary, BindingResult result){
        if (result.hasErrors()) {
            return null;
        }
        return blogService.newCommentary(commentary);

    }


}
