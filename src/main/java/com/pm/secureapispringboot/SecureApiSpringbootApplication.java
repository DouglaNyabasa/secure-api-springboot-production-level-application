package com.pm.secureapispringboot;

import com.pm.secureapispringboot.domain.RequestContext;
import com.pm.secureapispringboot.entity.RoleEntity;
import com.pm.secureapispringboot.enums.Authority;
import com.pm.secureapispringboot.repository.RoleRepository;
import com.pm.secureapispringboot.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class SecureApiSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecureApiSpringbootApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(RoleRepository roleRepository, UserRepository userRepository) {
        return args -> {
            RequestContext.setUserId(0L);
            var userRole = new RoleEntity();
            userRole.setRoleName(Authority.USER.name());
            userRole.setAuthorities(Authority.USER);
            roleRepository.save(userRole);

            var adminRole = new RoleEntity();
            adminRole.setRoleName(Authority.ADMIN.name());
            adminRole.setAuthorities(Authority.ADMIN);
            roleRepository.save(adminRole);
            RequestContext.start();
        };
    }

}


