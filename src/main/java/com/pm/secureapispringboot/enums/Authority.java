package com.pm.secureapispringboot.enums;

import static com.pm.secureapispringboot.contants.Constants.*;

/**
 * @author Douglas Nyabasa
 * @version 1.0
 * @since 25/06/2025
 */
public enum Authority {
    USER(USER_AUTHORITIES),
    ADMIN(ADMIN_AUTHORITIES),
    SUPER_ADMIN(SUPER_ADMIN_AUTHORITIES),
    MANAGER(MANAGER_AUTHORITIES);

    private final String value;
        Authority(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
}
