/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uan.comercio_jee.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author lramirez
 */
public class Clientes implements Serializable {
    private static final long serialVersionUID = 1L;

    private String clLlave;
    private String clCodigo;
    private String clTipoIdent;
    private String clNumeroIdent;
    private String clDigitoVerificacion;
    private String clRazonSocial;
    private String clPrimerNombre;
    private String clSegundoNombre;
    private String clPrimerApellido;
    private String clSegundoApellido;
    private String clDireccion;
    private String clTelefono;
    private String clCorreoElectronico;
    private Date clFechaCreacion;

    public Clientes() {
    }

    public Clientes(String clLlave) {
        this.clLlave = clLlave;
    }

    public Clientes(String clLlave, String clCodigo) {
        this.clLlave = clLlave;
        this.clCodigo = clCodigo;
    }

    public String getClLlave() {
        return clLlave;
    }

    public void setClLlave(String clLlave) {
        this.clLlave = clLlave;
    }

    public String getClCodigo() {
        return clCodigo;
    }

    public void setClCodigo(String clCodigo) {
        this.clCodigo = clCodigo;
    }

    public String getClTipoIdent() {
        return clTipoIdent;
    }

    public void setClTipoIdent(String clTipoIdent) {
        this.clTipoIdent = clTipoIdent;
    }

    public String getClNumeroIdent() {
        return clNumeroIdent;
    }

    public void setClNumeroIdent(String clNumeroIdent) {
        this.clNumeroIdent = clNumeroIdent;
    }

    public String getClDigitoVerificacion() {
        return clDigitoVerificacion;
    }

    public void setClDigitoVerificacion(String clDigitoVerificacion) {
        this.clDigitoVerificacion = clDigitoVerificacion;
    }

    public String getClRazonSocial() {
        return clRazonSocial;
    }

    public void setClRazonSocial(String clRazonSocial) {
        this.clRazonSocial = clRazonSocial;
    }

    public String getClPrimerNombre() {
        return clPrimerNombre;
    }

    public void setClPrimerNombre(String clPrimerNombre) {
        this.clPrimerNombre = clPrimerNombre;
    }

    public String getClSegundoNombre() {
        return clSegundoNombre;
    }

    public void setClSegundoNombre(String clSegundoNombre) {
        this.clSegundoNombre = clSegundoNombre;
    }

    public String getClPrimerApellido() {
        return clPrimerApellido;
    }

    public void setClPrimerApellido(String clPrimerApellido) {
        this.clPrimerApellido = clPrimerApellido;
    }

    public String getClSegundoApellido() {
        return clSegundoApellido;
    }

    public void setClSegundoApellido(String clSegundoApellido) {
        this.clSegundoApellido = clSegundoApellido;
    }

    public String getClDireccion() {
        return clDireccion;
    }

    public void setClDireccion(String clDireccion) {
        this.clDireccion = clDireccion;
    }

    public String getClTelefono() {
        return clTelefono;
    }

    public void setClTelefono(String clTelefono) {
        this.clTelefono = clTelefono;
    }

    public String getClCorreoElectronico() {
        return clCorreoElectronico;
    }

    public void setClCorreoElectronico(String clCorreoElectronico) {
        this.clCorreoElectronico = clCorreoElectronico;
    }

    public Date getClFechaCreacion() {
        return clFechaCreacion;
    }

    public void setClFechaCreacion(Date clFechaCreacion) {
        this.clFechaCreacion = clFechaCreacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clLlave != null ? clLlave.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.clLlave == null && other.clLlave != null) || (this.clLlave != null && !this.clLlave.equals(other.clLlave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.Clientes[ clLlave=" + clLlave + " ]";
    }
    
}
