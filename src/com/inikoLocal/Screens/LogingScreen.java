package com.inikoLocal.Screens;

import com.inikoLocal.DBstorage.Users.User;
import com.inikoLocal.DBstorage.UsersDB;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogingScreen extends Screen {

    private String UserName;
    private String PassWord;
    private UsersDB users;


    public LogingScreen(UsersDB users)
    {
        super();
        super.getMenuStrings().add("Login.\n\n\n\n\n\n\n\n\n\n\n\n");
        super.getMenuStrings().add("UserName:");
        super.getMenuStrings().add("Password:");
        super.getMenuStrings().add("Success");
        super.getMenuStrings().add("Fail");
        this.users=users;
    }
    public boolean Login(String User, String Pass)
    {
        ArrayList<User> usersAll=users.getAll();
       List<User> userCh= usersAll.stream().filter(user -> user.getUsername().equals(User)).collect(Collectors.toList());
       if (userCh.isEmpty())
       {
           return false;
       }
       else
       {
           return userCh.get(0).getPassword().equals(Pass);
       }
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }
}
