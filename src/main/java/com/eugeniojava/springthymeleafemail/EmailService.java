package com.eugeniojava.springthymeleafemail;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import javax.mail.MessagingException;

@Service
public class EmailService {
    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    public EmailService(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }

    public String sendEmail(User user) throws MessagingException {
        var context = new Context();
        context.setVariable("user", user);
        var process = templateEngine.process("emails/welcome", context);
        var mimeMessage = javaMailSender.createMimeMessage();
        var mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        mimeMessageHelper.setSubject("Welcome, " + user.getName());
        mimeMessageHelper.setText(process, true);
        mimeMessageHelper.setTo(user.getEmail());
        javaMailSender.send(mimeMessage);
        return "Email sent successfully";
    }
}
