package com.pm.secureapispringboot.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pm.secureapispringboot.enums.Authority;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

/**
 * @author Douglas Nyabasa
 * @version 1.0
 * @since 25/06/2025
 */

@Entity
@ToString
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(NON_DEFAULT)
@Table(name = "roles")
public class RoleEntity extends Auditable{


    private String roleName;
    private Authority authorities;


}
