package com.uan.comercio_jee.dao;

import java.sql.SQLException;
import java.util.List;

import com.uan.comercio_jee.dto.Departamentos;


public interface DepartamentoDao {

    /**
     * Crea nuevo departamento. 
     * @param departamento
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    Departamentos create(Departamentos departamento) throws ClassNotFoundException, SQLException;

    /**
     * Actualiza un departamento existente. La llave del departamento no puede ser modificada.
     * @param departamento
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    Departamentos update(Departamentos departamento) throws ClassNotFoundException, SQLException;

    /**
     * Borra un departamento existente
     * @param departamento 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    void delete(Departamentos departamento) throws ClassNotFoundException, SQLException;

    /**
     * Busca un departamento por la llave
     * @param dpllave
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    Departamentos findById(String dpllave) throws ClassNotFoundException, SQLException;

    /**
     * Devuelve todas las departamentos de la base de datos
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    List<Departamentos> findAll() throws ClassNotFoundException, SQLException;
   
}
