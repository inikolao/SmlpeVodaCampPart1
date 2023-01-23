package com.inikoLocal.DBstorage;

import com.inikoLocal.DBstorage.Files.File;

public class FilesDB implements DBService{

    private File files[];
    int count =0;

    public FilesDB(int noofFiles)
    {
        files=new File [noofFiles];
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

}
