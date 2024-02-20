package com.m2i.controller;

import com.m2i.dto.CommentaryDTO;
import com.m2i.dto.PostDTO;

import com.m2i.exception.BadIdException;
import com.m2i.service.AdminService;
import com.m2i.service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    private final AdminService adminService;


    @GetMapping("/") //localhost:8080/
    public String home(Model model) {
        model.addAttribute("articles",blogService.getAllPost());
        model.addAttribute("isAdminConnected", adminService.isAdminConnected());
        return "index";
    }

    @GetMapping("/post") //localhost:8080/post
    public String newPost(Model model) {
        model.addAttribute("newpost", new PostDTO());
        model.addAttribute("isAdminConnected", adminService.isAdminConnected());
        return "blog/post";
    }

    @PostMapping("/post")
    public String postPost(@Valid @ModelAttribute("newpost") PostDTO post, BindingResult resulst, Model model) {

        if (resulst.hasErrors()) {
            return "blog/post";
        }

        blogService.newPost(post);
        return "redirect:/";
    }

    @GetMapping("/article/{id}")
    public String article(@PathVariable UUID id, Model model) {
        PostDTO post = blogService.getPostById(id);
        List<CommentaryDTO> commentaries = blogService.getCommentaryByPostId(id);
        model.addAttribute("post",post);
        model.addAttribute("comments",commentaries);
        model.addAttribute("newCommentary",new CommentaryDTO());
        model.addAttribute("isAdminConnected", adminService.isAdminConnected());
        return "blog/article";
    }

    @PostMapping("/comment/{postId}")
    public String comment(@PathVariable UUID postId,@Valid @ModelAttribute("newCommentary") CommentaryDTO commentary, BindingResult results, Model model){

        if (!results.hasErrors()) {
            commentary.setPostId(postId);
            blogService.newCommentary(commentary);
        }
        model.addAttribute("isAdminConnected", adminService.isAdminConnected());
        return "redirect:/article/"+postId;

    }

    @GetMapping("/admin")
    public String formAdmin(Model model){

        if (adminService.isAdminConnected()) {
            return "admin/control-panel";
        }

        model.addAttribute("isAdminExist",adminService.isAdminExist());
        model.addAttribute("isAdminConnected", adminService.isAdminConnected());
        return "admin/form-admin";
    }

    @PostMapping("/admin")
    public String checkAdmin(@RequestParam String admin, @RequestParam String password) {
        if (adminService.newAdmin(admin,password)) {
            return "redirect:/";
        }
        throw new BadIdException();
    }

    @GetMapping("/disconnect")
    public String disconnect(){
        adminService.disconnect();
        return "redirect:/";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable UUID id) {
        blogService.deletePost(id);
        return "redirect:/";
    }

}
