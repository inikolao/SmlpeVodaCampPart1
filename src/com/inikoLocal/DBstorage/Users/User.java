package com.inikoLocal.DBstorage.Users;

public class User {

    private int Id;
    private String Username;
    private String Password;
    private String PasswordHash;

    public  User()
    {}

    public User(int id,String User,String Pass)
    {
        this.Id=id;
        this.Username=User;
        this.Password=Pass;
        HashPass(Pass);

    }

    private void HashPass(String password)
    {
        PasswordHash=Integer.toString(password.hashCode());
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

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
