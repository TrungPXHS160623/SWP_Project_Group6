/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Admin
 */
public class SendEmail {

    public void sendEmail(String toMail, String Sub, String msg) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Xác thực tài khoản email
        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("anhbthe170035@fpt.edu.vn", "lsfr lyaj hvng dqki");
            }
          });

        try {
            // Tạo một đối tượng MimeMessage
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("anhbthe170035@fpt.edu.vn"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(toMail));
            message.setSubject(Sub);
            message.setText(msg);
            
            // Gửi email
            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    
    public String getRandom() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }
    
//    public static void main(String[] args) {
//        SendEmail send = new SendEmail();
//        send.sendEmail("tienanhbkp03@gmail.com", "Code to verify email", send.getRandom());
//    }
}
