package com.uan.comercio_jee.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;
import com.uan.comercio_jee.dao.CategoriaDao;
import com.uan.comercio_jee.dto.Categorias;

public class CategoriaDaoImpl extends EjecutaDaoJdbc<Categorias> implements CategoriaDao{

	public CategoriaDaoImpl() {
        super(Categorias.class);
    }
	
	public Categorias create(Categorias categoria) throws ClassNotFoundException, SQLException {
        String query;
        String[][] parametros={{"CtCodigo","ctCodigo"},{"CtDesc","ctDesc"}};
		               
        query = "INSERT INTO categorias VALUES(uuid_generate_v4(?,?)";
        categoria = EjecutaQuery(categoria,query,parametros);

        return categoria;
    }
    
    public Categorias update(Categorias categoria) throws ClassNotFoundException, SQLException {
        String query;
        String[][] parametros={{"CtCodigo","ctCodigo"},{"CtDesc","ctDesc"},{"CtLlave"},{"ctLlave"}};
		               
        query = "UPDATE categorias SET ct_codigo = ?, ct_desc = ? WHERE ct_llave = ? ";
        categoria = EjecutaQuery(categoria,query,parametros);

        return categoria;
    }
    
    public void delete(Categorias categoria) throws ClassNotFoundException, SQLException {
        String query;
        String[][] parametros={{"CtLlave"},{"ctLlave"}};
		               
        query = "DELETE FROM categorias WHERE ct_llave = ? ";
        EjecutaQuery(categoria,query,parametros);

    }
    
    public List<Categorias> findAll() throws ClassNotFoundException, SQLException {
    	String query;
    	String[] parametros={};
    	CachedRowSet crs = new CachedRowSetImpl();
        List<Categorias> listcategoria = new ArrayList<Categorias>(); 
        Categorias categoria = new Categorias();
		               
        query = "SELECT * FROM categorias ";
        crs=EjecutaRS(query,parametros);
        
        while(crs.next()){
        	categoria.setCtLlave(crs.getString("ct_llave"));
        	categoria.setCtCodigo(crs.getString("ct_codigo"));
        	categoria.setCtDesc(crs.getString("ct_desc"));
        	listcategoria.add(categoria);
        }

        return listcategoria;
    }

	public Categorias findById(String ctllave) throws ClassNotFoundException, SQLException {
		String query;
		String[] parametros={ctllave};
        Categorias categoria = new Categorias(); 
        CachedRowSet crs = new CachedRowSetImpl();
		               
        query = "SELECT * FROM categorias WHERE ct_llave = '" + ctllave + "' ";
        crs=EjecutaRS(query,parametros);
        crs.next();
        categoria.setCtLlave(crs.getString("ct_llave"));
        categoria.setCtCodigo(crs.getString("ct_codigo"));
        categoria.setCtDesc(crs.getString("ct_desc"));

        return categoria;
	}

}
