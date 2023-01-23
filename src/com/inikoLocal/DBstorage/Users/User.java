package com.inikoLocal.DBstorage.Users;

public class User {

    private String Username;
    private String Password;
    private String PasswordHash;

    public User(String User,String Pass)
    {
        this.Username=User;
        this.Password=Pass;
        HashPass(Pass);

    }

    public void HashPass(String password)
    {
        //
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPasswordHash() {
        return PasswordHash;
    }

    public void setPasswordHash(String passwordHash) {
        PasswordHash = passwordHash;
    }
}
