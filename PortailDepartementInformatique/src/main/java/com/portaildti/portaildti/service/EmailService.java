package com.portaildti.portaildti.service;

//import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    public void envoyerCourriel(String to, String subject, String body, LocalDate date, LocalTime heure) throws  javax.mail.MessagingException {

        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom("dti.collegerosemont@outlook.com");
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject(subject);

        String dateTimeText = "Date de Rendez-vous: " + date + ", Heure de Rendez-vous: " + heure;
        mimeMessageHelper.setText(dateTimeText + "\n\n" + body);

        //File saveFile = new File(fileToAttach);
        //System.out.println("saveFile ds: " + saveFile.getAbsolutePath());
        //FileSystemResource fileSystemResource=
        //new FileSystemResource(new File(fileToAttach));
        //            mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),
//                    fileSystemResource);
        javaMailSender.send(mimeMessage);

        System.out.printf("Le message avec pièce jointe a été envoyé avec succès à " + to);

    }

    public void envoyerCourrielGeneral(String to, String subject, String body) throws javax.mail.MessagingException {

        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom("dti.collegerosemont@outlook.com");
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject(subject);

        javaMailSender.send(mimeMessage);

        System.out.printf("Le message avec pièce jointe a été envoyé avec succès à " + to);

    }
}
