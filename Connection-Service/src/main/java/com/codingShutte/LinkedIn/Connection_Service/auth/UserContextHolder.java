package com.codingShutte.LinkedIn.Connection_Service.auth;

public class UserContextHolder {

    private static final ThreadLocal<Long> currentUserId = new ThreadLocal<>();

    static void setCurrentUserId(Long userId){
        currentUserId.set(userId);
    }

    public static Long getCurrentUserId(){
        return currentUserId.get();
    }

    static void clear(){
        currentUserId.remove();
    }

}
