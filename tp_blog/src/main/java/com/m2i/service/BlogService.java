package com.m2i.service;

import com.m2i.exception.UnknowPostId;
import com.m2i.entity.Commentary;
import com.m2i.entity.Post;
import com.m2i.repository.CommentaryRepository;
import com.m2i.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class BlogService {

    private final PostRepository postRepository;

    private final CommentaryRepository commentaryRepository;


    public Post newPost(Post post) {
        post.setId(UUID.randomUUID());
        post.setDate(new Date());
        postRepository.save(post);
        return post;
    }


    public Commentary newCommentary(Commentary commentary) {

        Post post = getPostById(commentary.getPostId());

        if (post == null) return null;

        commentary.setId(UUID.randomUUID());
        commentary.setDate(new Date());
        commentaryRepository.save(commentary);
        return commentary;
    }

    public List<Post> getAllPost() {return postRepository.findAll();}

    public List<Commentary> getCommentaryByPostId(UUID postId) {
        return commentaryRepository.findAllByPostIdIs(postId);
    }

    public Post getPostById(UUID postId) { return postRepository.findByIdIs(postId);}

    public Commentary getCommentaryById(UUID id) { return commentaryRepository.findByIdIs(id);};


    public Post editPost(Post newpost){
        Post actualPost = getPostById(newpost.getId());
        if (actualPost == null) { throw new UnknowPostId("Mise à jour impossible"); }

        return postRepository.save(newpost);
    }

    public boolean deletePost(UUID postId) {
        if (postRepository.existsById(postId)) {
            postRepository.deleteById(postId);
            commentaryRepository.removeAllByPostIdIs(postId);
            return true;
        }
        throw new UnknowPostId("Impossible to delete");
    }


}
