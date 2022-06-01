package com.example.Repositiories;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/*Camella*/

public interface CRUDInterface <T> {
    //create
    public boolean create (T entity) throws SQLException;

    //Read
    public T getSingleEntityById(int id) throws SQLException;
    public ArrayList<T> getAllEntities() throws SQLException;

    //Update
    public boolean update(T entity);

    //Delete
    public boolean deleteById(int id) throws SQLException;

}
