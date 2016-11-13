package com.uan.comercio_jee.dao;

import java.sql.SQLException;
import java.util.List;

import com.uan.comercio_jee.dto.OrdenCompraEnc;


public interface OrdenCompraEncDao {

	/**
     * Crea nuevo Encabezado Orden de Compra. 
     * @param ordencompraenc
     * @return 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
     */
    OrdenCompraEnc create(OrdenCompraEnc ordencompraenc) throws ClassNotFoundException, SQLException;

    /**
     * Actualiza un Encabezado Orden de Compra existente. La llave del Encabezado Orden de Compra no puede ser modificada.
     * @param ordencompraenc
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    OrdenCompraEnc update(OrdenCompraEnc ordencompraenc) throws ClassNotFoundException, SQLException;

    /**
     * Borra un Encabezado Orden de Compra existente
     * @param ordencompraenc 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    void delete(OrdenCompraEnc ordencompraenc) throws ClassNotFoundException, SQLException;

    /**
     * Busca un Encabezado Orden de Compra por la llave
     * @param eocllave
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    OrdenCompraEnc findById(String eocllave) throws ClassNotFoundException, SQLException;

    /**
     * Devuelve todas las OrdenCompraEnc de la base de datos
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    List<OrdenCompraEnc> findAll() throws ClassNotFoundException, SQLException;
    
}
