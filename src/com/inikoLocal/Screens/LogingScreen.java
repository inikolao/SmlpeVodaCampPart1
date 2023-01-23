package com.inikoLocal.Screens;

import com.inikoLocal.DBstorage.Users.User;
import com.inikoLocal.DBstorage.UsersDB;

public class LogingScreen extends Screen {

    private String UserName;
    private String PassWord;


    public LogingScreen(UsersDB users)
    {
        super();
        super.getMenuStrings().add("Login.\n\n\n\n\n\n\n\n\n\n\n\n");
        super.getMenuStrings().add("UserName:");
        super.getMenuStrings().add("Password:");
        super.getMenuStrings().add("Success");
        super.getMenuStrings().add("Fail");

    }
    public boolean Login(String User, String Pass)
    {


        return false;
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
