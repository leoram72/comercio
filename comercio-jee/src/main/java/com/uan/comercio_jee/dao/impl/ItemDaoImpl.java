package com.uan.comercio_jee.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;
import com.uan.comercio_jee.dao.ItemDao;
import com.uan.comercio_jee.dto.Items;
import com.uan.comercio_jee.dto.Items;

public class ItemDaoImpl extends EjecutaDaoJdbc<Items> implements ItemDao{

	public ItemDaoImpl() {
        super(Items.class);
    }
	
	public Items create(Items item) throws ClassNotFoundException, SQLException {
        String query;
        String[][] parametros={{"ItCodigo","itCodigo"},{"ItDescripcion","itDescripcion"},{"ItImagen","itImagen"},
        		{"ItCategoria","itCategoria"},{"ItFamilia","itFamilia"},{"ItUdm","itUdm"}};
		               
        query = "INSERT INTO items VALUES(uuid_generate_v4(),?,?,?,?,?,?,?,?)";
        item = EjecutaQuery(item,query,parametros);

        return item;
    }
    
    public Items update(Items item) throws ClassNotFoundException, SQLException {
        String query;
        String[][] parametros={{"ItCodigo","itCodigo"},{"ItDescripcion","itDescripcion"},{"ItImagen","itImagen"},
        		{"ItCategoria","itCategoria"},{"ItFamilia","itFamilia"},{"ItUdm","itUdm"},{"ItLlave","itLlave"}};
		               
        query = "UPDATE items SET it_codigo = ?, it_descripcion = ?, " 
        		+"it_imagen =?, "
        		+"it_categoria = ?, "
        		+"it_familia = ?, "
        		+"it_udm = ?, "
        		+"it_precio_venta = ?, "
        		+"it_precio_compra = ? " 
        		+" WHERE it_llave = ? ";
        item = EjecutaQuery(item,query,parametros);

        return item;
    }
    
    public void delete(Items item) throws ClassNotFoundException, SQLException {
        String query;
        String[][] parametros={{"ItLlave","itLlave"}};
		               
        query = "DELETE FROM items WHERE it_llave = ? ";
        EjecutaQuery(item,query,parametros);

    }
    
    public List<Items> findAll() throws ClassNotFoundException, SQLException {
    	String query;
    	String[] parametros={};
    	
    	CachedRowSet crs = new CachedRowSetImpl();
        List<Items> listitem = new ArrayList<Items>(); 
        Items item = new Items();
		               
        query = "SELECT * FROM items ";
        crs=EjecutaRS(query,parametros);
        
        while(crs.next()){
        	item.setItLlave(crs.getString("it_llave"));
        	item.setItCodigo(crs.getString("it_codigo"));
        	item.setItDescripcion(crs.getString("it_descripcion"));
        	item.setItImagen(crs.getString("it_imagen"));
        	item.setItCategoria(crs.getString("it_categoria"));
        	item.setItFamilia(crs.getString("it_familia"));
        	item.setItUdm(crs.getString("it_udm"));
        	item.setItPrecioVenta(crs.getBigDecimal("it_precio_venta"));
        	item.setItPrecioCompra(crs.getBigDecimal("it_precio_compra"));
        	listitem.add(item);
        }

        return listitem;
    }

	public Items findById(String itllave) throws ClassNotFoundException, SQLException {
		String query;
		String[] parametros={itllave};
        Items item = new Items(); 
        CachedRowSet crs = new CachedRowSetImpl();
		               
        query = "SELECT * FROM items WHERE fm_llave = ? ";
        crs=EjecutaRS(query,parametros);
        crs.next();
        item.setItLlave(crs.getString("it_llave"));
        item.setItCodigo(crs.getString("it_codigo"));
        item.setItDescripcion(crs.getString("it_descripcion"));
        item.setItImagen(crs.getString("it_imagen"));
    	item.setItCategoria(crs.getString("it_categoria"));
    	item.setItFamilia(crs.getString("it_familia"));
    	item.setItUdm(crs.getString("it_udm"));
    	item.setItPrecioVenta(crs.getBigDecimal("it_precio_venta"));
    	item.setItPrecioCompra(crs.getBigDecimal("it_precio_compra"));
        
        return item;
	}

}
