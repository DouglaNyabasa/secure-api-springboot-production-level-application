package com.pm.secureapispringboot.utils;

import com.pm.secureapispringboot.domain.Response;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.EMPTY;

/**
 * @author Douglas Nyabasa
 * @version 1.0
 * @since 25/06/2025
 */

public class RequestUtils {
    public static Response getResponse(HttpServletRequest request, Map<?,?> data, String message, HttpStatus status ) {
     return new Response(LocalDateTime.now().toString(),status.value(),request.getRequestURI(),HttpStatus.valueOf(status.value()),message,EMPTY,data);
    }
}
