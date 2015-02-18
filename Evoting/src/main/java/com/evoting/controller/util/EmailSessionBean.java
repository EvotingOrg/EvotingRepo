/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evoting.controller.util;


import com.evoting.enums.Protocol;
import java.util.Date;
import java.util.Properties;
import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author ASHOK
 */
@Stateless
@LocalBean
public class EmailSessionBean {
    private int port = 465;
    private String host = "smtp.gmail.com";   
    private boolean auth = true;
    private String username = "ashok.crossover@gmail.com";
    private String password = "crossover123";
    private Protocol protocol = Protocol.SMTPS;
    private boolean debug = true;

    @Asynchronous
    public void sendEmail(String to, String from, String subject, String body) {        
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);        
        switch (protocol) {
            case SMTPS:
                props.put("mail.smtp.ssl.enable", true);
                break;
            case TLS:
                props.put("mail.smtp.starttls.enable", true);
                break;
        }
        
        Authenticator authenticator = null;
        if (auth) {
            props.put("mail.smtp.auth", true);
            authenticator = new Authenticator() {
                private PasswordAuthentication pa = new PasswordAuthentication(username, password);
                @Override
                public PasswordAuthentication getPasswordAuthentication() {
                    return pa;
                }
            };
        }
        
        Session session = Session.getInstance(props, authenticator);
        session.setDebug(debug);
        
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            message.setRecipients(Message.RecipientType.TO, address);
            message.setSubject(subject);
            message.setSentDate(new Date());
            
            //message.setText(body);
            Multipart multipart = new MimeMultipart("alternative");
            
            MimeBodyPart textPart = new MimeBodyPart();
            String textContent = body;
            textPart.setText(textContent);
            
            MimeBodyPart htmlPart = new MimeBodyPart();
            String htmlContent = body;
            htmlPart.setContent(htmlContent, "text/html");
            
            multipart.addBodyPart(textPart);
            multipart.addBodyPart(htmlPart);
            message.setContent(multipart);
            
            Transport.send(message);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }
}
