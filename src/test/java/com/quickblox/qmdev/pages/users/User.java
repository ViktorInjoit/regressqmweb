package com.quickblox.qmdev.pages.users;

public abstract class User {

    private String email;
    private String testPass;
    private String tempPass;

    public User(String email, String testPass, String tempPass) {
        this.email = email;
        this.testPass = testPass;
        this.tempPass = tempPass;
    }

    public String getEmail() {
        return email;
    }

    public String getTestPass() {
        return testPass;
    }

    public String getTempPass() {
        return tempPass;
    }
}
