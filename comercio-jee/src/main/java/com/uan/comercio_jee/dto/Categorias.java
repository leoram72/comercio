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

public class Categorias implements Serializable {
    private static final long serialVersionUID = 1L;

    private String ctLlave;
    private String ctCodigo;
    private String ctDesc;

    public Categorias() {
    }

    public Categorias(String ctLlave) {
        this.ctLlave = ctLlave;
    }

    public Categorias(String ctLlave, String ctCodigo, String ctDesc) {
        this.ctLlave = ctLlave;
        this.ctCodigo = ctCodigo;
        this.ctDesc = ctDesc;
    }

    public String getCtLlave() {
        return ctLlave;
    }

    public void setCtLlave(String ctLlave) {
        this.ctLlave = ctLlave;
    }

    public String getCtCodigo() {
        return ctCodigo;
    }

    public void setCtCodigo(String ctCodigo) {
        this.ctCodigo = ctCodigo;
    }

    public String getCtDesc() {
        return ctDesc;
    }

    public void setCtDesc(String ctDesc) {
        this.ctDesc = ctDesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ctLlave != null ? ctLlave.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorias)) {
            return false;
        }
        Categorias other = (Categorias) object;
        if ((this.ctLlave == null && other.ctLlave != null) || (this.ctLlave != null && !this.ctLlave.equals(other.ctLlave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.Categorias[ ctLlave=" + ctLlave + " ]";
    }
    
}
