package com.inikoLocal.Screens;

import com.inikoLocal.DBstorage.Files.File;
import com.inikoLocal.DBstorage.FilesDB;
import com.inikoLocal.DBstorage.Users.User;
import com.inikoLocal.DBstorage.UsersDB;

import java.io.IOException;
import java.util.ArrayList;

public class MenuScreen extends Screen{

    private UsersDB usersDB;
    private FilesDB filesDB;
    private int fn=-1;
    private ArrayList<String> SubMenuUsers;
    private  UserScreen userScreen;

    public MenuScreen(String user, UsersDB users, FilesDB files)
    {
        super();
        super.getMenuStrings().add("App Menu.\n\n\n\n\n\n\n\n\n\n\n\n");
        super.getMenuStrings().add("Hello "+user);
        if (user.equals("admin")) {
            this.userScreen=new UserScreen(users,files);
            super.getMenuStrings().add("Please select from the following");
            super.getMenuStrings().add("0. UserManagement");
            super.getMenuStrings().add("1. Display All Files");
            super.getMenuStrings().add("2. Edit a Product");
            super.getMenuStrings().add("3. Add a new Product");
            super.getMenuStrings().add("4. Delete a Product");
            super.getMenuStrings().add("5. Search for a product");
            super.getMenuStrings().add("6.Logout");
        } else {
            super.getMenuStrings().add("Please select from the following");
            super.getMenuStrings().add("1. Display All Files");
            super.getMenuStrings().add("2. Edit a Product");
            super.getMenuStrings().add("3. Add a new Product");
            super.getMenuStrings().add("4. Delete a Product");
            super.getMenuStrings().add("5. Search for a product");
            super.getMenuStrings().add("6.Logout");

        }
        this.filesDB=files;
        this.usersDB=users;

    }



    public void MenuFunctions() throws IOException {
        switch (fn){
            case 0:
                DisplayUsers();
                break;
            case 1:
                //
                break;
            case 2:
                //
                break;
            case 3:
                //
                break;
            case 4:
                //
                break;
            case 5:
                //
                break;
            case 6:
                //
                break;
            default:
                throw new IOException("Error in Input");
        }
    }


    public void DisplayFiles()
    {
        super.clearScreen();
        ArrayList<File> files= filesDB.getAll();
        Short(files);
        for (int i = 0; i < files.size(); i++) {

        }

    }
    public void DisplayUsers()
    {
        ArrayList<User> users= usersDB.getAll();
        System.out.println("id\t"+"User\t"+"Encrypted Pass");
        System.out.println("");
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).getId()+ "\t"+users.get(i).getUsername()+"\t" +users.get(i).getPasswordHash() );

        }

        super.DrawScreen(userScreen.getMenuUsers());
        userScreen.setUserInput(userScreen.getSuserInput().nextLine());
        userScreen.setFn(Integer.parseInt(userScreen.getUserInput()));
        try {
            userScreen.MenuFunctions();
        } catch (IOException e) {
            // e.printStackTrace();
            System.out.println("Error in input");
            DisplayUsers();
            //flag=false;
        }

        MenuOptionFinalised();

    }
    public void Short(ArrayList<?> list)
    {


    }

    public void setFn(int fn) {
        this.fn = fn;
    }

    private void MenuOptionFinalised()
    {
        super.getContinueP();
        super.getSuserInput().nextLine();
        super.clearScreen();
    }

}
