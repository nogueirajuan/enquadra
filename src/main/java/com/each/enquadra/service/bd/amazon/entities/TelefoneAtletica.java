/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.enquadra.service.bd.amazon.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juan_
 */
@Entity
@Table(name = "telefone_atletica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TelefoneAtletica.findAll", query = "SELECT t FROM TelefoneAtletica t")})
public class TelefoneAtletica implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TelefoneAtleticaPK telefoneAtleticaPK;
    @JoinColumn(name = "atletica_idatletica", referencedColumnName = "idatletica", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Atletica atletica;

    public TelefoneAtletica() {
    }

    public TelefoneAtletica(TelefoneAtleticaPK telefoneAtleticaPK) {
        this.telefoneAtleticaPK = telefoneAtleticaPK;
    }

    public TelefoneAtletica(String telefoneAtletica, int atleticaIdatletica) {
        this.telefoneAtleticaPK = new TelefoneAtleticaPK(telefoneAtletica, atleticaIdatletica);
    }

    public TelefoneAtleticaPK getTelefoneAtleticaPK() {
        return telefoneAtleticaPK;
    }

    public void setTelefoneAtleticaPK(TelefoneAtleticaPK telefoneAtleticaPK) {
        this.telefoneAtleticaPK = telefoneAtleticaPK;
    }

    public Atletica getAtletica() {
        return atletica;
    }

    public void setAtletica(Atletica atletica) {
        this.atletica = atletica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (telefoneAtleticaPK != null ? telefoneAtleticaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TelefoneAtletica)) {
            return false;
        }
        TelefoneAtletica other = (TelefoneAtletica) object;
        if ((this.telefoneAtleticaPK == null && other.telefoneAtleticaPK != null) || (this.telefoneAtleticaPK != null && !this.telefoneAtleticaPK.equals(other.telefoneAtleticaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.each.enquadra.service.bd.amazon.entities.TelefoneAtletica[ telefoneAtleticaPK=" + telefoneAtleticaPK + " ]";
    }
    
}
