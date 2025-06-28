package com.pm.secureapispringboot.event;

import com.pm.secureapispringboot.entity.UserEntity;
import com.pm.secureapispringboot.enums.EventType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @author Douglas Nyabasa
 * @version 1.0
 * @since 25/06/2025
 */
@Getter
@Setter
@AllArgsConstructor
public class UserEvent {

    private UserEntity userEntity;
    private EventType type;
    private Map<?,?> data;
}
