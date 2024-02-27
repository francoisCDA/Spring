package org.example.exo_chat.dao;

import io.r2dbc.spi.ConnectionFactory;
import org.example.exo_chat.entity.Message;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class MessageDAO {

    private final ConnectionFactory connectionFactory;

    private DatabaseClient databaseClient;

    public MessageDAO(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
        databaseClient = DatabaseClient.create(connectionFactory);
        Mono result = databaseClient
                .sql("CREATE TABLE If NOT EXISTS message(id long primary key auto_increment, author varchar(30), message varchar(200));")
                .then().doOnSuccess((Void) ->  {
                    System.out.println("Création de la table OK");
                }).doOnError((Void) ->  {
                    System.out.println("Création de la table Not OK");
                });

        result.subscribe();
    }

    public Mono add(Message message) {
        Mono result = databaseClient.sql("INSERT INTO message (author, message) values (:author,:message)")
                .bind("author",message.getAuthor())
                .bind("message",message.getMessage())
                .then();
        return result;
    }

    public Flux<Message> getConversation() {
        Flux<Message> retour = databaseClient.sql("SELECT * FROM message")
                .fetch()
                .all()
                .map(m -> new Message(Long.valueOf(m.get("id").toString()), m.get("author").toString(), m.get("message").toString() ));

        return retour;
    }

}
