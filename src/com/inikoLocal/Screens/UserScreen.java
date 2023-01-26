package com.inikoLocal.Screens;

import com.inikoLocal.DBstorage.FilesDB;
import com.inikoLocal.DBstorage.Users.User;
import com.inikoLocal.DBstorage.UsersDB;

import java.io.IOException;
import java.util.ArrayList;

public class UserScreen extends Screen {

    private UsersDB usersDB;
    private FilesDB filesDB;
    private ArrayList<String> MenuUsers=new ArrayList<>();
    private int userFN = -1;

    public UserScreen(UsersDB users, FilesDB files) {
        super();
        MenuUsers.add("User Menu.\n\n");
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
                System.out.println("User Created");
                break;
            case 2:
                System.out.println("Insert Id to delete");
                super.getSuserInput().reset();
                int idDl=Integer.parseInt(super.getSuserInput().nextLine());
                DeleteUser(idDl);
                System.out.println("User Deleted");
                //
                break;
            default:
                throw new IOException("Error in Input");
        }
    }
    private User CreateUser()
    {
        int newId=usersDB.getAll().get(usersDB.getAll().size()-1).getId()+1;

        System.out.println("Insert New Username");
        String uname=super.getSuserInput().nextLine();
        System.out.println("Insert New Password");
        String upass=super.getSuserInput().nextLine();
        return new User(newId,uname,upass);
    }
    private void DeleteUser(int id)
    {
        usersDB.delete(id);


    }

    public void setFn(int userFN) {
        this.userFN = userFN;
    }

    public int getUserFN() {
        return userFN;
    }

    public ArrayList<String> getMenuUsers() {
        return MenuUsers;
    }
}
