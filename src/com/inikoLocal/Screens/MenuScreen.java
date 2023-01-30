package com.inikoLocal.Screens;

import com.inikoLocal.DBstorage.Files.File;
import com.inikoLocal.DBstorage.FilesDB;
import com.inikoLocal.DBstorage.Users.User;
import com.inikoLocal.DBstorage.UsersDB;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class MenuScreen extends Screen{

    private UsersDB usersDB;
    private FilesDB filesDB;
    private String CurrentUser;
    private int fn=-1;
    private ArrayList<String> SubMenuUsers;
    private  UserScreen userScreen;

    public MenuScreen(String user, UsersDB users, FilesDB files)
    {
        super();
        super.getMenuStrings().add("App Menu.\n\n\n\n\n\n\n\n\n\n\n\n");
        super.getMenuStrings().add("Hello "+user);
        this.CurrentUser=user;
        if (user.equals("admin")) {
            this.userScreen=new UserScreen(users,files,user);
            super.getMenuStrings().add("Please select from the following");
            super.getMenuStrings().add("0. UserManagement");
            super.getMenuStrings().add("1. Display All Files");
            super.getMenuStrings().add("2. Edit a File");
            super.getMenuStrings().add("3. Add a new File");
            super.getMenuStrings().add("4. Delete a File");
            super.getMenuStrings().add("5. Search for a File");
            super.getMenuStrings().add("6. Short Files");
            super.getMenuStrings().add("7. Logout");
            super.getMenuStrings().add("8. Terminate App");
        } else {
            super.getMenuStrings().add("Please select from the following");
            super.getMenuStrings().add("1. Display All Files");
            super.getMenuStrings().add("2. Edit a File");
            super.getMenuStrings().add("3. Add a new File");
            super.getMenuStrings().add("4. Delete a File");
            super.getMenuStrings().add("5. Search for a File");
            super.getMenuStrings().add("6. Short Files");
            super.getMenuStrings().add("7. Logout");
            super.getMenuStrings().add("8. Terminate App");

        }
        this.filesDB=files;
        this.usersDB=users;

    }



    public void MenuFunctions() throws IOException {
        boolean flag=false;
        File file=new File();
        switch (fn){
            case 0:
                super.clearScreen();
                DisplayUsers();
                break;
            case 1:
                super.clearScreen();
                DisplayFiles(1);
                break;
            case 2:
                //
                super.clearScreen();
                System.out.println("Give the file id you want to modify");
                super.getSuserInput().reset();
                int idfd=Integer.parseInt(super.getSuserInput().nextLine());

                try {
                    file= (File) filesDB.getById(idfd);
                } catch (Exception e) {
                    System.out.println("File not found");
                    flag=true;
                }
                if (!flag)
                {
                System.out.println("Edit file Name");
                super.getSuserInput().reset();
                file.setFileName(super.getSuserInput().nextLine());
                System.out.println("File edited!");}
                DisplayFiles(0);
                MenuOptionFinalised();
                break;
            case 3:
               filesDB.insert(CreateFile());
                System.out.println("File Created");
                MenuOptionFinalised();
                break;
            case 4:
                System.out.println("Insert Id to delete");
                super.getSuserInput().reset();
                int idDl=Integer.parseInt(super.getSuserInput().nextLine());
                try {
                    DeleteFile(idDl);
                } catch (Exception e) {
                    System.out.println("File not found to Delete");
                    flag=true;
                }
                if(flag!=true)
                {
                    super.clearScreen();
                    System.out.println("File Deleted");}

                break;
            case 5:
                System.out.println("Insert Id to Search");
                super.getSuserInput().reset();
                int idSr=Integer.parseInt(super.getSuserInput().nextLine());
                try {
                    file=SearchFile(idSr);
                } catch (Exception e) {
                    System.out.println("File not found ");
                    flag=true;
                }
                if(flag!=true)
                {
                    super.clearScreen();
                    System.out.println("File Found");
                    System.out.println(file.toString());
                }
                MenuOptionFinalised();

                break;
            case 6:
                super.clearScreen();
                ArrayList<File> filesToShort=filesDB.getAll();
                System.out.println("Shorted files by Name");
                filesToShort= Short(filesToShort);
                DisplayFiles(filesToShort);
                int sl=1;
                do {
                    System.out.println("Save?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                super.getSuserInput().reset();

                flag=false;

                    try {
                        sl=Integer.parseInt(super.getSuserInput().nextLine());
                        flag=true;
                    } catch (NumberFormatException e) {
                        System.out.println("Error in Input");
                        flag=false;
                    }
                } while (flag!=true);
                if (sl==1)
                {
                    filesDB.update(filesToShort);
                    super.clearScreen();
                    System.out.println("File List updated");
                    System.out.println("");
                }

                break;
            case 7:
                super.clearScreen();
                LogingScreen logingScreen=new LogingScreen(usersDB);
                logingScreen.LogingScreenEnabe(logingScreen);
                logingScreen.clearScreen();
                MenuScreen menuScreen=new MenuScreen(logingScreen.getUserName(),usersDB,filesDB);
                menuScreen.MenuScreenEnable(menuScreen);
                break;
            case 8:
                System.exit(0);
                break;
            default:
                throw new IOException("Error in Input");
        }
    }


    public void DisplayFiles(int limit)
    {

        //super.clearScreen();
        int lp=9;
        ArrayList<File> files= filesDB.getAll();
        if(limit!=0)
        {
            lp=files.size();
        }
        //Short(files);

        System.out.println("id\t"+"Filename\t"+"PATH\t");
        System.out.println("");
        for (int i = 0; i < lp; i++) {

            System.out.println(files.get(i).getId()+"\t"+files.get(i).getFileName()+"\t"+"");//files.get(i).getFilePath().toString();

        }

    }
    private void DisplayFiles(ArrayList<File> list)
    {
        System.out.println("id\t"+"Filename\t"+"PATH\t");
        System.out.println("");
        for (int i = 0; i < list.size(); i++) {

            System.out.println(list.get(i).getId()+"\t"+list.get(i).getFileName()+"\t"+"");//files.get(i).getFilePath().toString();

        }

    }

    public void DisplayUsers()
    {
        boolean flag=false;
        ArrayList<User> users= usersDB.getAll();
        System.out.println("id\t"+"User\t"+"Encrypted Pass");
        System.out.println("");
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).getId()+ "\t"+users.get(i).getUsername()+"\t" +users.get(i).getPasswordHash() );

        }
        super.DrawScreen(userScreen.getMenuUsers());
        try {
        userScreen.setUserInput(userScreen.getSuserInput().nextLine());
        userScreen.setFn(Integer.parseInt(userScreen.getUserInput()));

            userScreen.MenuFunctions();
        } catch (Exception e) {
            // e.printStackTrace();
            super.clearScreen();
            System.out.println("Error in input");
           /*if(userScreen.getUserFN()==3)
           {
               break;
           }*/
            //flag=false;
        }
        DisplayUsers();
        MenuOptionFinalised();

    }

    private File CreateFile()
    {
        int newId=filesDB.getAll().get(filesDB.getAll().size()-1).getId()+1;

        System.out.println("Insert New Filename");
        String filename=super.getSuserInput().nextLine();
        System.out.println("Insert New Path");
        String pathS=super.getSuserInput().nextLine();
        Path path= Paths.get(pathS);
        return new File(newId,filename,path);
    }

    private void DeleteFile(int Id)
    {
        filesDB.delete(Id);
    }

    private File SearchFile(int Id) {
       return (File) filesDB.getById(Id);
    }

    public ArrayList<File> Short(ArrayList<File> list)
    {
        list.sort(Comparator.comparing(File::getFileName));

        return list;
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

   public void MenuScreenEnable(MenuScreen menuScreen)
   {
       boolean flag;
       do {
           menuScreen.DrawScreen();
           System.out.println();
           menuScreen.DisplayFiles(1);
           System.out.println("\nGive your Option.");
           try {
           menuScreen.setUserInput(menuScreen.getSuserInput().nextLine());
           menuScreen.setFn(Integer.parseInt(menuScreen.getUserInput()));

               menuScreen.MenuFunctions();
           } catch (Exception e) {
               // e.printStackTrace();
               System.out.println("Error in input");
               System.out.println("Press Any Key To Continue...");
               new java.util.Scanner(System.in).nextLine();
               menuScreen.clearScreen();
               flag=false;
           }
       } while (true);


   }

}
