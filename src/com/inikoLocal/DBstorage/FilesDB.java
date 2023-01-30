package com.inikoLocal.DBstorage;

import com.inikoLocal.DBstorage.Files.File;
import com.inikoLocal.DBstorage.Users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        files= (ArrayList<File>) obj;
        return true;
    }

    @Override
    public void delete(int id) {
        List<File> searchResult =files
                .stream()
                .filter(p-> p.getId()==id)
                .collect(Collectors.toList());
        //System.out.println(searchResult.get(0).getUsername());
        files.remove(searchResult.get(0));
    }

    @Override
    public ArrayList<File> getAll() {
        return files;
    }

    @Override
    public Object getById(int id) {
        List<File> searchResult =files
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
        return "FilesDB{" +
                "files=" + files +
                ", count=" + count +
                '}';
    }
}
