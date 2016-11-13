package com.uan.comercio_jee.dao;

import java.sql.SQLException;
import java.util.List;

import com.uan.comercio_jee.dto.OrdenCompraDet;


public interface OrdenCompraDetDao {

    /**
     * Crea nuevo Detalle Orden de Compra. 
     * @param ordencompradet
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    OrdenCompraDet create(OrdenCompraDet ordencompradet) throws ClassNotFoundException, SQLException;

    /**
     * Actualiza un Detalle Orden de Compra existente. La llave del Detalle Orden de Compra no puede ser modificada.
     * @param ordencompradet
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    OrdenCompraDet update(OrdenCompraDet ordencompradet) throws ClassNotFoundException, SQLException;

    /**
     * Borra un Detalle Orden de Compra existente
     * @param ordencompradet 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    void delete(OrdenCompraDet ordencompradet) throws ClassNotFoundException, SQLException;

    /**
     * Busca un Detalle Orden de Compra por la llave
     * @param docllave
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    OrdenCompraDet findById(String docllave) throws ClassNotFoundException, SQLException;

    /**
     * Devuelve todas los Detalles Orden Compra de la base de datos
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    List<OrdenCompraDet> findAll() throws ClassNotFoundException, SQLException;
    
}
