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
		               
        query = "INSERT INTO items VALUES(uuid_generate_v4(),'" + item.getItCodigo() + "','" + item.getItDescripcion() + "', "
        		+"'"+item.getItImagen()+"','"+item.getItCategoria()+"','"+item.getItFamilia()+"','"+item.getItUdm()+"', "
        		+"'"+item.getItPrecioVenta()+"','"+item.getItPrecioVenta()+"' " 
        		+"')";
        item = EjecutaQuery(item,query);

        return item;
    }
    
    public Items update(Items item) throws ClassNotFoundException, SQLException {
        String query;
		               
        query = "UPDATE items SET it_codigo = '" + item.getItCodigo() + "', it_descripcion = '" + item.getItDescripcion() +"', " 
        		+"it_imagen ='"+item.getItImagen()+"', "
        		+"it_categoria = '"+item.getItCategoria()+"', "
        		+"it_familia = '"+item.getItFamilia()+"', "
        		+"it_udm = '"+item.getItUdm()+"', "
        		+"it_precio_venta = '"+item.getItPrecioVenta()+"', "
        		+"it_precio_compra = '"+item.getItPrecioVenta()+"' " 
        		+" WHERE it_llave = '"+item.getItLlave()+"' ";
        item = EjecutaQuery(item,query);

        return item;
    }
    
    public void delete(Items item) throws ClassNotFoundException, SQLException {
        String query;
		               
        query = "DELETE FROM items WHERE it_llave = '" + item.getItLlave() + "' ";
        EjecutaQuery(item,query);

    }
    
    public List<Items> findAll() throws ClassNotFoundException, SQLException {
    	String query;
    	CachedRowSet crs = new CachedRowSetImpl();
        List<Items> listitem = new ArrayList<Items>(); 
        Items item = new Items();
		               
        query = "SELECT * FROM items ";
        crs=EjecutaRS(query);
        
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

	public Items findById(String arllave) throws ClassNotFoundException, SQLException {
		String query;
        Items item = new Items(); 
        CachedRowSet crs = new CachedRowSetImpl();
		               
        query = "SELECT * FROM items WHERE fm_llave = '" + arllave + "' ";
        crs=EjecutaRS(query);
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
