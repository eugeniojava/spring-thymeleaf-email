package com.eugeniojava.springthymeleafemail;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.mail.MessagingException;

@RestController
@RequestMapping("/send-email")
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public String sendEmail() throws MessagingException {
        var user = new User("Eugênio", "eugeniojava", "eugeniojava@outlook.com");
        return emailService.sendEmail(user);
    }
}
