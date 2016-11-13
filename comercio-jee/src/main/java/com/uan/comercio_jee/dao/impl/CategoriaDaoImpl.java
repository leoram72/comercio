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
		               
        query = "INSERT INTO categorias VALUES(uuid_generate_v4(),'" + categoria.getCtCodigo() + "','" + categoria.getCtDesc() + "')";
        categoria = EjecutaQuery(categoria,query);

        return categoria;
    }
    
    public Categorias update(Categorias categoria) throws ClassNotFoundException, SQLException {
        String query;
		               
        query = "UPDATE categorias SET ct_codigo = '" + categoria.getCtCodigo() + "', ct_desc = '" + categoria.getCtDesc() + "' WHERE ct_llave = '"+categoria.getCtLlave()+"' ";
        categoria = EjecutaQuery(categoria,query);

        return categoria;
    }
    
    public void delete(Categorias categoria) throws ClassNotFoundException, SQLException {
        String query;
		               
        query = "DELETE FROM categorias WHERE ct_llave = '" + categoria.getCtLlave() + "' ";
        EjecutaQuery(categoria,query);

    }
    
    public List<Categorias> findAll() throws ClassNotFoundException, SQLException {
    	String query;
    	CachedRowSet crs = new CachedRowSetImpl();
        List<Categorias> listcategoria = new ArrayList<Categorias>(); 
        Categorias categoria = new Categorias();
		               
        query = "SELECT * FROM categorias ";
        crs=EjecutaRS(query);
        
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
        Categorias categoria = new Categorias(); 
        CachedRowSet crs = new CachedRowSetImpl();
		               
        query = "SELECT * FROM categorias WHERE ct_llave = '" + ctllave + "' ";
        crs=EjecutaRS(query);
        crs.next();
        categoria.setCtLlave(crs.getString("ct_llave"));
        categoria.setCtCodigo(crs.getString("ct_codigo"));
        categoria.setCtDesc(crs.getString("ct_desc"));

        return categoria;
	}

}
