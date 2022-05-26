package com.example.Repositiories;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CRUDInterface <T> {
    //create
    public boolean create (T entity) throws SQLException;

    //Read
    public T getSingleEntityById(int id);
    public ArrayList<T> getAllEntities();

    //Update
    public boolean update(T enitity);

    //Delete
    public boolean deleteById(int id);

}
