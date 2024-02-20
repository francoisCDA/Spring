package com.m2i.service;

import com.m2i.dto.CommentaryDTO;
import com.m2i.dto.PostDTO;
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


    public PostDTO newPost(PostDTO postDto) {

        Post newPost = Post.builder()
                .article(postDto.getArticle())
                .title(postDto.getTitle())
                .description(postDto.getDescription())
                .id(UUID.randomUUID())
                .date(new Date())
                .build();
        postRepository.save(newPost);

        return newPost.toPostDTO();
    }


    public CommentaryDTO newCommentary(CommentaryDTO commentaryDto) {

        Post post = postRepository.findByIdIs(commentaryDto.getPostId());

        if (post == null) throw new UnknowPostId("Le post a été supprimé");

        Commentary newCommentary = Commentary.builder()
                .postId(commentaryDto.getPostId())
                .auteur(commentaryDto.getAuteur())
                .email(commentaryDto.getEmail())
                .message(commentaryDto.getMessage())
                .id(UUID.randomUUID())
                .date(new Date())
                .build();

        commentaryRepository.save(newCommentary);
        return newCommentary.toCommentaryDto();
    }

    public List<PostDTO> getAllPost() {
        return postRepository.findAll().stream().map(Post::toPostDTO).toList();
    }

    public List<CommentaryDTO> getCommentaryByPostId(UUID postId) {
        return commentaryRepository.findAllByPostIdIs(postId).stream().map(Commentary::toCommentaryDto).toList();
    }

    public PostDTO getPostById(UUID postId) { return postRepository.findByIdIs(postId).toPostDTO();}

    public CommentaryDTO getCommentaryById(UUID id) { return commentaryRepository.findByIdIs(id).toCommentaryDto();};


    public PostDTO editPost(PostDTO updPost){
        Post actualPost = postRepository.findByIdIs(updPost.getId());
        if (actualPost == null) { throw new UnknowPostId("Mise à jour impossible"); }

        actualPost.setTitle(updPost.getTitle());
        actualPost.setArticle(updPost.getArticle());
        actualPost.setDescription(updPost.getDescription());

        return postRepository.save(actualPost).toPostDTO();
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
