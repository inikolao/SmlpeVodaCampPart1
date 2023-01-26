package com.inikoLocal.DBstorage;

import com.inikoLocal.DBstorage.Users.User;

import java.util.ArrayList;
import java.util.Arrays;

public class UsersDB implements DBService{

    private ArrayList<User> users;
    int count =0;

    public UsersDB(int noofproducts)
    {
        users=new ArrayList<>(noofproducts);
    }

    @Override
    public boolean insert(Object obj) {
        users.add((User) obj);
        return false;
    }

    @Override
    public boolean update(Object obj) {
        return false;
    }

    @Override
    public void delete(int id) {
        //users.stream().filter(user -> user.equals(user.getId())).findFirst().get();
        users.remove(id);
    }

    @Override
    public ArrayList<User> getAll() {
       return users;
    }

    @Override
    public Object getById(int id) {
        return null;
    }

    @Override
    public Object getShorted() {
        return null;
    }

    @Override
    public String toString() {
        return "UsersDB{" +
                "users=" + users +
                ", count=" + count +
                '}';
    }
}
