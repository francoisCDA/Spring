package org.example.exo_chat.repository;

import org.example.exo_chat.entity.Message;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends R2dbcRepository<Message, Long> {



}
