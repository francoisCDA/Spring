package com.m2i.repository;

import com.m2i.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {

    Post findByIdIs(UUID id);


}
