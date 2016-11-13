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

public class UnidadesMedida implements Serializable {
    private static final long serialVersionUID = 1L;

    private String udmLlave;
    private String udmCodigo;
    private String udmDesc;

    public UnidadesMedida() {
    }

    public UnidadesMedida(String udmLlave) {
        this.udmLlave = udmLlave;
    }

    public UnidadesMedida(String udmLlave, String udmCodigo) {
        this.udmLlave = udmLlave;
        this.udmCodigo = udmCodigo;
    }

    public String getUdmLlave() {
        return udmLlave;
    }

    public void setUdmLlave(String udmLlave) {
        this.udmLlave = udmLlave;
    }

    public String getUdmCodigo() {
        return udmCodigo;
    }

    public void setUdmCodigo(String udmCodigo) {
        this.udmCodigo = udmCodigo;
    }

    public String getUdmDesc() {
        return udmDesc;
    }

    public void setUdmDesc(String udmDesc) {
        this.udmDesc = udmDesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (udmLlave != null ? udmLlave.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadesMedida)) {
            return false;
        }
        UnidadesMedida other = (UnidadesMedida) object;
        if ((this.udmLlave == null && other.udmLlave != null) || (this.udmLlave != null && !this.udmLlave.equals(other.udmLlave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.UnidadesMedida[ udmLlave=" + udmLlave + " ]";
    }
    
}
