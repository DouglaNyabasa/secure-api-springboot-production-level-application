package com.pm.secureapispringboot.enums.converter;

import com.pm.secureapispringboot.enums.Authority;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

/**
 * @author Douglas Nyabasa
 * @version 1.0
 * @since 25/06/2025
 */

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Authority,String> {
    @Override
    public String convertToDatabaseColumn(Authority authority) {
        if (authority == null) {
            return null;
        }

        return authority.getValue();
    }

    @Override
    public Authority convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }
        return Stream.of(Authority.values())
                .filter(authority -> authority.getValue().equals(code))
                .findFirst().orElseThrow(IllegalAccessError::new);
    }
}
