package com.uan.comercio_jee.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;
import com.uan.comercio_jee.dao.OrdenCompraEncDao;
import com.uan.comercio_jee.dto.OrdenCompraEnc;


public class OrdenCompraEncDaoImpl extends EjecutaDaoJdbc<OrdenCompraEnc> implements OrdenCompraEncDao{

	public OrdenCompraEncDaoImpl() {
        super(OrdenCompraEnc.class);
    }
	
	public OrdenCompraEnc create(OrdenCompraEnc ordencompraenc) throws ClassNotFoundException, SQLException {
        String query;
		               
        query = "INSERT INTO orden_compra_enc VALUES(uuid_generate_v4(),'" + ordencompraenc.getEocNimeroOc() + "','" + ordencompraenc.getEocFecha() + "',"
        		+"'"+ordencompraenc.getEocCliente()+"','"+ordencompraenc.getEocValTotal()+"','"+ordencompraenc.getEocValImpuesto()+"','"+ordencompraenc.getEocValSubtotal()+"' "
        		+"'"+ordencompraenc.getEocFecha()+"','"
        		+"')";
        ordencompraenc = EjecutaQuery(ordencompraenc,query);

        return ordencompraenc;
    }
    
    public OrdenCompraEnc update(OrdenCompraEnc ordencompraenc) throws ClassNotFoundException, SQLException {
        String query;
		               
        query = "UPDATE orden_compra_enc SET eoc_nimero_oc = '" + ordencompraenc.getEocNimeroOc() + "', eoc_fecha = '" + ordencompraenc.getEocFecha() + "', "
        		+"eoc_cliente = '"+ordencompraenc.getEocCliente()+"', "
        		+"eoc_val_total ='"+ordencompraenc.getEocValTotal()+"', "
        		+"eoc_val_impuesto ='"+ordencompraenc.getEocValImpuesto()+"', "
        		+"eoc_val_subtotal ='"+ordencompraenc.getEocValSubtotal()+"', "
        		+"eoc_fecha_pago ='"+ordencompraenc.getEocFecha()+"', "
        		+" WHERE eoc_llave = '"+ordencompraenc.getEocLlave()+"' ";
        ordencompraenc = EjecutaQuery(ordencompraenc,query);

        return ordencompraenc;
    }
    
    public void delete(OrdenCompraEnc ordencompraenc) throws ClassNotFoundException, SQLException {
        String query;
		               
        query = "DELETE FROM ordencompraencs WHERE eoc_llave = '" + ordencompraenc.getEocLlave() + "' ";
        EjecutaQuery(ordencompraenc,query);

    }
    
    public List<OrdenCompraEnc> findAll() throws ClassNotFoundException, SQLException {
    	String query;
    	CachedRowSet crs = new CachedRowSetImpl();
        List<OrdenCompraEnc> listordencompraenc = new ArrayList<OrdenCompraEnc>(); 
        OrdenCompraEnc ordencompraenc = new OrdenCompraEnc();
		               
        query = "SELECT * FROM ordencompraencs ";
        crs=EjecutaRS(query);
        
        while(crs.next()){
        	ordencompraenc.setEocLlave(crs.getString("eoc_llave"));
        	ordencompraenc.setEocNimeroOc(crs.getInt("eoc_nimero_oc"));
        	ordencompraenc.setEocFecha(crs.getDate("eoc_fecha"));
        	ordencompraenc.setEocCliente(crs.getString("eoc_cliente"));
        	ordencompraenc.setEocValTotal(crs.getBigDecimal("eoc_val_total"));
        	ordencompraenc.setEocValImpuesto(crs.getBigDecimal("eoc_val_impuesto"));
        	ordencompraenc.setEocValSubtotal(crs.getBigDecimal("eoc_val_subtotal"));
        	ordencompraenc.setEocFechaPago(crs.getDate("eoc_fecha_pago"));

        	listordencompraenc.add(ordencompraenc);
        }

        return listordencompraenc;
    }

	public OrdenCompraEnc findById(String eocllave) throws ClassNotFoundException, SQLException {
		String query;
        OrdenCompraEnc ordencompraenc = new OrdenCompraEnc(); 
        CachedRowSet crs = new CachedRowSetImpl();
		               
        query = "SELECT * FROM ordencompraencs WHERE ar_llave = '" + eocllave + "' ";
        crs=EjecutaRS(query);
        crs.next();
    	ordencompraenc.setEocLlave(crs.getString("eoc_llave"));
    	ordencompraenc.setEocNimeroOc(crs.getInt("eoc_nimero_oc"));
    	ordencompraenc.setEocFecha(crs.getDate("eoc_fecha"));
    	ordencompraenc.setEocCliente(crs.getString("eoc_cliente"));
    	ordencompraenc.setEocValTotal(crs.getBigDecimal("eoc_val_total"));
    	ordencompraenc.setEocValImpuesto(crs.getBigDecimal("eoc_val_impuesto"));
    	ordencompraenc.setEocValSubtotal(crs.getBigDecimal("eoc_val_subtotal"));
    	ordencompraenc.setEocFechaPago(crs.getDate("eoc_fecha_pago"));

        return ordencompraenc;
	}

}
