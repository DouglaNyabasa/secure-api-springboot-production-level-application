package com.pm.secureapispringboot.service;

import com.pm.secureapispringboot.entity.RoleEntity;
import com.pm.secureapispringboot.enums.Authority;

/**
 * @author Douglas Nyabasa
 * @version 1.0
 * @since 25/06/2025
 */

public interface UserService {

    void createUser(String firstname,String lastName,String email, String password);
    RoleEntity getRoleName(String name);
}
