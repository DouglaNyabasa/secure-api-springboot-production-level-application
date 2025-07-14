package com.pm.secureapispringboot.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(NON_DEFAULT)
@Table(name = "users")
public class UserEntity extends Auditable{


    @Column(unique = true, nullable = false,updatable = false)
    private String userId;
    private String firstName;
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;
    private Integer loginAttempts;
    private LocalDateTime lastLogin;
    private String phoneNumber;
    private String bio;
    private String imageUrl;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean mfa;
    private boolean enabled;
    @JsonIgnore
    private String qrCodeSecret;
    @Column(columnDefinition = "text")
    private String qrCodeImageUri;
    @ManyToOne(fetch = EAGER)
    @JoinTable(name = "user_roles",
    joinColumns = @JoinColumn(
            name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id",referencedColumnName = "id"))
    private RoleEntity roles;







}
