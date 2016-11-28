package com.uan.comercio_jee.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;
import com.uan.comercio_jee.dao.AreaDao;
import com.uan.comercio_jee.dto.Areas;


public class AreaDaoImpl extends EjecutaDaoJdbc<Areas> implements AreaDao  {
    
	public AreaDaoImpl() {
        super(Areas.class);
    }
	
	public Areas create(Areas area) throws ClassNotFoundException, SQLException {
        String query;
        String[][] parametros={{"ArCodigo","arCodigo"},{"ArDesc","arDesc"}};
		               
        query = "INSERT INTO areas VALUES(uuid_generate_v4(),?,?)";
        area = EjecutaQuery(area,query,parametros);

        return area;
    }
    
    public Areas update(Areas area) throws ClassNotFoundException, SQLException {
        String query;
        String[][] parametros={{"ArCodigo","arCodigo"},{"ArDesc","arDesc"},{"ArLlave","arLlave"}};
		               
        //query = "UPDATE areas SET ar_codigo = '" + area.getArCodigo() + "', ar_desc = '" + area.getArDesc() + "' WHERE ar_llave = '"+area.getArLlave()+"' ";
        query = "UPDATE areas SET ar_codigo = ?, ar_desc = ? WHERE ar_llave = ? ";
        area = EjecutaQuery(area,query,parametros);

        return area;
    }
    
    public void delete(Areas area) throws ClassNotFoundException, SQLException {
        String query;
        String[][] parametros={{"ArLlave","arLlave"}};
		               
        //query = "DELETE FROM areas WHERE ar_llave = '" + area.getArLlave() + "' ";
        query = "DELETE FROM areas WHERE ar_llave = ? ";
        EjecutaQuery(area,query,parametros);

    }
    
    public List<Areas> findAll() throws ClassNotFoundException, SQLException {
    	String query;
    	String[] parametros={};
    	CachedRowSet crs = new CachedRowSetImpl();
        List<Areas> listarea = new ArrayList<Areas>(); 
        Areas area = new Areas();
		               
        query = "SELECT * FROM areas ";
        crs=EjecutaRS(query,parametros);
        
        while(crs.next()){
        	area.setArLlave(crs.getString("ar_llave"));
        	area.setArCodigo(crs.getString("ar_codigo"));
        	area.setArDesc(crs.getString("ar_desc"));
        	listarea.add(area);
        }

        return listarea;
    }

	public Areas findById(String arllave) throws ClassNotFoundException, SQLException {
		String query;
		String[] parametros={arllave};
        Areas area = new Areas(); 
        CachedRowSet crs = new CachedRowSetImpl();
		               
        //query = "SELECT * FROM areas WHERE ar_llave = '" + arllave + "' ";
        query = "SELECT * FROM areas WHERE ar_llave = ? ";
        crs=EjecutaRS(query,parametros);
        
        crs.next();
        area.setArLlave(crs.getString("ar_llave"));
        area.setArCodigo(crs.getString("ar_codigo"));
        area.setArDesc(crs.getString("ar_desc"));

        return area;
	}

}
