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
	
        Initaliser initaliser=new Initaliser();
        FilesDB files=initaliser.getFiles();
        UsersDB users=initaliser.getUsers();

        InitalScreen screen=new InitalScreen();
        screen.clearScreen();
        screen.DrawScreen();
        screen.getContinueP();
        do {
            screen.setUserInput(screen.getSuserInput().nextLine());


        } while (screen.getUserInput().isEmpty());
        screen.clearScreen();


        LogingScreen logingScreen=new LogingScreen(users);

        logingScreen.LogingScreenEnabe(logingScreen);
        logingScreen.clearScreen();
        MenuScreen menuScreen=new MenuScreen(logingScreen.getUserName(),users,files);
        menuScreen.MenuScreenEnable(menuScreen);


    }
}
