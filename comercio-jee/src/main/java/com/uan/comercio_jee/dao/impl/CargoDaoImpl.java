package com.uan.comercio_jee.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;
import com.uan.comercio_jee.dao.CargoDao;
import com.uan.comercio_jee.dto.Cargos;
import com.uan.comercio_jee.dto.Cargos;

public class CargoDaoImpl extends EjecutaDaoJdbc<Cargos> implements CargoDao {
	public CargoDaoImpl() {
        super(Cargos.class);
    }
	
	public Cargos create(Cargos cargo) throws ClassNotFoundException, SQLException {
        String query;
		               
        query = "INSERT INTO cargos VALUES(uuid_generate_v4(),'" + cargo.getCgCodigo() + "','" + cargo.getCgDesc() + "')";
        cargo = EjecutaQuery(cargo,query);

        return cargo;
    }
    
    public Cargos update(Cargos cargo) throws ClassNotFoundException, SQLException {
        String query;
		               
        query = "UPDATE cargos SET cg_codigo = '" + cargo.getCgCodigo() + "', cg_desc = '" + cargo.getCgDesc() + "' WHERE cg_llave = '"+cargo.getCgLlave()+"' ";
        cargo = EjecutaQuery(cargo,query);

        return cargo;
    }
    
    public void delete(Cargos cargo) throws ClassNotFoundException, SQLException {
        String query;
		               
        query = "DELETE FROM cargos WHERE cg_llave = '" + cargo.getCgLlave() + "' ";
        EjecutaQuery(cargo,query);

    }
    
    public List<Cargos> findAll() throws ClassNotFoundException, SQLException {
    	String query;
    	CachedRowSet crs = new CachedRowSetImpl();
        List<Cargos> listcargo = new ArrayList<Cargos>(); 
        Cargos cargo = new Cargos();
		               
        query = "SELECT * FROM cargos ";
        crs=EjecutaRS(query);
        
        while(crs.next()){
        	cargo.setCgLlave(crs.getString("cg_llave"));
        	cargo.setCgCodigo(crs.getString("cg_codigo"));
        	cargo.setCgDesc(crs.getString("cg_desc"));
        	listcargo.add(cargo);
        }

        return listcargo;
    }

	public Cargos findById(String arllave) throws ClassNotFoundException, SQLException {
		String query;
        Cargos cargo = new Cargos(); 
        CachedRowSet crs = new CachedRowSetImpl();
		               
        query = "SELECT * FROM cargos WHERE cg_llave = '" + arllave + "' ";
        crs=EjecutaRS(query);
        crs.next();
        cargo.setCgLlave(crs.getString("cg_llave"));
        cargo.setCgCodigo(crs.getString("cg_codigo"));
        cargo.setCgDesc(crs.getString("cg_desc"));

        return cargo;
	}

}
