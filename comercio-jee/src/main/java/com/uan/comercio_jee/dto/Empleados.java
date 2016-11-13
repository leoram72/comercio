/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uan.comercio_jee.dto;

import java.io.Serializable;

/**
 *
 * @author lramirez
 */
public class Empleados implements Serializable {
    private static final long serialVersionUID = 1L;
    private String emLlave;
    private String emCodigo;
    private String emNumeroDent;
    private String emNombres;
    private String emApellidos;
    private String emDireccion;
    private String emTelefono;
    private String emMovil;
    private String emArea;
    private String emCargo;
    private String emDepartamento;
    private String emTipoIdent;

    public Empleados() {
    }

    public Empleados(String emLlave) {
        this.emLlave = emLlave;
    }

    public String getEmLlave() {
        return emLlave;
    }

    public void setEmLlave(String emLlave) {
        this.emLlave = emLlave;
    }

    public String getEmCodigo() {
        return emCodigo;
    }

    public void setEmCodigo(String emCodigo) {
        this.emCodigo = emCodigo;
    }

    public String getEmNumeroDent() {
        return emNumeroDent;
    }

    public void setEmNumeroDent(String emNumeroDent) {
        this.emNumeroDent = emNumeroDent;
    }

    public String getEmNombres() {
        return emNombres;
    }

    public void setEmNombres(String emNombres) {
        this.emNombres = emNombres;
    }

    public String getEmApellidos() {
        return emApellidos;
    }

    public void setEmApellidos(String emApellidos) {
        this.emApellidos = emApellidos;
    }

    public String getEmDireccion() {
        return emDireccion;
    }

    public void setEmDireccion(String emDireccion) {
        this.emDireccion = emDireccion;
    }

    public String getEmTelefono() {
        return emTelefono;
    }

    public void setEmTelefono(String emTelefono) {
        this.emTelefono = emTelefono;
    }

    public String getEmMovil() {
        return emMovil;
    }

    public void setEmMovil(String emMovil) {
        this.emMovil = emMovil;
    }

    public String getEmArea() {
        return emArea;
    }

    public void setEmArea(String emArea) {
        this.emArea = emArea;
    }

    public String getEmCargo() {
        return emCargo;
    }

    public void setEmCargo(String emCargo) {
        this.emCargo = emCargo;
    }

    public String getEmDepartamento() {
        return emDepartamento;
    }

    public void setEmDepartamento(String emDepartamento) {
        this.emDepartamento = emDepartamento;
    }

    public String getEmTipoIdent() {
        return emTipoIdent;
    }

    public void setEmTipoIdent(String emTipoIdent) {
        this.emTipoIdent = emTipoIdent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emLlave != null ? emLlave.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleados)) {
            return false;
        }
        Empleados other = (Empleados) object;
        if ((this.emLlave == null && other.emLlave != null) || (this.emLlave != null && !this.emLlave.equals(other.emLlave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.Empleados[ emLlave=" + emLlave + " ]";
    }
    
}
