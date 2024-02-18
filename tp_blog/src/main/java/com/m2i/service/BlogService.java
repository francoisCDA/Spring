package com.m2i.service;

import com.m2i.model.Commentary;
import com.m2i.model.Post;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BlogService {

    private Map<UUID, Post> articles;

    private Map<UUID, Commentary> commentaries;

    public BlogService() {
        articles = new HashMap<>();
        commentaries = new HashMap<>();
    }


    public Post newPost(Post post) {
        post.setId(UUID.randomUUID());
        post.setDate(new Date());
        articles.put(post.getId(),post);
        return post;
    }


    public Commentary newCommentary(Commentary commentary) {

        Post post = getPostById(commentary.getPostId());

        if (post == null) return null;

        commentary.setId(UUID.randomUUID());
        commentary.setDate(new Date());
        commentaries.put(commentary.getId(),commentary);
        return commentary;
    }

    public List<Post> getAllPost() {return articles.values().stream().toList();}

    public List<Commentary> getCommentaryByPostId(UUID id) {

        return commentaries.values().stream().filter(commentary -> commentary.getPostId().equals(id)).toList();

    }

    public Post getPostById(UUID id) { return articles.get(id);}

    public Commentary getCommentaryById(UUID id) { return commentaries.get(id);};


    public Post editPost(Post newpost){
        Post actualPost = getPostById(newpost.getId());
        if (actualPost != null) {
            return  newPost(newpost);
        }
        return null;
    }

    public boolean deletePost(UUID id) {
        Post post = articles.remove(id);
        return post != null;
    }


}
