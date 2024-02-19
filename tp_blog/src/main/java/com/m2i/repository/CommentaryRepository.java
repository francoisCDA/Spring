package com.m2i.repository;

import com.m2i.entity.Commentary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CommentaryRepository extends JpaRepository<Commentary, UUID> {

    List<Commentary> findAllByPostIdIs(UUID postID);

    void removeAllByPostIdIs(UUID postID);

    Commentary findByIdIs( UUID commentaryID);

}
