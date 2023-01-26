package com.inikoLocal.Utils;

import com.inikoLocal.DBstorage.FilesDB;
import com.inikoLocal.DBstorage.Users.User;
import com.inikoLocal.DBstorage.UsersDB;

import java.util.Random;

public class Initaliser {

    private FilesDB files;
    private UsersDB users;

    public Initaliser()
    {
        files=new FilesDB(10000);
        users=new UsersDB(10);
        sampleUsersAdd();
    }

    private void sampleUsersAdd()
    {
        users.insert(new User(1,"admin","papaki"));
        for (int i = 0; i < 9; i++) {
            users.insert(new User(i,GenRandomString(),GenRandomString()));
        }
    }

    public FilesDB getFiles() {
        return files;
    }

    public void setFiles(FilesDB files) {
        this.files = files;
    }

    public UsersDB getUsers() {
        return users;
    }

    public void setUsers(UsersDB users) {
        this.users = users;
    }

    private String GenRandomString()
    {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        return (random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString());
    }
}
