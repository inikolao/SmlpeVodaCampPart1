package com.inikoLocal.DBstorage;

public interface DBService {

    boolean insert(Object obj);

    boolean update(Object obj);

    Object[] delete(int id);

    Object getAll();

    Object getById(int id);

    Object getShorted();
}
