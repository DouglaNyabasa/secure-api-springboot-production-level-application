package com.pm.secureapispringboot.event;

import com.pm.secureapispringboot.entity.UserEntity;
import com.pm.secureapispringboot.enums.EventType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

/**
 * @author Douglas Nyabasa
 * @version 1.0
 * @since 25/06/2025
 */



public class UserEvent {

    private UserEntity userEntity;
    private EventType type;
    private Map<?,?> data;

    public UserEvent() {
    }

    public UserEvent(UserEntity userEntity, EventType type, Map<?, ?> data) {
        this.userEntity = userEntity;
        this.type = type;
        this.data = data;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public Map<?, ?> getData() {
        return data;
    }

    public void setData(Map<?, ?> data) {
        this.data = data;
    }
}
