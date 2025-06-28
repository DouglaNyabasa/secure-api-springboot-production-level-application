package com.pm.secureapispringboot.service;

import org.springframework.stereotype.Service;

/**
 * @author Douglas Nyabasa
 * @version 1.0
 * @since 25/06/2025
 */


public interface EmailService {

    void sendNewAccountEmail(String name,String email, String token);
    void sendNewPasswordResetEmail(String name, String email,String token);
}
