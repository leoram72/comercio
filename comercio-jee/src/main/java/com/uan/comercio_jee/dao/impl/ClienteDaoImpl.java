package com.uan.comercio_jee.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;
import javax.swing.JEditorPane;

import com.sun.rowset.CachedRowSetImpl;
import com.uan.comercio_jee.dao.ClienteDao;
import com.uan.comercio_jee.dto.Clientes;
import com.uan.comercio_jee.dto.Clientes;

public class ClienteDaoImpl extends EjecutaDaoJdbc<Clientes> implements ClienteDao{
    
	public ClienteDaoImpl() {
        super(Clientes.class);
    }
	
	public Clientes create(Clientes cliente) throws ClassNotFoundException, SQLException {
        String query;
		               
        query = "INSERT INTO clientes VALUES(uuid_generate_v4(),'" + cliente.getClCodigo() + "','" + cliente.getClTipoIdent() + "',"
        		+"'"+cliente.getClNumeroIdent()+"','"+cliente.getClDigitoVerificacion()+"','"+cliente.getClRazonSocial()+"',"
        		+"'"+cliente.getClPrimerNombre()+"','"+cliente.getClSegundoNombre()+"','"+cliente.getClPrimerApellido()+"',"
        		+"'"+cliente.getClSegundoApellido()+"','"+cliente.getClDireccion()+"','"+cliente.getClTelefono()+"','"+cliente.getClCorreoElectronico()+"',"
        		+"'"+cliente.getClFechaCreacion()+"'"+")";
        cliente = EjecutaQuery(cliente,query);

        return cliente;
    }
    
    public Clientes update(Clientes cliente) throws ClassNotFoundException, SQLException {
        String query;
		               
        query = "UPDATE clientes SET cl_codigo = '" + cliente.getClCodigo() + "', cl_tipo_ident = '" + cliente.getClTipoIdent()+"', "
        		+"cl_numero_ident ='"+cliente.getClNumeroIdent()+"', "
        		+"cl_digito_verificacion ='"+cliente.getClDigitoVerificacion()+"', "
        		+"cl_razon_social ='"+cliente.getClRazonSocial()+"', "
        		+"cl_primer_nombre ='"+cliente.getClPrimerNombre()+"', "
        		+"cl_segundo_nombre ='"+cliente.getClSegundoNombre()+"', "
        		+"cl_primer_apellido ='"+cliente.getClPrimerApellido()+"', "
        		+"cl_segundo_apellido ='"+cliente.getClSegundoApellido()+"', "
        		+"cl_direccion ='"+cliente.getClDireccion()+"', "
        		+"cl_telefono ='"+cliente.getClTelefono()+"', "
        		+"cl_correo_electronico ='"+cliente.getClCorreoElectronico()+"', "
        		+"cl_fecha_creacion ='"+cliente.getClFechaCreacion()+"' "
        		+" WHERE ar_llave = '"+cliente.getClLlave()+"' ";
        cliente = EjecutaQuery(cliente,query);

        return cliente;
    }
    
    public void delete(Clientes cliente) throws ClassNotFoundException, SQLException {
        String query;
		               
        query = "DELETE FROM clientes WHERE cl_llave = '" + cliente.getClLlave() + "' ";
        EjecutaQuery(cliente,query);

    }
    
    public List<Clientes> findAll() throws ClassNotFoundException, SQLException {
    	String query;
    	CachedRowSet crs = new CachedRowSetImpl();
        List<Clientes> listcliente = new ArrayList<Clientes>(); 
        Clientes cliente = new Clientes();
		               
        query = "SELECT * FROM clientes ";
        crs=EjecutaRS(query);
        
        while(crs.next()){
        	cliente.setClLlave(crs.getString("cl_llave"));
        	cliente.setClCodigo(crs.getString("cl_codigo"));
        	cliente.setClTipoIdent(crs.getString("cl_tipo_ident"));
        	cliente.setClNumeroIdent(crs.getString("cl_numero_ident"));
        	cliente.setClDigitoVerificacion(crs.getString("cl_digito_verificacion"));
        	cliente.setClRazonSocial(crs.getString("cl_razon_social"));
        	cliente.setClPrimerNombre(crs.getString("cl_primer_nombre"));
        	cliente.setClSegundoNombre(crs.getString("cl_segundo_nombre"));
        	cliente.setClPrimerApellido(crs.getString("cl_primer_apellido"));
        	cliente.setClSegundoApellido(crs.getString("cl_segundo_apellido"));
        	cliente.setClDireccion(crs.getString("cl_direccion"));
        	cliente.setClTelefono(crs.getString("cl_telefono"));
        	cliente.setClCorreoElectronico(crs.getString("cl_correo_electronico"));
        	cliente.setClFechaCreacion(crs.getDate("cl_fecha_creacion"));
        }

        return listcliente;
    }

	public Clientes findById(String arllave) throws ClassNotFoundException, SQLException {
		String query;
        Clientes cliente = new Clientes(); 
        CachedRowSet crs = new CachedRowSetImpl();
		               
        query = "SELECT * FROM clientes WHERE cl_llave = '" + arllave + "' ";
        crs=EjecutaRS(query);
        crs.next();
        cliente.setClLlave(crs.getString("cl_llave"));
    	cliente.setClCodigo(crs.getString("cl_codigo"));
    	cliente.setClTipoIdent(crs.getString("cl_tipo_ident"));
    	cliente.setClNumeroIdent(crs.getString("cl_numero_ident"));
    	cliente.setClDigitoVerificacion(crs.getString("cl_digito_verificacion"));
    	cliente.setClRazonSocial(crs.getString("cl_razon_social"));
    	cliente.setClPrimerNombre(crs.getString("cl_primer_nombre"));
    	cliente.setClSegundoNombre(crs.getString("cl_segundo_nombre"));
    	cliente.setClPrimerApellido(crs.getString("cl_primer_apellido"));
    	cliente.setClSegundoApellido(crs.getString("cl_segundo_apellido"));
    	cliente.setClDireccion(crs.getString("cl_direccion"));
    	cliente.setClTelefono(crs.getString("cl_telefono"));
    	cliente.setClCorreoElectronico(crs.getString("cl_correo_electronico"));
    	cliente.setClFechaCreacion(crs.getDate("cl_fecha_creacion"));

        return cliente;
	}

}
