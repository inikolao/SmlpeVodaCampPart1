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

        for (int i = 0; i <screen.getMenuStrings().size() ; i++) {

            screen.GetMenu(i);
        }
        screen.getContinueP();
        do {
            System.out.print("\b\b\b\b\b");
            screen.setUserInput(screen.getSuserInput().nextLine()+"\r");

        } while (screen.getUserInput().isEmpty()||screen.getUserInput().isBlank());
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

        MenuScreen menuScreen=new MenuScreen();






    }
}
