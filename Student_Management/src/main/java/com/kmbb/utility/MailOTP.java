package com.kmbb.utility;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class MailOTP {
	private final static String SUB="KMBB CET";
	
//	public static void main(String[] args) {
//		send("manamohan056@gmail.com", "hgdfhdgfhd");
//	}
	public static void send(String to,String msg){  
		final String FROM="manamohan1999@gmail.com";
        //Get properties object    
        Properties props = new Properties();    
        props.put("mail.smtp.host", "smtp.gmail.com");    
        props.put("mail.smtp.socketFactory.port", "465");    
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");    
        props.put("mail.smtp.auth", "true");    
        props.put("mail.smtp.port", "465");    
        //get Session   
        Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {    
         protected javax.mail.PasswordAuthentication getPasswordAuthentication() {    
         return new javax.mail.PasswordAuthentication(FROM,"kaqfyylmpqzukrhm");  
         }    
        });    
        //compose message    
        try {    
         MimeMessage message = new MimeMessage(session); 
         message.setFrom(new InternetAddress(FROM));
         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
         message.setSubject(SUB);    
         message.setText("Your password: "+msg);    
         //send message  
         Transport.send(message);    
         System.out.println("message sent successfully");  
        } catch (MessagingException e) {
        	throw new RuntimeException(e);
        }
           
  }  
}
