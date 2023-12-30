package com.example;

import java.util.Properties;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
public class Sender {
    public void send(String[] args){
        //configure Mailtrap's SMTP server details
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", args[2]);
        props.put("mail.smtp.port", "2525");
        //create the Session object
        final String username = args[0];
        final String password = args[1];
        Session session = Session.getInstance(props,
            new jakarta.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            //create a MimeMessage object
            Message message = new MimeMessage(session);
            //set From email field
            message.setFrom(new InternetAddress(args[3]));
            //set To email field
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(args[4]));
            //set email subject field
            message.setSubject("Test Email");
            //set the content of the email message
            message.setText("This is a test email");
            //send the email message
            Transport.send(message);
            System.out.println("Email Message Sent Successfully");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}