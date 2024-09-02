package com.athreya.multi_tenancy;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

public class UserContext {
    private static ThreadLocal<String> user = new ThreadLocal<>();

    public static void setUser(String userID){
        user.set(userID);
    }

    public static String getUser(){
        return user.get();
    }
}
