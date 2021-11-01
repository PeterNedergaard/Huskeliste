package com.example.huskelistetomcat;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String password;
    private String sessionID;
    private List<String> emner = new ArrayList<>();

    public User(String name, String password, String sessionID){
        this.name = name;
        this.password = password;
        this.sessionID = sessionID;
    }

    public String getSessionID() {
        return sessionID;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public List<String> getEmner() {
        return emner;
    }

    public void setEmner(List<String> emner) {
        this.emner = emner;
    }
}
