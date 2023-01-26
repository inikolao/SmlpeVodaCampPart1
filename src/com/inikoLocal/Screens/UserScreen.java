package com.inikoLocal.Screens;

import com.inikoLocal.DBstorage.FilesDB;
import com.inikoLocal.DBstorage.Users.User;
import com.inikoLocal.DBstorage.UsersDB;

import java.io.IOException;
import java.util.ArrayList;

public class UserScreen extends Screen {

    private UsersDB usersDB;
    private FilesDB filesDB;
    private ArrayList<String> MenuUsers;
    int userFN = -1;

    public UserScreen(UsersDB users, FilesDB files) {
        super();
        MenuUsers.add("User Menu.\n\n\n\n\n\n\n\n\n\n\n\n");
        MenuUsers.add("1. Add User");
        MenuUsers.add("2. Delete User");
        MenuUsers.add("3. Return");
        this.filesDB=files;
        this.usersDB=users;

    }

    public void MenuFunctions() throws IOException {
        switch (userFN) {
            case 1:
                usersDB.insert(CreateUser());
                break;
            case 2:
                int idDl=Integer.parseInt(super.getSuserInput().nextLine());
                DeleteUser(idDl);
                //
                break;
            case 3:
                //
                break;
            default:
                throw new IOException("Error in Input");
        }
    }
    private User CreateUser()
    {
        int newId=usersDB.getAll().get(usersDB.getAll().size()-1).getId()+1;
        User user=new User();
        System.out.println("Insert New Username");
        user.setUsername(super.getSuserInput().nextLine());
        System.out.println("Insert New Password");
        user.setPassword(super.getSuserInput().nextLine());
        user.setId(newId);
        return user;
    }
    private void DeleteUser(int id)
    {
        usersDB.delete(id);


    }

    public void setFn(int userFN) {
        this.userFN = userFN;
    }

    public ArrayList<String> getMenuUsers() {
        return MenuUsers;
    }
}
