package com.uan.comercio_jee.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.rowset.CachedRowSet;
import com.sun.rowset.CachedRowSetImpl;




public class EjecutaDaoJdbc<T> {	
    private Class<T> claseEntidad;
    
    public EjecutaDaoJdbc(Class<T> claseEntidad) {
        this.claseEntidad = claseEntidad;
    }
    
	public CachedRowSet EjecutaRS(String sql,String[] parametros) throws SQLException, ClassNotFoundException 
    {
		Statement stm=null;
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		Method[] metodos;
		String cad;
		int i=0;
		
            try
            {
                    Class.forName("org.postgresql.Driver");
 
                    String url = "jdbc:postgresql://127.0.0.1:5432/comerciodb";
                    con = DriverManager.getConnection(url, "postgres","123456");
                    stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                                      ResultSet.CONCUR_READ_ONLY);
 
                    ps = con.prepareStatement(sql);
                    
                    i=0;
                    for(String parametro: parametros){
                    	cad = ps.getParameterMetaData().getParameterTypeName(i+1);
                    	switch(cad){
                    	
                    	case "varchar":
                    		ps.setString(i+1,parametro);               			
                    		break;
                    	case "text":
                    		ps.setString(i+1,parametro);               			
                    		break;
                    	}
                    	i++;
                    }
                    
                    rs = ps.executeQuery();
                    
                    CachedRowSet crs = new CachedRowSetImpl();
                    crs.populate(rs);
 
                    return crs;
 
            }
            catch(SQLException sqle)
            {
            	throw sqle;

            }finally {
            	try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EjecutaDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
                }
            	try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EjecutaDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EjecutaDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
                }
			}
 
    }
 
    public T  EjecutaQuery(T entidad,String sql,String[][] parametros) throws SQLException, ClassNotFoundException 
    {
    	Statement stm=null;
		Connection con=null;
		PreparedStatement ps=null;
		int i=0;
		int j=0;
		String cad=null;
		String temp=null;
		Method[] metodos;
 
            try
            {
                    Class.forName("org.postgresql.Driver");
 
                    String url = "jdbc:postgresql://127.0.0.1:5432/comerciodb";
                    //String url = "postgres://rhoaziflcstqqp:wGE0eJY923TIa5DNP0lDsbtZBU@ec2-23-23-226-41.compute-1.amazonaws.com:5432/d6acd5rlnmusk0";
                    con = DriverManager.getConnection(url, "postgres","123456");
                    //con = DriverManager.getConnection(url, "rhoaziflcstqqp","wGE0eJY923TIa5DNP0lDsbtZBU");
                    
                    ps = con.prepareStatement(sql);
                    i=0;
                    for(String[] parametro: parametros){
                    	cad = ps.getParameterMetaData().getParameterTypeName(i+1);
                    	switch(cad){
                    	
                    	case "varchar":
	                    	metodos = entidad.getClass().getDeclaredMethods();
	                		for(Method metodo: metodos){
	                			
	                			if (metodo.getName().equals("get"+parametro[0])){
	                				ps.setString(i+1,metodo.invoke(entidad,null).toString());}                			
	                		}
	                		i++;
	                		break;
                    	case "integer":
                    		metodos = entidad.getClass().getDeclaredMethods();
	                		for(Method metodo: metodos){
	                			
	                			if (metodo.getName().equals("get"+parametro[0])){
	                				ps.setInt(i+1,Integer.parseInt(metodo.invoke(entidad,null).toString()));}                			
	                		}
	                		i++;
                    		break;
                    	case "date":
                    		metodos = entidad.getClass().getDeclaredMethods();
	                		for(Method metodo: metodos){
	                			
	                			if (metodo.getName().equals("get"+parametro[0])){
	                				ps.setDate(i+1,Date.valueOf(metodo.invoke(entidad,null).toString()));}                			
	                		}
	                		i++;
                    		break;
                    	case "text":
                    		metodos = entidad.getClass().getDeclaredMethods();
	                		for(Method metodo: metodos){
	                			
	                			if (metodo.getName().equals("get"+parametro[0])){
	                				ps.setString(i+1,metodo.invoke(entidad,null).toString());}                			
	                		}
	                		i++;
                    		break;
                    	}
                    }
                     
                    ps.executeUpdate();
                    
            }
            catch(SQLException | IllegalAccessException | IllegalArgumentException | InvocationTargetException sqle)
            {
                   sqle.printStackTrace();
            } finally {
            	try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EjecutaDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EjecutaDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
                }
			}
			return entidad;
    }
}
