package com.revature.Spendify.services;

import com.revature.Spendify.entities.Order;
import com.revature.Spendify.entities.User;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.TemplateEngine;

import java.nio.charset.StandardCharsets;

@Service
public class EmailService {

    //@Autowired
    private JavaMailSender emailSender;
    //@Autowired
    private TemplateEngine templateEngine;

    private UserService userService;


    //@Autowired
    public EmailService(UserService userService){
        this.userService = userService;
    }


    public void sendOrderConfirmationEmail(Order order) throws MessagingException {
//        Context context = new Context();

        String process = templateEngine.process("orderConfirmation", new Context());

        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, StandardCharsets.UTF_8.name());
//        context.setVariable("user", user.getAccount());
        helper.setTo(order.getAccount().getUser().getEmail());
        helper.setSubject("Order Confirmation");
        helper.setFrom("test@gmail.com");
        helper.setText(process, true);
        System.out.println("before email send");
        emailSender.send(mimeMessage);
    }
}
