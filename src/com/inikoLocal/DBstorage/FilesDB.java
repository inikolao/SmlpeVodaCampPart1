package com.inikoLocal.DBstorage;

import com.inikoLocal.DBstorage.Files.File;

import java.util.ArrayList;

public class FilesDB implements DBService{

    private ArrayList<File> files;
    int count =0;

    public FilesDB(int noofFiles)
    {
        files=new ArrayList<> (noofFiles);
    }

    @Override
    public boolean insert(Object obj) {

        files.add((File) obj);
        return false;
    }

    @Override
    public boolean update(Object obj) {
        return false;
    }

    @Override
    public void delete(int id) {
        //
    }

    @Override
    public ArrayList<File> getAll() {
        return files;
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
        return "FilesDB{" +
                "files=" + files +
                ", count=" + count +
                '}';
    }
}
