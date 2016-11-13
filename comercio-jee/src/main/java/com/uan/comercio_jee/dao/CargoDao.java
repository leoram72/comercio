package com.uan.comercio_jee.dao;

import java.sql.SQLException;
import java.util.List;

import com.uan.comercio_jee.dto.Cargos;


public interface CargoDao {

    /**
     * Crea nuevo Cargo. 
     * @param cargo
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    Cargos create(Cargos cargo) throws ClassNotFoundException, SQLException;

    /**
     * Actualiza un cargo existente. La llave del cargo no puede ser modificada.
     * @param cargo
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    Cargos update(Cargos cargo) throws ClassNotFoundException, SQLException;

    /**
     * Borra un cargo existente
     * @param cargo 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    void delete(Cargos cargo) throws ClassNotFoundException, SQLException;

    /**
     * Busca un cargo por la llave
     * @param cgllave
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    Cargos findById(String cgllave) throws ClassNotFoundException, SQLException;

    /**
     * Devuelve todas las cargos de la base de datos
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    List<Cargos> findAll() throws ClassNotFoundException, SQLException;
    
}
