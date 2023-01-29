package com.inikoLocal.DBstorage;

import com.inikoLocal.DBstorage.Users.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        //User usere=users.stream().filter(user -> user.equals(user.getId())).findFirst().get();
        List<User> searchResult =users
                .stream()
                .filter(p-> p.getId()==id)
                .collect(Collectors.toList());
        //System.out.println(searchResult.get(0).getUsername());
        users.remove(searchResult.get(0));
    }

    @Override
    public ArrayList<User> getAll() {
       return users;
    }

    @Override
    public Object getById(int id) {
        List<User> searchResult =users
                .stream()
                .filter(p-> p.getId()==id)
                .collect(Collectors.toList());
        return searchResult.get(0);
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
