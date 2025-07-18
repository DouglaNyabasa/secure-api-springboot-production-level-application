package com.pm.secureapispringboot.repository;

import com.pm.secureapispringboot.entity.ConfirmationEntity;
import com.pm.secureapispringboot.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Douglas Nyabasa
 * @version 1.0
 * @since 25/06/2025
 */
@Repository
public interface ConfirmationRepository extends JpaRepository<ConfirmationEntity,Long> {

    Optional<ConfirmationEntity> findByKey(String key);
    Optional<ConfirmationEntity> findByUserEntity(UserEntity userEntity);

}
