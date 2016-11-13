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

public class OrdenCompraDet implements Serializable {
    private static final long serialVersionUID = 1L;

    private String docLlave;
    private String docLlaveEoc;
    private int docSecuencia;
    private Integer docCantidad;
    private BigDecimal docValUnitario;
    private BigDecimal docValTotal;
    private BigDecimal docValImpuesto;
    private String docItem;
    private OrdenCompraEnc ordenCompraEnc;

    public OrdenCompraDet() {
    }

    public OrdenCompraDet(String docLlave) {
        this.docLlave = docLlave;
    }

    public OrdenCompraDet(String docLlave, String docLlaveEoc, int docSecuencia) {
        this.docLlave = docLlave;
        this.docSecuencia = docSecuencia;
        this.docLlaveEoc = docLlaveEoc;
    }

    public String getDocLlave() {
        return docLlave;
    }

    public void setDocLlave(String docLlave) {
        this.docLlave = docLlave;
    }
	
    public String getDocLlaveEoc() {
		return docLlaveEoc;
	}

	public void setDocLlaveEoc(String docLlaveEoc) {
		this.docLlaveEoc = docLlaveEoc;
	}

	public int getDocSecuencia() {
        return docSecuencia;
    }

    public void setDocSecuencia(int docSecuencia) {
        this.docSecuencia = docSecuencia;
    }

    public Integer getDocCantidad() {
        return docCantidad;
    }

    public void setDocCantidad(Integer docCantidad) {
        this.docCantidad = docCantidad;
    }

    public BigDecimal getDocValUnitario() {
        return docValUnitario;
    }

    public void setDocValUnitario(BigDecimal docValUnitario) {
        this.docValUnitario = docValUnitario;
    }

    public BigDecimal getDocValTotal() {
        return docValTotal;
    }

    public void setDocValTotal(BigDecimal docValTotal) {
        this.docValTotal = docValTotal;
    }

    public BigDecimal getDocValImpuesto() {
        return docValImpuesto;
    }

    public void setDocValImpuesto(BigDecimal docValImpuesto) {
        this.docValImpuesto = docValImpuesto;
    }

    public String getDocItem() {
        return docItem;
    }

    public void setDocItem(String docItem) {
        this.docItem = docItem;
    }

    public OrdenCompraEnc getOrdenCompraEnc() {
        return ordenCompraEnc;
    }

    public void setOrdenCompraEnc(OrdenCompraEnc ordenCompraEnc) {
        this.ordenCompraEnc = ordenCompraEnc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (docLlave != null ? docLlave.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenCompraDet)) {
            return false;
        }
        OrdenCompraDet other = (OrdenCompraDet) object;
        if ((this.docLlave == null && other.docLlave != null) || (this.docLlave != null && !this.docLlave.equals(other.docLlave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.OrdenCompraDet[ docLlave=" + docLlave + " ]";
    }
    
}
