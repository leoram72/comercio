package com.uan.comercio_jee.dao;

import java.sql.SQLException;
import java.util.List;

import com.uan.comercio_jee.dto.Familias;


public interface FamiliaDao {

    /**
     * Crea nueva familia. 
     * @param familia
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    Familias create(Familias familia) throws ClassNotFoundException, SQLException;

    /**
     * Actualiza una familia existente. La llave de la familia no puede ser modificada.
     * @param familia
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    Familias update(Familias familia) throws ClassNotFoundException, SQLException;

    /**
     * Borra una familia existente
     * @param familia 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    void delete(Familias familia) throws ClassNotFoundException, SQLException;

    /**
     * Busca una familia por la llave
     * @param fmllave
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    Familias findById(String fmllave) throws ClassNotFoundException, SQLException;

    /**
     * Devuelve todas las familias de la base de datos
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    List<Familias> findAll() throws ClassNotFoundException, SQLException;
   
}
