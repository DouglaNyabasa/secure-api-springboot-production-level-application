package com.pm.secureapispringboot.repository;

import com.pm.secureapispringboot.entity.CredentialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Douglas Nyabasa
 * @version 1.0
 * @since 25/06/2025
 */
@Repository
public interface CredentialRepository extends JpaRepository<CredentialEntity, Long> {
    Optional<CredentialEntity> getCredentialByUserEntityId(Long userId);
}
