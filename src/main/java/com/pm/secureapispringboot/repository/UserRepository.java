package com.pm.secureapispringboot.repository;

import com.pm.secureapispringboot.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Douglas Nyabasa
 * @version 1.0
 * @since 25/06/2025
 */

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findUserByUserId(String UserId);
    Optional<UserEntity> findByEmailIgnoreCase(String email);
}
