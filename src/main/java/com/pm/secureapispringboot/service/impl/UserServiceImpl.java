package com.pm.secureapispringboot.service.impl;

import com.pm.secureapispringboot.Exception.ApiException;
import com.pm.secureapispringboot.entity.ConfirmationEntity;
import com.pm.secureapispringboot.entity.CredentialEntity;
import com.pm.secureapispringboot.entity.RoleEntity;
import com.pm.secureapispringboot.entity.UserEntity;
import com.pm.secureapispringboot.enums.Authority;
import com.pm.secureapispringboot.enums.EventType;
import com.pm.secureapispringboot.event.UserEvent;
import com.pm.secureapispringboot.repository.ConfirmationRepository;
import com.pm.secureapispringboot.repository.CredentialRepository;
import com.pm.secureapispringboot.repository.RoleRepository;
import com.pm.secureapispringboot.repository.UserRepository;
import com.pm.secureapispringboot.service.UserService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.pm.secureapispringboot.utils.UserUtils.createUserEntity;

/**
 * @author Douglas Nyabasa
 * @version 1.0
 * @since 25/06/2025
 */

@Service
@Transactional(rollbackOn = Exception.class)
@Slf4j
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final CredentialRepository credentialRepository;
//    private final BCryptPasswordEncoder encoder;
    private final ConfirmationRepository confirmationRepository;
    private final ApplicationEventPublisher publisher;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, CredentialRepository credentialRepository,  ConfirmationRepository confirmationRepository, ApplicationEventPublisher publisher) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.credentialRepository = credentialRepository;
        this.confirmationRepository = confirmationRepository;
        this.publisher = publisher;
    }


    @Override
    public void createUser(String firstname, String lastName, String email, String password) {
       var userEntity = userRepository.save(createNewUser(firstname,lastName,email));
       var credentialEntity = new CredentialEntity(userEntity,password);
       credentialRepository.save(credentialEntity);
       var confirmationEntity = new ConfirmationEntity(userEntity);
       confirmationRepository.save(confirmationEntity);
       publisher.publishEvent(new UserEvent(userEntity, EventType.REGISTRATION, Map.of("key",confirmationEntity.getKey())));

    }

    @Override
    public RoleEntity getRoleName(String name) {
        var role = roleRepository.findByRoleNameIgnoreCase(name);
        return role.orElseThrow(() -> new ApiException("Role not found"));
    }

    private UserEntity createNewUser(String firstname, String lastName, String email) {

        var role = getRoleName(Authority.USER.name());
        return  createUserEntity(firstname,lastName,email, role);

    }


}
