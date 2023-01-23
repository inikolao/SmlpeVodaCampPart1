package com.inikoLocal.DBstorage;

import com.inikoLocal.DBstorage.Users.User;

import java.util.Arrays;

public class UsersDB implements DBService{

    private User users[];
    int count =0;

    public UsersDB(int noofproducts)
    {
        users=new User [noofproducts];
    }

    @Override
    public boolean insert(Object obj) {
        return false;
    }

    @Override
    public boolean update(Object obj) {
        return false;
    }

    @Override
    public Object[] delete(int id) {
        return new Object[0];
    }

    @Override
    public Object getAll() {
        return null;
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
                "users=" + Arrays.toString(users) +
                ", count=" + count +
                '}';
    }
}
