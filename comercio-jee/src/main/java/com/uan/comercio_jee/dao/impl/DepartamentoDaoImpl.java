package com.uan.comercio_jee.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;
import com.uan.comercio_jee.dao.DepartamentoDao;
import com.uan.comercio_jee.dto.Departamentos;

public class DepartamentoDaoImpl extends EjecutaDaoJdbc<Departamentos> implements DepartamentoDao{

	public DepartamentoDaoImpl() {
        super(Departamentos.class);
    }
	
	public Departamentos create(Departamentos departamento) throws ClassNotFoundException, SQLException {
        String query;
		               
        query = "INSERT INTO departamentos VALUES(uuid_generate_v4(),'" + departamento.getDpCodigo() + "','" + departamento.getDpDesc() + "')";
        departamento = EjecutaQuery(departamento,query);

        return departamento;
    }
    
    public Departamentos update(Departamentos departamento) throws ClassNotFoundException, SQLException {
        String query;
		               
        query = "UPDATE departamentos SET dp_codigo = '" + departamento.getDpCodigo() + "', dp_desc = '" + departamento.getDpDesc() + "' WHERE dp_llave = '"+departamento.getDpLlave()+"' ";
        departamento = EjecutaQuery(departamento,query);

        return departamento;
    }
    
    public void delete(Departamentos departamento) throws ClassNotFoundException, SQLException {
        String query;
		               
        query = "DELETE FROM departamentos WHERE dp_llave = '" + departamento.getDpLlave() + "' ";
        EjecutaQuery(departamento,query);

    }
    
    public List<Departamentos> findAll() throws ClassNotFoundException, SQLException {
    	String query;
    	CachedRowSet crs = new CachedRowSetImpl();
        List<Departamentos> listdepartamento = new ArrayList<Departamentos>(); 
        Departamentos departamento = new Departamentos();
		               
        query = "SELECT * FROM departamentos ";
        crs=EjecutaRS(query);
        
        while(crs.next()){
        	departamento.setDpLlave(crs.getString("dp_llave"));
        	departamento.setDpCodigo(crs.getString("dp_codigo"));
        	departamento.setDpDesc(crs.getString("dp_desc"));
        	listdepartamento.add(departamento);
        }

        return listdepartamento;
    }

	public Departamentos findById(String arllave) throws ClassNotFoundException, SQLException {
		String query;
        Departamentos departamento = new Departamentos(); 
        CachedRowSet crs = new CachedRowSetImpl();
		               
        query = "SELECT * FROM departamentos WHERE ar_llave = '" + arllave + "' ";
        crs=EjecutaRS(query);
        crs.next();
        departamento.setDpLlave(crs.getString("dp_llave"));
        departamento.setDpCodigo(crs.getString("dp_codigo"));
        departamento.setDpDesc(crs.getString("dp_desc"));

        return departamento;
	}
	
}
