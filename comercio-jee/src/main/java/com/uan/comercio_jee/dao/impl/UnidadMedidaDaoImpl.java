package com.uan.comercio_jee.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;
import com.uan.comercio_jee.dao.UnidadMedidaDao;
import com.uan.comercio_jee.dto.UnidadesMedida;

public class UnidadMedidaDaoImpl extends EjecutaDaoJdbc<UnidadesMedida> implements UnidadMedidaDao{

	public UnidadMedidaDaoImpl() {
        super(UnidadesMedida.class);
    }
	
	public UnidadesMedida create(UnidadesMedida unidadesmedida) throws ClassNotFoundException, SQLException {
        String query;
		               
        query = "INSERT INTO unidades_medida VALUES(uuid_generate_v4(),'" + unidadesmedida.getUdmCodigo() + "','" + unidadesmedida.getUdmDesc() + "')";
        unidadesmedida = EjecutaQuery(unidadesmedida,query);

        return unidadesmedida;
    }
    
    public UnidadesMedida update(UnidadesMedida unidadesmedida) throws ClassNotFoundException, SQLException {
        String query;
		               
        query = "UPDATE unidades_medida SET udm_codigo = '" + unidadesmedida.getUdmCodigo() + "', udm_desc = '" + unidadesmedida.getUdmDesc() + "' WHERE udm_llave = '"+unidadesmedida.getUdmLlave()+"' ";
        unidadesmedida = EjecutaQuery(unidadesmedida,query);

        return unidadesmedida;
    }
    
    public void delete(UnidadesMedida unidadesmedida) throws ClassNotFoundException, SQLException {
        String query;
		               
        query = "DELETE FROM unidades_medida WHERE udm_llave = '" + unidadesmedida.getUdmLlave() + "' ";
        EjecutaQuery(unidadesmedida,query);

    }
    
    public List<UnidadesMedida> findAll() throws ClassNotFoundException, SQLException {
    	String query;
    	CachedRowSet crs = new CachedRowSetImpl();
        List<UnidadesMedida> listunidadesmedida = new ArrayList<UnidadesMedida>(); 
        UnidadesMedida unidadesmedida = new UnidadesMedida();
		               
        query = "SELECT * FROM unidades_medida ";
        crs=EjecutaRS(query);
        
        while(crs.next()){
        	unidadesmedida.setUdmLlave(crs.getString("udm_llave"));
        	unidadesmedida.setUdmCodigo(crs.getString("udm_codigo"));
        	unidadesmedida.setUdmDesc(crs.getString("udm_desc"));
        	listunidadesmedida.add(unidadesmedida);
        }

        return listunidadesmedida;
    }

	public UnidadesMedida findById(String udmllave) throws ClassNotFoundException, SQLException {
		String query;
        UnidadesMedida unidadesmedida = new UnidadesMedida(); 
        CachedRowSet crs = new CachedRowSetImpl();
		               
        query = "SELECT * FROM unidades_medida WHERE ct_llave = '" + udmllave + "' ";
        crs=EjecutaRS(query);
        crs.next();
        unidadesmedida.setUdmLlave(crs.getString("udm_llave"));
        unidadesmedida.setUdmCodigo(crs.getString("udm_codigo"));
        unidadesmedida.setUdmDesc(crs.getString("udm_desc"));

        return unidadesmedida;
	}

}
