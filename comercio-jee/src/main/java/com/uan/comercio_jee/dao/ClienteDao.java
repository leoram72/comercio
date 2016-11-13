package com.uan.comercio_jee.dao;

import java.sql.SQLException;
import java.util.List;

import com.uan.comercio_jee.dto.Clientes;


public interface ClienteDao {

    /**
     * Crea nuevo cliente. 
     * @param cliente
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    Clientes create(Clientes cliente) throws ClassNotFoundException, SQLException;

    /**
     * Actualiza un cliente existente. La llave del cliente no puede ser modificada.
     * @param cliente
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    Clientes update(Clientes cliente) throws ClassNotFoundException, SQLException;

    /**
     * Borra un cliente existente
     * @param cliente 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    void delete(Clientes cliente) throws ClassNotFoundException, SQLException;

    /**
     * Busca un cliente por la llave
     * @param clllave
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    Clientes findById(String clllave) throws ClassNotFoundException, SQLException;

    /**
     * Devuelve todos los clientes de la base de datos
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    List<Clientes> findAll() throws ClassNotFoundException, SQLException;
   
}
