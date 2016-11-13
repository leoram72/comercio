package com.uan.comercio_jee.dao;

import java.sql.SQLException;
import java.util.List;

import com.uan.comercio_jee.dto.TiposDocumento;


public interface TipoDocumentoDao {

    /**
     * Crea nuevo tipo de documento. 
     * @param tipodocumento
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    TiposDocumento create(TiposDocumento tipodocumento) throws ClassNotFoundException, SQLException;

    /**
     * Actualiza un tipo de documento existente. La llave del tipo de documento no puede ser modificada.
     * @param tipodocumento
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    TiposDocumento update(TiposDocumento tipodocumento) throws ClassNotFoundException, SQLException;

    /**
     * Borra un tipo de documento existente
     * @param tipodocumento 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    void delete(TiposDocumento tipodocumento) throws ClassNotFoundException, SQLException;

    /**
     * Busca un tipo de documento por la llave
     * @param tdllave
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    TiposDocumento findById(String tdllave) throws ClassNotFoundException, SQLException;

    /**
     * Devuelve todas las tipo de documentos de la base de datos
     * @return 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    List<TiposDocumento> findAll() throws ClassNotFoundException, SQLException;
   
}
