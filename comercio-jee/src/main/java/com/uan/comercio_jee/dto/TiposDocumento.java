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

public class TiposDocumento implements Serializable {
    private static final long serialVersionUID = 1L;

    private String tdLlave;
    private String tdCodigo;
    private String tdDesc;

    public TiposDocumento() {
    }

    public TiposDocumento(String tdLlave) {
        this.tdLlave = tdLlave;
    }

    public TiposDocumento(String tdLlave, String tdCodigo) {
        this.tdLlave = tdLlave;
        this.tdCodigo = tdCodigo;
    }

    public String getTdLlave() {
        return tdLlave;
    }

    public void setTdLlave(String tdLlave) {
        this.tdLlave = tdLlave;
    }

    public String getTdCodigo() {
        return tdCodigo;
    }

    public void setTdCodigo(String tdCodigo) {
        this.tdCodigo = tdCodigo;
    }

    public String getTdDesc() {
        return tdDesc;
    }

    public void setTdDesc(String tdDesc) {
        this.tdDesc = tdDesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tdLlave != null ? tdLlave.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposDocumento)) {
            return false;
        }
        TiposDocumento other = (TiposDocumento) object;
        if ((this.tdLlave == null && other.tdLlave != null) || (this.tdLlave != null && !this.tdLlave.equals(other.tdLlave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.TiposDocumento[ tdLlave=" + tdLlave + " ]";
    }
    
}
