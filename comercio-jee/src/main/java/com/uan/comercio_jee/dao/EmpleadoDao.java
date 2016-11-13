package com.uan.comercio_jee.dao;

import java.sql.SQLException;
import java.util.List;

import com.uan.comercio_jee.dto.Empleados;


public interface EmpleadoDao {

    /**
     * Crea nuevo empleado. 
     * @param empleado
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    Empleados create(Empleados empleado) throws ClassNotFoundException, SQLException;

    /**
     * Actualiza un empleado existente. La llave del empleado no puede ser modificada.
     * @param empleado
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    Empleados update(Empleados empleado) throws ClassNotFoundException, SQLException;

    /**
     * Borra un empleado existente
     * @param empleado 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    void delete(Empleados empleado) throws ClassNotFoundException, SQLException;

    /**
     * Busca un empleado por la llave
     * @param emllave
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    Empleados findById(String emllave) throws ClassNotFoundException, SQLException;

    /**
     * Devuelve todas las empleados de la base de datos
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    List<Empleados> findAll() throws ClassNotFoundException, SQLException;
   
}
