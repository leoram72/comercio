package com.uan.comercio_jee.dao;

import java.sql.SQLException;
import java.util.List;

import com.uan.comercio_jee.dto.Categorias;


public interface CategoriaDao {
    /**
     * Crea nuevo categoria. 
     * @param categoria
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    Categorias create(Categorias categoria) throws ClassNotFoundException, SQLException;

    /**
     * Actualiza un categoria existente. La llave del categoria no puede ser modificada.
     * @param categoria
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    Categorias update(Categorias categoria) throws ClassNotFoundException, SQLException;

    /**
     * Borra un categoria existente
     * @param product 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    void delete(Categorias categoria) throws ClassNotFoundException, SQLException;

    /**
     * Busca un categoria por la llave
     * @param ctllave
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    Categorias findById(String ctllave) throws ClassNotFoundException, SQLException;

    /**
     * Devuelve todas las Categorias de la base de datos
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    List<Categorias> findAll() throws ClassNotFoundException, SQLException;
    
}
