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

public class Familias implements Serializable {
    private static final long serialVersionUID = 1L;
    private String fmLlave;
    private String fmCodigo;
    private String fmDesc;

    public Familias() {
    }

    public Familias(String fmLlave) {
        this.fmLlave = fmLlave;
    }

    public Familias(String fmLlave, String fmCodigo) {
        this.fmLlave = fmLlave;
        this.fmCodigo = fmCodigo;
    }

    public String getFmLlave() {
        return fmLlave;
    }

    public void setFmLlave(String fmLlave) {
        this.fmLlave = fmLlave;
    }

    public String getFmCodigo() {
        return fmCodigo;
    }

    public void setFmCodigo(String fmCodigo) {
        this.fmCodigo = fmCodigo;
    }

    public String getFmDesc() {
        return fmDesc;
    }

    public void setFmDesc(String fmDesc) {
        this.fmDesc = fmDesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fmLlave != null ? fmLlave.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Familias)) {
            return false;
        }
        Familias other = (Familias) object;
        if ((this.fmLlave == null && other.fmLlave != null) || (this.fmLlave != null && !this.fmLlave.equals(other.fmLlave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.Familias[ fmLlave=" + fmLlave + " ]";
    }
    
}
