package com.inikoLocal.DBstorage;

import java.util.ArrayList;

public interface DBService {

    boolean insert(Object obj);

    boolean update(Object obj);

    void delete(int id);

    ArrayList<?> getAll();

    Object getById(int id);

    Object getShorted();

}
