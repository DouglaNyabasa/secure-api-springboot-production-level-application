package com.pm.secureapispringboot.repository;

import com.pm.secureapispringboot.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Douglas Nyabasa
 * @version 1.0
 * @since 25/06/2025
 */
@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    Optional<RoleEntity> findByRoleNameIgnoreCase(String name);
}
