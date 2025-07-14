package com.pm.secureapispringboot.service.impl;

import com.pm.secureapispringboot.Exception.ApiException;
import com.pm.secureapispringboot.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;



/**
 * @author Douglas Nyabasa
 * @version 1.0
 * @since 25/06/2025
 */
@Service
@Slf4j
public class EmailServiceImplementation implements EmailService {

    private static final String NEW_USER_ACCOUNT_VERIFICATION = "New User Account Verification";
    private static final String PASSWORD_RESET_REQUEST = "Reset Password Request";
    private final JavaMailSender sender;
    @Value("${spring.mail.verify.host}")
    private String host;
    @Value("${spring.mail.username}")
    private String fromEmail;


    public EmailServiceImplementation(JavaMailSender sender) {
        this.sender = sender;
    }


    @Override
    @Async
    public void sendNewAccountEmail(String name, String email, String token) {
        try {
           var message = new SimpleMailMessage();
           message.setSubject(NEW_USER_ACCOUNT_VERIFICATION);
           message.setFrom(fromEmail);
           message.setTo(email);
           message.setText(getEmailMessage(name,host,token));
        }catch (Exception exception){
//           log.error(exception.getMessage());
           throw new ApiException("Error sending new account email");
        }

    }

  


    @Override
    @Async
    public void sendNewPasswordResetEmail(String name, String email, String token) {
        try {
            var message = new SimpleMailMessage();
            message.setSubject(PASSWORD_RESET_REQUEST);
            message.setFrom(fromEmail);
            message.setTo(email);
            message.setText(getResetPasswordMessage(name,host,token));
        }catch (Exception exception){
//            log.error(exception.getMessage());
            throw new ApiException("Error sending new account email");
        }

    }


    public String getResetPasswordMessage(String name, String host, String token) {

        return "Hello " + name + "\n\n Your new account has been created. Press the link below to verify account. \n\n"+
                getPasswordUrl(host,token) +"\n\n The Support Team";
    }

    private String getPasswordUrl(String host, String token) {
        return host + "/verify/account?token=" + token;
    }




    public String getEmailMessage(String name, String host, String token) {

        return "Hello " + name + "\n\n Your new account has been created. Press the link below to verify account. \n\n"+
                getVerification(host,token) +"\n\n The Support Team";
    }

    private String getVerification(String host, String token) {
        return host + "/verify/account?token=" + token;
    }


}
