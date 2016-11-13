package com.uan.comercio_jee.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;
import com.uan.comercio_jee.dao.EmpleadoDao;
import com.uan.comercio_jee.dto.Empleados;
import com.uan.comercio_jee.dto.Empleados;

public class EmpleadoDaoImpl extends EjecutaDaoJdbc<Empleados> implements EmpleadoDao{

	public EmpleadoDaoImpl() {
        super(Empleados.class);
    }
	
	public Empleados create(Empleados empleado) throws ClassNotFoundException, SQLException {
        String query;
		               
        query = "INSERT INTO empleados VALUES(uuid_generate_v4(),'" + empleado.getEmCodigo() + "','" + empleado.getEmTipoIdent() + "',"
        		+"'"+empleado.getEmNumeroDent()+"','"+empleado.getEmNombres()+"','"+empleado.getEmApellidos()+"','"+empleado.getEmDireccion()+"' "
        		+"'"+empleado.getEmTelefono()+"','"+empleado.getEmMovil()+"','"+empleado.getEmCargo()+"','"+empleado.getEmDepartamento()+"' "
        		+"'"+empleado.getEmArea()+"' "
        		+"')";
        empleado = EjecutaQuery(empleado,query);

        return empleado;
    }
    
    public Empleados update(Empleados empleado) throws ClassNotFoundException, SQLException {
        String query;
		               
        query = "UPDATE empleados SET em_codigo = '" + empleado.getEmCodigo() + "', em_tipo_ident = '" + empleado.getEmTipoIdent() + "', "
        		+"em_numero_dent = '"+empleado.getEmNumeroDent()+"', "
        		+"em_nombres ='"+empleado.getEmNombres()+"', "
        		+"em_apellidos ='"+empleado.getEmApellidos()+"', "
        		+"em_direccion ='"+empleado.getEmDireccion()+"', "
        		+"em_telefono ='"+empleado.getEmTelefono()+"', "
        		+"em_movil ='"+empleado.getEmMovil()+"', "
        		+"em_cargo ='"+empleado.getEmCargo()+"', "
        		+"em_departamento ='"+empleado.getEmDepartamento()+"', "
        		+"em_area ='"+empleado.getEmArea()+"' "
        		+" WHERE em_llave = '"+empleado.getEmLlave()+"' ";
        empleado = EjecutaQuery(empleado,query);

        return empleado;
    }
    
    public void delete(Empleados empleado) throws ClassNotFoundException, SQLException {
        String query;
		               
        query = "DELETE FROM empleados WHERE em_llave = '" + empleado.getEmLlave() + "' ";
        EjecutaQuery(empleado,query);

    }
    
    public List<Empleados> findAll() throws ClassNotFoundException, SQLException {
    	String query;
    	CachedRowSet crs = new CachedRowSetImpl();
        List<Empleados> listempleado = new ArrayList<Empleados>(); 
        Empleados empleado = new Empleados();
		               
        query = "SELECT * FROM empleados ";
        crs=EjecutaRS(query);
        
        while(crs.next()){
        	empleado.setEmLlave(crs.getString("em_llave"));
        	empleado.setEmCodigo(crs.getString("em_codigo"));
        	empleado.setEmTipoIdent(crs.getString("em_tipo_ident"));
        	empleado.setEmNumeroDent(crs.getString("em_numero_dent"));
        	empleado.setEmNombres(crs.getString("em_nombres"));
        	empleado.setEmApellidos(crs.getString("em_apellidos"));
        	empleado.setEmDireccion(crs.getString("em_direccion"));
        	empleado.setEmTelefono(crs.getString("em_telefono"));
        	empleado.setEmMovil(crs.getString("em_movil"));
        	empleado.setEmCargo(crs.getString("em_cargo"));
        	empleado.setEmDepartamento(crs.getString("em_departamento"));
        	empleado.setEmArea(crs.getString("em_area"));
        	listempleado.add(empleado);
        }

        return listempleado;
    }

	public Empleados findById(String emllave) throws ClassNotFoundException, SQLException {
		String query;
        Empleados empleado = new Empleados(); 
        CachedRowSet crs = new CachedRowSetImpl();
		               
        query = "SELECT * FROM empleados WHERE em_llave = '" + emllave + "' ";
        crs=EjecutaRS(query);
        crs.next();
        empleado.setEmLlave(crs.getString("em_llave"));
    	empleado.setEmCodigo(crs.getString("em_codigo"));
    	empleado.setEmTipoIdent(crs.getString("em_tipo_ident"));
    	empleado.setEmNumeroDent(crs.getString("em_numero_dent"));
    	empleado.setEmNombres(crs.getString("em_nombres"));
    	empleado.setEmApellidos(crs.getString("em_apellidos"));
    	empleado.setEmDireccion(crs.getString("em_direccion"));
    	empleado.setEmTelefono(crs.getString("em_telefono"));
    	empleado.setEmMovil(crs.getString("em_movil"));
    	empleado.setEmCargo(crs.getString("em_cargo"));
    	empleado.setEmDepartamento(crs.getString("em_departamento"));
    	empleado.setEmArea(crs.getString("em_area"));

        return empleado;
	}

}
