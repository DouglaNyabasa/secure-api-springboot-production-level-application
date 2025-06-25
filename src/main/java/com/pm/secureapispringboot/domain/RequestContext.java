package com.pm.secureapispringboot.domain;


/**
 * @author Douglas Nyabasa
 * @version 1.0
 * @since 25/06/2025
 */
public class RequestContext {

    private static final ThreadLocal<Long> USER_ID = new ThreadLocal<>();
    private RequestContext() {}

    public static void start(){
        USER_ID.remove();
    }
    public static void setUserId(Long userId){
        USER_ID.set(userId);
    }

    public static Long getUserId() {
        return USER_ID.get();
    }
}
