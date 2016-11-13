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
		               
        query = "INSERT INTO familias VALUES(uuid_generate_v4(),'" + familia.getFmCodigo() + "','" + familia.getFmDesc() + "')";
        familia = EjecutaQuery(familia,query);

        return familia;
    }
    
    public Familias update(Familias familia) throws ClassNotFoundException, SQLException {
        String query;
		               
        query = "UPDATE familias SET fm_codigo = '" + familia.getFmCodigo() + "', fm_desc = '" + familia.getFmDesc() + "' WHERE fm_llave = '"+familia.getFmLlave()+"' ";
        familia = EjecutaQuery(familia,query);

        return familia;
    }
    
    public void delete(Familias familia) throws ClassNotFoundException, SQLException {
        String query;
		               
        query = "DELETE FROM familias WHERE fm_llave = '" + familia.getFmLlave() + "' ";
        EjecutaQuery(familia,query);

    }
    
    public List<Familias> findAll() throws ClassNotFoundException, SQLException {
    	String query;
    	CachedRowSet crs = new CachedRowSetImpl();
        List<Familias> listfamilia = new ArrayList<Familias>(); 
        Familias familia = new Familias();
		               
        query = "SELECT * FROM familias ";
        crs=EjecutaRS(query);
        
        while(crs.next()){
        	familia.setFmLlave(crs.getString("fm_llave"));
        	familia.setFmCodigo(crs.getString("fm_codigo"));
        	familia.setFmDesc(crs.getString("fm_desc"));
        	listfamilia.add(familia);
        }

        return listfamilia;
    }

	public Familias findById(String arllave) throws ClassNotFoundException, SQLException {
		String query;
        Familias familia = new Familias(); 
        CachedRowSet crs = new CachedRowSetImpl();
		               
        query = "SELECT * FROM familias WHERE fm_llave = '" + arllave + "' ";
        crs=EjecutaRS(query);
        crs.next();
        familia.setFmLlave(crs.getString("fm_llave"));
        familia.setFmCodigo(crs.getString("fm_codigo"));
        familia.setFmDesc(crs.getString("fm_desc"));

        return familia;
	}

}
