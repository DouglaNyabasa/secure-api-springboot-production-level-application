package com.pm.secureapispringboot.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.util.Map;

/**
 * @author Douglas Nyabasa
 * @version 1.0
 * @since 25/06/2025
 */


@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public record Response(String time, int code, String path, HttpStatus status, String message, String exception,
                       Map<?,?> data) {
}
