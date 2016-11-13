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

public class Areas implements Serializable {
    private static final long serialVersionUID = 1L;

    private String arLlave;
    private String arCodigo;
    private String arDesc;

    public Areas() {
    }

    public Areas(String arLlave) {
        this.arLlave = arLlave;
    }

    public Areas(String arLlave, String arCodigo, String adDesc) {
        this.arLlave = arLlave;
        this.arCodigo = arCodigo;
        this.arDesc = arDesc;
    }

    public String getArLlave() {
        return arLlave;
    }

    public void setArLlave(String arLlave) {
        this.arLlave = arLlave;
    }

    public String getArCodigo() {
        return arCodigo;
    }

    public void setArCodigo(String arCodigo) {
        this.arCodigo = arCodigo;
    }

    public String getArDesc() {
        return arDesc;
    }

    public void setArDesc(String arDesc) {
        this.arDesc = arDesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (arLlave != null ? arLlave.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Areas)) {
            return false;
        }
        Areas other = (Areas) object;
        if ((this.arLlave == null && other.arLlave != null) || (this.arLlave != null && !this.arLlave.equals(other.arLlave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.Areas[ arLlave=" + arLlave + " ]";
    }
    
}
