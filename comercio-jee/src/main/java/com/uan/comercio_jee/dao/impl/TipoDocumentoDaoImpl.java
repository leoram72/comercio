package com.uan.comercio_jee.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;
import com.uan.comercio_jee.dao.TipoDocumentoDao;
import com.uan.comercio_jee.dto.TiposDocumento;

public class TipoDocumentoDaoImpl extends EjecutaDaoJdbc<TiposDocumento> implements TipoDocumentoDao{

	public TipoDocumentoDaoImpl() {
        super(TiposDocumento.class);
    }
	
	public TiposDocumento create(TiposDocumento tipodocumento) throws ClassNotFoundException, SQLException {
        String query;
        String[][] parametros={{"TdCodigo","tdCodigo"},{"TdDesc","tdDesc"}};
		               
        query = "INSERT INTO tipos_documentos VALUES(uuid_generate_v4(),?,?)";
        tipodocumento = EjecutaQuery(tipodocumento,query,parametros);

        return tipodocumento;
    }
    
    public TiposDocumento update(TiposDocumento tipodocumento) throws ClassNotFoundException, SQLException {
        String query;
        String[][] parametros={{"TdCodigo","tdCodigo"},{"TdDesc","tdDesc"},{"TdLlave","tdLlave"}};
		               
        query = "UPDATE tipos_documentos SET td_codigo = ?, td_desc = ? WHERE td_llave = ? ";
        tipodocumento = EjecutaQuery(tipodocumento,query,parametros);

        return tipodocumento;
    }
    
    public void delete(TiposDocumento tipodocumento) throws ClassNotFoundException, SQLException {
        String query;
        String[][] parametros={{"TdLlave","tdLlave"}};
		               
        query = "DELETE FROM tipos_documentos WHERE td_llave = ? ";
        EjecutaQuery(tipodocumento,query,parametros);

    }
    
    public List<TiposDocumento> findAll() throws ClassNotFoundException, SQLException {
    	String query;
    	String[] parametros={};
    	CachedRowSet crs = new CachedRowSetImpl();
        List<TiposDocumento> listtipodocumento = new ArrayList<TiposDocumento>(); 
        TiposDocumento tipodocumento = new TiposDocumento();
		               
        query = "SELECT * FROM tipos_documentos ";
        crs=EjecutaRS(query,parametros);
        
        while(crs.next()){
        	tipodocumento.setTdLlave(crs.getString("td_llave"));
        	tipodocumento.setTdCodigo(crs.getString("td_codigo"));
        	tipodocumento.setTdDesc(crs.getString("td_desc"));
        	listtipodocumento.add(tipodocumento);
        }

        return listtipodocumento;
    }

	public TiposDocumento findById(String tdllave) throws ClassNotFoundException, SQLException {
		String query;
		String[] parametros={tdllave};
        TiposDocumento tipodocumento = new TiposDocumento(); 
        CachedRowSet crs = new CachedRowSetImpl();
		               
        query = "SELECT * FROM tipos_documentos WHERE td_llave = ? ";
        crs=EjecutaRS(query,parametros);
        crs.next();
        tipodocumento.setTdLlave(crs.getString("td_llave"));
        tipodocumento.setTdCodigo(crs.getString("td_codigo"));
        tipodocumento.setTdDesc(crs.getString("td_desc"));

        return tipodocumento;
	}

}
