package com.uan.comercio_jee.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.rowset.CachedRowSet;
import com.sun.rowset.CachedRowSetImpl;




public class EjecutaDaoJdbc<T> {	
    private Class<T> claseEntidad;
    
    public EjecutaDaoJdbc(Class<T> claseEntidad) {
        this.claseEntidad = claseEntidad;
    }
    
	public CachedRowSet EjecutaRS(String sql) throws SQLException, ClassNotFoundException 
    {
		Statement stm=null;
		Connection con=null;
		ResultSet rs=null;
		
            try
            {
                    Class.forName("org.postgresql.Driver");
 
                    String url = "jdbc:postgresql://127.0.0.1:5432/comerciodb";
                    con = DriverManager.getConnection(url, "postgres","123456");
                    stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                                      ResultSet.CONCUR_READ_ONLY);
 
                    rs= stm.executeQuery(sql);
 
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
 
    public T  EjecutaQuery(T entidad,String sql) throws SQLException, ClassNotFoundException 
    {
    	Statement stm=null;
		Connection con=null;
 
            try
            {
                    Class.forName("org.postgresql.Driver");
 
                    //String url = "jdbc:postgresql://127.0.0.1:5432/comerciodb";
                    String url = "postgres://rhoaziflcstqqp:wGE0eJY923TIa5DNP0lDsbtZBU@ec2-23-23-226-41.compute-1.amazonaws.com:5432/d6acd5rlnmusk0";
                    //con = DriverManager.getConnection(url, "postgres","123456");
                    con = DriverManager.getConnection(url, "rhoaziflcstqqp","wGE0eJY923TIa5DNP0lDsbtZBU");
                    stm = con.createStatement();
 
                    stm.execute(sql);
                    //entidad.getClass() = stm.getClass();
            }
            catch(SQLException sqle)
            {
                   throw sqle;
            }finally {
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
