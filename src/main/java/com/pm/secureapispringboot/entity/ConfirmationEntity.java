package com.pm.secureapispringboot.entity;


import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;
import static jakarta.persistence.FetchType.EAGER;

/**
 * @author Douglas Nyabasa
 * @version 1.0
 * @since 25/06/2025
 */

@Entity
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(NON_DEFAULT)
@Table(name = "confirmations")
public class ConfirmationEntity extends Auditable{

    private String key;


    @OneToOne(targetEntity = UserEntity.class, fetch = EAGER)
    @JoinColumn( name = "user_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("user_id")
    private  UserEntity userEntity;

    public ConfirmationEntity( UserEntity userEntity) {

        this.userEntity = userEntity;
        this.key = UUID.randomUUID().toString();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
