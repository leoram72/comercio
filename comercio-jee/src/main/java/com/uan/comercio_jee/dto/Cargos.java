/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uan.comercio_jee.dto;

import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author lramirez
 */

public class Cargos implements Serializable {
    private static final long serialVersionUID = 1L;
 
    private String cgLlave;
    private String cgCodigo;
    private String cgDesc;

    public Cargos() {
    }

    public Cargos(String cgLlave) {
        this.cgLlave = cgLlave;
    }

    public Cargos(String cgLlave, String cgCodigo, String cgDesc) {
        this.cgLlave = cgLlave;
        this.cgCodigo = cgCodigo;
        this.cgDesc = cgDesc;
    }

    public String getCgLlave() {
        return cgLlave;
    }

    public void setCgLlave(String cgLlave) {
        this.cgLlave = cgLlave;
    }

    public String getCgCodigo() {
        return cgCodigo;
    }

    public void setCgCodigo(String cgCodigo) {
        this.cgCodigo = cgCodigo;
    }

    public String getCgDesc() {
        return cgDesc;
    }

    public void setCgDesc(String cgDesc) {
        this.cgDesc = cgDesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cgLlave != null ? cgLlave.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargos)) {
            return false;
        }
        Cargos other = (Cargos) object;
        if ((this.cgLlave == null && other.cgLlave != null) || (this.cgLlave != null && !this.cgLlave.equals(other.cgLlave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.Cargos[ cgLlave=" + cgLlave + " ]";
    }
    
}
