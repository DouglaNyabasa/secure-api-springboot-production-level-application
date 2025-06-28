package com.pm.secureapispringboot.event.listener;

import com.pm.secureapispringboot.event.UserEvent;
import com.pm.secureapispringboot.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author Douglas Nyabasa
 * @version 1.0
 * @since 25/06/2025
 */

@Component
@RequiredArgsConstructor
public class UserEventListener {

    private final EmailService emailService;

    @EventListener
    public void onUserEvent(UserEvent event) {
        switch (event.getType()){
            case REGISTRATION -> emailService.sendNewAccountEmail(
                    event.getUserEntity().getFirstName(),event.getUserEntity().getEmail(),(String) event.getData().get("key")
            );
            case RESETPASSWORD ->  emailService.sendNewPasswordResetEmail(
                    event.getUserEntity().getFirstName(),event.getUserEntity().getEmail(),(String) event.getData().get("key")
            );
            default -> { }
        }
    }
}
