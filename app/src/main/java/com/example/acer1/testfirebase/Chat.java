package com.example.acer1.testfirebase;

/**
 * Created by Acer1 on 01/11/2015.
 */
public class Chat {
    public String user;
    public String message;

    //deserialisasi firebase, merubah objek jackson > kson


    public Chat() {
    }

    public Chat(String user, String message) {
        this.user = user;
        this.message = message;
    }
}
