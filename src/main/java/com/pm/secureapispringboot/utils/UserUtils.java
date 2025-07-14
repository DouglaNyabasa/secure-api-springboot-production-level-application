package com.pm.secureapispringboot.utils;

import com.pm.secureapispringboot.entity.RoleEntity;
import com.pm.secureapispringboot.entity.UserEntity;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.apache.commons.lang3.StringUtils.EMPTY;

/**
 * @author Douglas Nyabasa
 * @version 1.0
 * @since 25/06/2025
 */

public class UserUtils {


  public static UserEntity createUserEntity(String firstname, String lastName, String email, RoleEntity role){
      return UserEntity.builder()
              .userId(UUID.randomUUID().toString())
              .firstName(firstname)
              .lastName(lastName)
              .email(email)
              .lastLogin(LocalDateTime.now())
              .accountNonExpired(true)
              .accountNonLocked(true)
              .enabled(false)
              .loginAttempts(0)
              .qrCodeSecret(EMPTY)
              .phoneNumber(EMPTY)
              .bio(EMPTY)
              .imageUrl("https://www.flaticon.com/free-icon/user_149071?term=user&related_id=149071")
              .roles(role)
              .build();
  }
}
