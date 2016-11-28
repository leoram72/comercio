package com.uan.comercio_jee.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;
import com.uan.comercio_jee.dao.FamiliaDao;
import com.uan.comercio_jee.dto.Familias;

public class FamiliaDaoImpl extends EjecutaDaoJdbc<Familias> implements FamiliaDao{

	public FamiliaDaoImpl() {
        super(Familias.class);
    }
	
	public Familias create(Familias familia) throws ClassNotFoundException, SQLException {
        String query;
        String[][] parametros={{"FmCodigo","fmCodigo"},{"FmDesc","fmDesc"}};
		               
        query = "INSERT INTO familias VALUES(uuid_generate_v4(),?,?)";
        familia = EjecutaQuery(familia,query,parametros);

        return familia;
    }
    
    public Familias update(Familias familia) throws ClassNotFoundException, SQLException {
        String query;
        String[][] parametros={{"FmCodigo","fmCodigo"},{"FmDesc","fmDesc"},{"FmLlave","fmLlave"}};
		               
        query = "UPDATE familias SET fm_codigo = ?, fm_desc = ? WHERE fm_llave = ? ";
        familia = EjecutaQuery(familia,query,parametros);

        return familia;
    }
    
    public void delete(Familias familia) throws ClassNotFoundException, SQLException {
        String query;
        String[][] parametros={{"FmLlave","fmLlave"}};
		               
        query = "DELETE FROM familias WHERE fm_llave = ? ";
        EjecutaQuery(familia,query,parametros);

    }
    
    public List<Familias> findAll() throws ClassNotFoundException, SQLException {
    	String query;
    	String[] parametros={};
    	CachedRowSet crs = new CachedRowSetImpl();
        List<Familias> listfamilia = new ArrayList<Familias>(); 
        Familias familia = new Familias();
		               
        query = "SELECT * FROM familias ";
        crs=EjecutaRS(query,parametros);
        
        while(crs.next()){
        	familia.setFmLlave(crs.getString("fm_llave"));
        	familia.setFmCodigo(crs.getString("fm_codigo"));
        	familia.setFmDesc(crs.getString("fm_desc"));
        	listfamilia.add(familia);
        }

        return listfamilia;
    }

	public Familias findById(String fmllave) throws ClassNotFoundException, SQLException {
		String query;
		String[] parametros={fmllave};
        Familias familia = new Familias(); 
        CachedRowSet crs = new CachedRowSetImpl();
		               
        query = "SELECT * FROM familias WHERE fm_llave = ? ";
        crs=EjecutaRS(query,parametros);
        crs.next();
        familia.setFmLlave(crs.getString("fm_llave"));
        familia.setFmCodigo(crs.getString("fm_codigo"));
        familia.setFmDesc(crs.getString("fm_desc"));

        return familia;
	}

}
