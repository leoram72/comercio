/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uan.comercio_jee.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author lramirez
 */

public class OrdenCompraEnc implements Serializable {
    private static final long serialVersionUID = 1L;

    private String eocLlave;
    private int eocNimeroOc;
    private Date eocFecha;
    private BigDecimal eocValTotal;
    private BigDecimal eocValImpuesto;
    private BigDecimal eocValSubtotal;
    private Date eocFechaPago;
    private String eocCliente;

    public OrdenCompraEnc() {
    }

    public OrdenCompraEnc(String eocLlave) {
        this.eocLlave = eocLlave;
    }

    public OrdenCompraEnc(String eocLlave, int eocNimeroOc) {
        this.eocLlave = eocLlave;
        this.eocNimeroOc = eocNimeroOc;
    }

    public String getEocLlave() {
        return eocLlave;
    }

    public void setEocLlave(String eocLlave) {
        this.eocLlave = eocLlave;
    }

    public int getEocNimeroOc() {
        return eocNimeroOc;
    }

    public void setEocNimeroOc(int eocNimeroOc) {
        this.eocNimeroOc = eocNimeroOc;
    }

    public Date getEocFecha() {
        return eocFecha;
    }

    public void setEocFecha(Date eocFecha) {
        this.eocFecha = eocFecha;
    }

    public BigDecimal getEocValTotal() {
        return eocValTotal;
    }

    public void setEocValTotal(BigDecimal eocValTotal) {
        this.eocValTotal = eocValTotal;
    }

    public BigDecimal getEocValImpuesto() {
        return eocValImpuesto;
    }

    public void setEocValImpuesto(BigDecimal eocValImpuesto) {
        this.eocValImpuesto = eocValImpuesto;
    }

    public BigDecimal getEocValSubtotal() {
        return eocValSubtotal;
    }

    public void setEocValSubtotal(BigDecimal eocValSubtotal) {
        this.eocValSubtotal = eocValSubtotal;
    }

    public Date getEocFechaPago() {
        return eocFechaPago;
    }

    public void setEocFechaPago(Date eocFechaPago) {
        this.eocFechaPago = eocFechaPago;
    }

    public String getEocCliente() {
        return eocCliente;
    }

    public void setEocCliente(String eocCliente) {
        this.eocCliente = eocCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eocLlave != null ? eocLlave.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenCompraEnc)) {
            return false;
        }
        OrdenCompraEnc other = (OrdenCompraEnc) object;
        if ((this.eocLlave == null && other.eocLlave != null) || (this.eocLlave != null && !this.eocLlave.equals(other.eocLlave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.OrdenCompraEnc[ eocLlave=" + eocLlave + " ]";
    }
    
}
