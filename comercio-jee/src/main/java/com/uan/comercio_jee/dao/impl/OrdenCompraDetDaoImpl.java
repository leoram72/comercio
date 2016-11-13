package com.uan.comercio_jee.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;
import com.uan.comercio_jee.dao.OrdenCompraDetDao;
import com.uan.comercio_jee.dto.OrdenCompraDet;
import com.uan.comercio_jee.dto.OrdenCompraDet;

public class OrdenCompraDetDaoImpl extends EjecutaDaoJdbc<OrdenCompraDet> implements OrdenCompraDetDao{

	public OrdenCompraDetDaoImpl() {
        super(OrdenCompraDet.class);
    }
	
	public OrdenCompraDet create(OrdenCompraDet ordencompradet) throws ClassNotFoundException, SQLException {
        String query;
		               
        query = "INSERT INTO orden_compra_det VALUES(uuid_generate_v4(),'" + ordencompradet.getDocLlaveEoc() + "','" + ordencompradet.getDocSecuencia() + "',"
        		+"'"+ordencompradet.getDocItem()+"','"+ordencompradet.getDocCantidad()+"','"+ordencompradet.getDocValUnitario()+"','"+ordencompradet.getDocValTotal()+"' "
        		+"'"+ordencompradet.getDocValImpuesto()+"','"
        		+"')";
        ordencompradet = EjecutaQuery(ordencompradet,query);

        return ordencompradet;
    }
    
    public OrdenCompraDet update(OrdenCompraDet ordencompradet) throws ClassNotFoundException, SQLException {
        String query;
		               
        query = "UPDATE orden_compra_det SET doc_llave_eoc = '" + ordencompradet.getDocLlaveEoc() + "', doc_secuencia = '" + ordencompradet.getDocSecuencia() + "', "
        		+"doc_item = '"+ordencompradet.getDocItem()+"', "
        		+"doc_cantidad ='"+ordencompradet.getDocCantidad()+"', "
        		+"doc_val_unitario ='"+ordencompradet.getDocValUnitario()+"', "
        		+"doc_val_total ='"+ordencompradet.getDocValTotal()+"', "
        		+"doc_val_impuesto ='"+ordencompradet.getDocValImpuesto()+"', "
        		+" WHERE doc_llave = '"+ordencompradet.getDocLlave()+"' ";
        ordencompradet = EjecutaQuery(ordencompradet,query);

        return ordencompradet;
    }
    
    public void delete(OrdenCompraDet ordencompradet) throws ClassNotFoundException, SQLException {
        String query;
		               
        query = "DELETE FROM orden_compra_det WHERE doc_llave = '" + ordencompradet.getDocLlave() + "' ";
        EjecutaQuery(ordencompradet,query);

    }
    
    public List<OrdenCompraDet> findAll() throws ClassNotFoundException, SQLException {
    	String query;
    	CachedRowSet crs = new CachedRowSetImpl();
        List<OrdenCompraDet> listordencompradet = new ArrayList<OrdenCompraDet>(); 
        OrdenCompraDet ordencompradet = new OrdenCompraDet();
		               
        query = "SELECT * FROM orden_compra_det ";
        crs=EjecutaRS(query);
        
        while(crs.next()){
        	ordencompradet.setDocLlave(crs.getString("doc_llave"));
        	ordencompradet.setDocLlaveEoc(crs.getString("doc_llave_eoc"));
        	ordencompradet.setDocSecuencia(crs.getInt("doc_secuencia"));
        	ordencompradet.setDocItem(crs.getString("doc_item"));
        	ordencompradet.setDocCantidad(crs.getInt("doc_cantidad"));
        	ordencompradet.setDocValUnitario(crs.getBigDecimal("doc_val_unitario"));
        	ordencompradet.setDocValTotal(crs.getBigDecimal("doc_val_total"));
        	ordencompradet.setDocValImpuesto(crs.getBigDecimal("doc_val_impuesto"));

        	listordencompradet.add(ordencompradet);
        }

        return listordencompradet;
    }

	public OrdenCompraDet findById(String eocllave) throws ClassNotFoundException, SQLException {
		String query;
        OrdenCompraDet ordencompradet = new OrdenCompraDet(); 
        CachedRowSet crs = new CachedRowSetImpl();
		               
        query = "SELECT * FROM ordencompradets WHERE ar_llave = '" + eocllave + "' ";
        crs=EjecutaRS(query);
        crs.next();
        ordencompradet.setDocLlave(crs.getString("doc_llave"));
    	ordencompradet.setDocLlaveEoc(crs.getString("doc_llave_eoc"));
    	ordencompradet.setDocSecuencia(crs.getInt("doc_secuencia"));
    	ordencompradet.setDocItem(crs.getString("doc_item"));
    	ordencompradet.setDocCantidad(crs.getInt("doc_cantidad"));
    	ordencompradet.setDocValUnitario(crs.getBigDecimal("doc_val_unitario"));
    	ordencompradet.setDocValTotal(crs.getBigDecimal("doc_val_total"));
    	ordencompradet.setDocValImpuesto(crs.getBigDecimal("doc_val_impuesto"));

        return ordencompradet;
	}

}
