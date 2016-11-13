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
		               
        query = "INSERT INTO tipos_documentos VALUES(uuid_generate_v4(),'" + tipodocumento.getTdCodigo() + "','" + tipodocumento.getTdDesc() + "')";
        tipodocumento = EjecutaQuery(tipodocumento,query);

        return tipodocumento;
    }
    
    public TiposDocumento update(TiposDocumento tipodocumento) throws ClassNotFoundException, SQLException {
        String query;
		               
        query = "UPDATE tipos_documentos SET td_codigo = '" + tipodocumento.getTdCodigo() + "', td_desc = '" + tipodocumento.getTdDesc() + "' WHERE td_llave = '"+tipodocumento.getTdLlave()+"' ";
        tipodocumento = EjecutaQuery(tipodocumento,query);

        return tipodocumento;
    }
    
    public void delete(TiposDocumento tipodocumento) throws ClassNotFoundException, SQLException {
        String query;
		               
        query = "DELETE FROM tipos_documentos WHERE td_llave = '" + tipodocumento.getTdLlave() + "' ";
        EjecutaQuery(tipodocumento,query);

    }
    
    public List<TiposDocumento> findAll() throws ClassNotFoundException, SQLException {
    	String query;
    	CachedRowSet crs = new CachedRowSetImpl();
        List<TiposDocumento> listtipodocumento = new ArrayList<TiposDocumento>(); 
        TiposDocumento tipodocumento = new TiposDocumento();
		               
        query = "SELECT * FROM tipos_documentos ";
        crs=EjecutaRS(query);
        
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
        TiposDocumento tipodocumento = new TiposDocumento(); 
        CachedRowSet crs = new CachedRowSetImpl();
		               
        query = "SELECT * FROM tipos_documentos WHERE td_llave = '" + tdllave + "' ";
        crs=EjecutaRS(query);
        crs.next();
        tipodocumento.setTdLlave(crs.getString("td_llave"));
        tipodocumento.setTdCodigo(crs.getString("td_codigo"));
        tipodocumento.setTdDesc(crs.getString("td_desc"));

        return tipodocumento;
	}

}
