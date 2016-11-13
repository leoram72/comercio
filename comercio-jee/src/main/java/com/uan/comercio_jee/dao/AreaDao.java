package com.uan.comercio_jee.dao;

import java.sql.SQLException;
import java.util.List;

import com.uan.comercio_jee.dto.Areas;


public interface AreaDao {

    /**
     * Crea nuevas areas. 
     * @param area
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    Areas create(Areas area) throws ClassNotFoundException, SQLException;

    /**
     * Actualiza un área existente. La llave del area no puede ser modificada.
     * @param area
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    Areas update(Areas area) throws ClassNotFoundException, SQLException;

    /**
     * Borra un area existente
     * @param product 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    void delete(Areas area) throws ClassNotFoundException, SQLException;

    /**
     * Busca un area por la llave
     * @param arllave
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    Areas findById(String arllave) throws ClassNotFoundException, SQLException;

    /**
     * Devuelve todas las areas de la base de datos
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    List<Areas> findAll() throws ClassNotFoundException, SQLException;
    
}
