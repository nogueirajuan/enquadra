/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.enquadra.service.bd.amazon.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author juan_
 */
@Embeddable
public class TelefoneLocalPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "telefone")
    private String telefone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "local_idlocal")
    private int localIdlocal;

    public TelefoneLocalPK() {
    }

    public TelefoneLocalPK(String telefone, int localIdlocal) {
        this.telefone = telefone;
        this.localIdlocal = localIdlocal;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getLocalIdlocal() {
        return localIdlocal;
    }

    public void setLocalIdlocal(int localIdlocal) {
        this.localIdlocal = localIdlocal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (telefone != null ? telefone.hashCode() : 0);
        hash += (int) localIdlocal;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TelefoneLocalPK)) {
            return false;
        }
        TelefoneLocalPK other = (TelefoneLocalPK) object;
        if ((this.telefone == null && other.telefone != null) || (this.telefone != null && !this.telefone.equals(other.telefone))) {
            return false;
        }
        if (this.localIdlocal != other.localIdlocal) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.each.enquadra.service.bd.amazon.entities.TelefoneLocalPK[ telefone=" + telefone + ", localIdlocal=" + localIdlocal + " ]";
    }
    
}
