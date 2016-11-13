package com.uan.comercio_jee.dao;

import java.sql.SQLException;
import java.util.List;

import com.uan.comercio_jee.dto.Items;


public interface ItemDao {
    /**
     * Crea nuevo item. 
     * @param item
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    Items create(Items item) throws ClassNotFoundException, SQLException;

    /**
     * Actualiza un item existente. La llave del item no puede ser modificada.
     * @param item
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    Items update(Items item) throws ClassNotFoundException, SQLException;

    /**
     * Borra un item existente
     * @param product 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    void delete(Items item) throws ClassNotFoundException, SQLException;

    /**
     * Busca un item por la llave
     * @param itllave
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    Items findById(String itllave) throws ClassNotFoundException, SQLException;

    /**
     * Devuelve todas las Items de la base de datos
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    List<Items> findAll() throws ClassNotFoundException, SQLException;
    
}
