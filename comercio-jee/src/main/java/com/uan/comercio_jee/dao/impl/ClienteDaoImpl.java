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
        String[][] parametros={{"ClCodigo","clCodigo"},{"ClTipoIdent","clTipoIdent"},{"ClNumeroIdent","clNumeroIdent"},{"ClDigitoVerificacion","clDigitoVerificacion"},{"ClRazonSocial","clRazonSocial"},
        {"ClPrimerNombre","clPrimerNombre"},{"ClSegundoNombre","clSegundoNombre"},{"ClPrimerApellido","clPrimerApellido"},{"ClSegundoApellido","clSegundoApellido"},{"ClDireccion","clDireccion"},
        {"ClTelefono","clTelefono"},{"ClCorreoElectronico","clCorreoElectronico"},{"ClFechaCreacion","clFechaCreacion"}};
		               
        query = "INSERT INTO clientes VALUES(uuid_generate_v4(),?,?,?,?,?,?,?,?,?,?,?,?,?)";
        cliente = EjecutaQuery(cliente,query,parametros);

        return cliente;
    }
    
    public Clientes update(Clientes cliente) throws ClassNotFoundException, SQLException {
        String query;
        String[][] parametros={{"ClCodigo","clCodigo"},{"ClTipoIdent","clTipoIdent"},{"ClNumeroIdent","clNumeroIdent"},{"ClDigitoVerificacion","clDigitoVerificacion"},{"ClRazonSocial","clRazonSocial"},
                {"ClPrimerNombre","clPrimerNombre"},{"ClSegundoNombre","clSegundoNombre"},{"ClPrimerApellido","clPrimerApellido"},{"ClSegundoApellido","clSegundoApellido"},{"ClDireccion","clDireccion"},
                {"ClTelefono","clTelefono"},{"ClCorreoElectronico","clCorreoElectronico"},{"ClFechaCreacion","clFechaCreacion"},{"ClLlave","clLlave"}};
		               
        query = "UPDATE clientes SET cl_codigo = '" + cliente.getClCodigo() + "', cl_tipo_ident = '" + cliente.getClTipoIdent()+"', "
        		+"cl_numero_ident = ?, "
        		+"cl_digito_verificacion = ?, "
        		+"cl_razon_social = ?, "
        		+"cl_primer_nombre = ?, "
        		+"cl_segundo_nombre = ?, "
        		+"cl_primer_apellido = ?, "
        		+"cl_segundo_apellido =?, "
        		+"cl_direccion =?, "
        		+"cl_telefono =?, "
        		+"cl_correo_electronico =?, "
        		+"cl_fecha_creacion =? "
        		+" WHERE ar_llave = ? ";
        cliente = EjecutaQuery(cliente,query,parametros);

        return cliente;
    }
    
    public void delete(Clientes cliente) throws ClassNotFoundException, SQLException {
        String query;
        String[][] parametros={{"ClLlave","clLlave"}};
		               
        query = "DELETE FROM clientes WHERE cl_llave = ? ";
        EjecutaQuery(cliente,query,parametros);

    }
    
    public List<Clientes> findAll() throws ClassNotFoundException, SQLException {
    	String query;
    	String[] parametros={};
    	CachedRowSet crs = new CachedRowSetImpl();
        List<Clientes> listcliente = new ArrayList<Clientes>(); 
        Clientes cliente = new Clientes();
		               
        query = "SELECT * FROM clientes ";
        crs=EjecutaRS(query,parametros);
        
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

	public Clientes findById(String clllave) throws ClassNotFoundException, SQLException {
		String query;
		String[] parametros={clllave};
        Clientes cliente = new Clientes(); 
        CachedRowSet crs = new CachedRowSetImpl();
		               
        query = "SELECT * FROM clientes WHERE cl_llave = ? ";
        crs=EjecutaRS(query,parametros);
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
