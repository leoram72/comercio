/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uan.comercio_jee.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author lramirez
 */

public class Items implements Serializable {
    private static final long serialVersionUID = 1L;

    private String itLlave;
    private String itCodigo;
    private String itDescripcion;
    private String itImagen;
    private BigDecimal itPrecioVenta;
    private BigDecimal itPrecioCompra;
    private String itCategoria;
    private String itFamilia;
    private String itUdm;

    public Items() {
    }

    public Items(String itLlave) {
        this.itLlave = itLlave;
    }

    public Items(String itLlave, String itCodigo) {
        this.itLlave = itLlave;
        this.itCodigo = itCodigo;
    }

    public String getItLlave() {
        return itLlave;
    }

    public void setItLlave(String itLlave) {
        this.itLlave = itLlave;
    }

    public String getItCodigo() {
        return itCodigo;
    }

    public void setItCodigo(String itCodigo) {
        this.itCodigo = itCodigo;
    }

    public String getItDescripcion() {
        return itDescripcion;
    }

    public void setItDescripcion(String itDescripcion) {
        this.itDescripcion = itDescripcion;
    }

    public String getItImagen() {
        return itImagen;
    }

    public void setItImagen(String itImagen) {
        this.itImagen = itImagen;
    }

    public BigDecimal getItPrecioVenta() {
        return itPrecioVenta;
    }

    public void setItPrecioVenta(BigDecimal itPrecioVenta) {
        this.itPrecioVenta = itPrecioVenta;
    }

    public BigDecimal getItPrecioCompra() {
        return itPrecioCompra;
    }

    public void setItPrecioCompra(BigDecimal itPrecioCompra) {
        this.itPrecioCompra = itPrecioCompra;
    }

    public String getItCategoria() {
        return itCategoria;
    }

    public void setItCategoria(String itCategoria) {
        this.itCategoria = itCategoria;
    }

    public String getItFamilia() {
        return itFamilia;
    }

    public void setItFamilia(String itFamilia) {
        this.itFamilia = itFamilia;
    }

    public String getItUdm() {
        return itUdm;
    }

    public void setItUdm(String itUdm) {
        this.itUdm = itUdm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itLlave != null ? itLlave.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Items)) {
            return false;
        }
        Items other = (Items) object;
        if ((this.itLlave == null && other.itLlave != null) || (this.itLlave != null && !this.itLlave.equals(other.itLlave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.Items[ itLlave=" + itLlave + " ]";
    }
    
}
