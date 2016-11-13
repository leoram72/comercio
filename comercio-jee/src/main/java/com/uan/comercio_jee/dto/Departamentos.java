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
public class Departamentos implements Serializable {
    private static final long serialVersionUID = 1L;
    private String dpLlave;
    private String dpCodigo;
    private String dpDesc;

    public Departamentos() {
    }

    public Departamentos(String dpLlave) {
        this.dpLlave = dpLlave;
    }

    public Departamentos(String dpLlave, String dpCodigo) {
        this.dpLlave = dpLlave;
        this.dpCodigo = dpCodigo;
    }

    public String getDpLlave() {
        return dpLlave;
    }

    public void setDpLlave(String dpLlave) {
        this.dpLlave = dpLlave;
    }

    public String getDpCodigo() {
        return dpCodigo;
    }

    public void setDpCodigo(String dpCodigo) {
        this.dpCodigo = dpCodigo;
    }

    public String getDpDesc() {
        return dpDesc;
    }

    public void setDpDesc(String dpDesc) {
        this.dpDesc = dpDesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dpLlave != null ? dpLlave.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamentos)) {
            return false;
        }
        Departamentos other = (Departamentos) object;
        if ((this.dpLlave == null && other.dpLlave != null) || (this.dpLlave != null && !this.dpLlave.equals(other.dpLlave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.Departamentos[ dpLlave=" + dpLlave + " ]";
    }
    
}
