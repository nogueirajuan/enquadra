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
public class TelefoneAtleticaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "telefone_atletica")
    private String telefoneAtletica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "atletica_idatletica")
    private int atleticaIdatletica;

    public TelefoneAtleticaPK() {
    }

    public TelefoneAtleticaPK(String telefoneAtletica, int atleticaIdatletica) {
        this.telefoneAtletica = telefoneAtletica;
        this.atleticaIdatletica = atleticaIdatletica;
    }

    public String getTelefoneAtletica() {
        return telefoneAtletica;
    }

    public void setTelefoneAtletica(String telefoneAtletica) {
        this.telefoneAtletica = telefoneAtletica;
    }

    public int getAtleticaIdatletica() {
        return atleticaIdatletica;
    }

    public void setAtleticaIdatletica(int atleticaIdatletica) {
        this.atleticaIdatletica = atleticaIdatletica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (telefoneAtletica != null ? telefoneAtletica.hashCode() : 0);
        hash += (int) atleticaIdatletica;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TelefoneAtleticaPK)) {
            return false;
        }
        TelefoneAtleticaPK other = (TelefoneAtleticaPK) object;
        if ((this.telefoneAtletica == null && other.telefoneAtletica != null) || (this.telefoneAtletica != null && !this.telefoneAtletica.equals(other.telefoneAtletica))) {
            return false;
        }
        if (this.atleticaIdatletica != other.atleticaIdatletica) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.each.enquadra.service.bd.amazon.entities.TelefoneAtleticaPK[ telefoneAtletica=" + telefoneAtletica + ", atleticaIdatletica=" + atleticaIdatletica + " ]";
    }
    
}
