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
        String[][] parametros={{"EmCodigo","emCodigo"},{"EmTipoIdent","emTipoIdent"},{"EmNumeroDent","emNumeroDent"},{"EmNombres","emNombres"},{"EmApellidos","emApellidos"},{"EmDireccion","emDireccion"},
        		{"EmTelefono","EmTelefono"},{"EmMovil","emMovil"},{"EmCargo","emCargo"},{"EmDepartamento","emDepartamento"},{"EmArea","emArea"}};
		                       
        query = "INSERT INTO empleados VALUES(uuid_generate_v4(),?,?,?,?,?,?,?,?,?,?,?)";
        
        empleado = EjecutaQuery(empleado,query,parametros);

        return empleado;
    }
    
    public Empleados update(Empleados empleado) throws ClassNotFoundException, SQLException {
        String query;
        String[][] parametros={{"EmCodigo","emCodigo"},{"EmTipoIdent","emTipoIdent"},{"EmNumeroDent","emNumeroDent"},{"EmNombres","emNombres"},{"EmApellidos","emApellidos"},{"EmDireccion","emDireccion"},
        		{"EmTelefono","EmTelefono"},{"EmMovil","emMovil"},{"EmCargo","emCargo"},{"EmDepartamento","emDepartamento"},{"EmArea","emArea"},{"EmLlave","emLlave"}};
		               
        query = "UPDATE empleados SET em_codigo = ?, em_tipo_ident = ?, "
        		+"em_numero_dent = ?, "
        		+"em_nombres =?, "
        		+"em_apellidos =?, "
        		+"em_direccion =?, "
        		+"em_telefono =?, "
        		+"em_movil =?, "
        		+"em_cargo =?, "
        		+"em_departamento =?, "
        		+"em_area =? "
        		+" WHERE em_llave = ? ";
        empleado = EjecutaQuery(empleado,query,parametros);

        return empleado;
    }
    
    public void delete(Empleados empleado) throws ClassNotFoundException, SQLException {
        String query;
        String[][] parametros={{"EmLlave","emLlave"}};
		               
        query = "DELETE FROM empleados WHERE em_llave = ? ";
        EjecutaQuery(empleado,query,parametros);

    }
    
    public List<Empleados> findAll() throws ClassNotFoundException, SQLException {
    	String query;
    	String[] parametros={};
    	CachedRowSet crs = new CachedRowSetImpl();
        List<Empleados> listempleado = new ArrayList<Empleados>(); 
        Empleados empleado = new Empleados();
		               
        query = "SELECT * FROM empleados ";
        crs=EjecutaRS(query,parametros);
        
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
		String[] parametros={emllave};
        Empleados empleado = new Empleados(); 
        CachedRowSet crs = new CachedRowSetImpl();
		               
        query = "SELECT * FROM empleados WHERE em_llave = ? ";
        crs=EjecutaRS(query,parametros);
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
