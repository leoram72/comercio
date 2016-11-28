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
        String[][] parametros={{"EocNimeroOc","EocNimeroOc"},{"EocFecha","EocFecha"},{"EocCliente","EocCliente"},
        		{"EocValTotal","EocValTotal"},{"EocValImpuesto","EocValImpuesto"},{"EocValSubtotal","EocValSubtotal"},{"EocFecha","EocFecha"}};
		               
        query = "INSERT INTO orden_compra_enc VALUES(uuid_generate_v4(),?,?,?,?,?,?,?)";
        ordencompraenc = EjecutaQuery(ordencompraenc,query,parametros);

        return ordencompraenc;
    }
    
    public OrdenCompraEnc update(OrdenCompraEnc ordencompraenc) throws ClassNotFoundException, SQLException {
        String query;
        String[][] parametros={{"EocNimeroOc","EocNimeroOc"},{"EocFecha","EocFecha"},{"EocCliente","EocCliente"},
        		{"EocValTotal","EocValTotal"},{"EocValImpuesto","EocValImpuesto"},{"EocValSubtotal","EocValSubtotal"},{"EocFecha","EocFecha"},{"EocLlave","eocLlave"}};
		               
        query = "UPDATE orden_compra_enc SET eoc_nimero_oc = ?, eoc_fecha = ?, "
        		+"eoc_cliente = ?, "
        		+"eoc_val_total =?, "
        		+"eoc_val_impuesto =?, "
        		+"eoc_val_subtotal =?, "
        		+"eoc_fecha_pago =?, "
        		+" WHERE eoc_llave = ? ";
        ordencompraenc = EjecutaQuery(ordencompraenc,query,parametros);

        return ordencompraenc;
    }
    
    public void delete(OrdenCompraEnc ordencompraenc) throws ClassNotFoundException, SQLException {
        String query;
        String[][] parametros={{"EocLlave","eocLlave"}};
        
        query = "DELETE FROM orden_compra_enc WHERE eoc_llave = ? ";
        EjecutaQuery(ordencompraenc,query,parametros);

    }
    
    public List<OrdenCompraEnc> findAll() throws ClassNotFoundException, SQLException {
    	String query;
    	String[] parametros={};
    	CachedRowSet crs = new CachedRowSetImpl();
        List<OrdenCompraEnc> listordencompraenc = new ArrayList<OrdenCompraEnc>(); 
        OrdenCompraEnc ordencompraenc = new OrdenCompraEnc();
		               
        query = "SELECT * FROM orden_compra_enc ";
        crs=EjecutaRS(query,parametros);
        
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
		String[] parametros={eocllave};
        OrdenCompraEnc ordencompraenc = new OrdenCompraEnc(); 
        CachedRowSet crs = new CachedRowSetImpl();
		               
        query = "SELECT * FROM orden_compra_enc WHERE ar_llave = ? ";
        crs=EjecutaRS(query,parametros);
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
