package com.inikoLocal;

import com.inikoLocal.DBstorage.FilesDB;
import com.inikoLocal.DBstorage.UsersDB;
import com.inikoLocal.Screens.InitalScreen;
import com.inikoLocal.Screens.LogingScreen;
import com.inikoLocal.Screens.MenuScreen;
import com.inikoLocal.Screens.Screen;
import com.inikoLocal.Utils.Initaliser;
import sun.misc.Signal;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /*Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            Signal.handle(new Signal("INT"),  // SIGINT
                    signal -> System.out.println("Interrupted by Ctrl+C"));}));*/

        //
        Initaliser initaliser=new Initaliser();
        FilesDB files=initaliser.getFiles();
        UsersDB users=initaliser.getUsers();

        InitalScreen screen=new InitalScreen();
        screen.clearScreen();
        screen.DrawScreen();
        screen.getContinueP();
        do {
            ///System.out.print("\b\b\b\b\b");
            screen.setUserInput(screen.getSuserInput().nextLine());
            //System.out.println("koita: "+screen.getUserInput());
            //boolean ppl=(screen.getUserInput().isBlank())|(screen.getUserInput().isEmpty());
            //System.out.println("koita OR: "+ppl);

        } while (screen.getUserInput().isEmpty());
        screen.clearScreen();


        LogingScreen logingScreen=new LogingScreen(users);

        boolean flag;
        do {
            logingScreen.GetMenu(0);
            logingScreen.GetMenu(1);
            logingScreen.setUserName(logingScreen.getSuserInput().nextLine());
            logingScreen.GetMenu(2);
            logingScreen.setPassWord(logingScreen.getSuserInput().nextLine());
            logingScreen.clearScreen();
            flag=logingScreen.Login(logingScreen.getUserName(), logingScreen.getPassWord());
            if(flag)
            {
                logingScreen.GetMenu(3);
            }
            else
            {
                logingScreen.GetMenu(4);

            }
            //logingScreen.clearScreen();
        } while (!flag);
        logingScreen.clearScreen();
        MenuScreen menuScreen=new MenuScreen(logingScreen.getUserName(),users,files);
        do {
            menuScreen.DrawScreen();
            System.out.println();
            menuScreen.DisplayFiles();
            System.out.println("\nGive your Option.");
            menuScreen.setUserInput(menuScreen.getSuserInput().nextLine());
            menuScreen.setFn(Integer.parseInt(menuScreen.getUserInput()));
            try {
                menuScreen.MenuFunctions();
            } catch (IOException e) {
               // e.printStackTrace();
                System.out.println("Error in input");
                menuScreen.clearScreen();
                flag=false;
            }
        } while (true);


    }
}
