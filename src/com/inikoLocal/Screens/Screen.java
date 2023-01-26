package com.inikoLocal.Screens;

import sun.misc.Signal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Screen {

    private ArrayList<String> menuStrings=new ArrayList<>();
    private Scanner SuserInput;
    private String UserInput;
    private String Continue="Press any Key to Continue....";

    public Screen(){
        SuserInput=new Scanner(System.in);
        UserInput=new String();
    }

    public void clearScreen()
    {
        try {


            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c",
                        "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}


    }
    ///
    public void getContinueP()
    {
        System.out.println(Continue);

    }
    ///

    public Scanner getSuserInput() {
        return SuserInput;
    }

    public void setSuserInput(Scanner suserInput) {
        SuserInput = suserInput;
    }

    public String getUserInput() {
        return UserInput;
    }

    public void setUserInput(String userInput) {
        UserInput = userInput;
    }

    public String getContinue() {
        return Continue;
    }

    public void setContinue(String continiue) {
        Continue = continiue;
    }

    public ArrayList<String> getMenuStrings() {
        return menuStrings;
    }

    public void setMenuStrings(ArrayList<String> menuStrings) {
        this.menuStrings = menuStrings;
    }

    public void GetMenu(int menuInt)
    {
        System.out.println(menuStrings.get(menuInt));
    }
    public void DrawScreen()
    {
        for (int i = 0; i <menuStrings.size() ; i++) {

            System.out.println(menuStrings.get(i));
        }
    }
    public void DrawScreen(ArrayList<?> listMenu)
    {
        for (int i = 0; i <listMenu.size() ; i++) {

            System.out.println(listMenu.get(i));
        }
    }
}
