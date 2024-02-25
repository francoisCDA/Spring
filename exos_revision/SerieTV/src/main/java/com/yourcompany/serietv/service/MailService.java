package com.yourcompany.serietv.service;

import com.yourcompany.serietv.entity.Subscription;
import com.yourcompany.serietv.repository.SubscritpionRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;

    private final SubscritpionRepository subscritpionRepository;


    public void subscribe(Subscription mail) {
        subscritpionRepository.save(mail);
    }

    public void unSubscribe(String mail){
        Subscription subscription = subscritpionRepository.findByMailIs(mail);
        if (subscription != null) {
            subscritpionRepository.delete(subscription);
        }

    }

    public void broadcastNewSaison(String serialName) {

        Iterable<Subscription> subscriptions = subscritpionRepository.findAll();

        String subject = "Nouvelle saison pour " + serialName;
        String text = "La nouvelle saison de votre série " + serialName + " a été ajoutée au catalogue";


        for (Subscription sub: subscriptions){
            try {
                sendMail(sub.getMail(),subject,text);
            } catch (MessagingException ignored) {

            }
        }
    }



    private void sendMail(String to, String subject, String text) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text, true);
        javaMailSender.send(message);

    }


}
