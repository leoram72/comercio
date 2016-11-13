package com.uan.comercio_jee.dao;

import java.sql.SQLException;
import java.util.List;

import com.uan.comercio_jee.dto.UnidadesMedida;


public interface UnidadMedidaDao {

    /**
     * Crea nueva unidad de medida. 
     * @param unidadmedida
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    UnidadesMedida create(UnidadesMedida unidadmedida) throws ClassNotFoundException, SQLException;

    /**
     * Actualiza una unidad de medida existente. La llave de la unidad de medida no puede ser modificada.
     * @param unidadmedida
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    UnidadesMedida update(UnidadesMedida unidadmedida) throws ClassNotFoundException, SQLException;

    /**
     * Borra una unidad de medida existente
     * @param unidadmedida 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    void delete(UnidadesMedida unidadmedida) throws ClassNotFoundException, SQLException;

    /**
     * Busca una unidad de medida por la llave
     * @param emllave
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    UnidadesMedida findById(String emllave) throws ClassNotFoundException, SQLException;

    /**
     * Devuelve todas las unidades de medida de la base de datos
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    List<UnidadesMedida> findAll() throws ClassNotFoundException, SQLException;
   
}
