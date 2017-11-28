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
@Table(name = "telefone_local")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TelefoneLocal.findAll", query = "SELECT t FROM TelefoneLocal t")})
public class TelefoneLocal implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TelefoneLocalPK telefoneLocalPK;
    @JoinColumn(name = "local_idlocal", referencedColumnName = "idlocal", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Local local;

    public TelefoneLocal() {
    }

    public TelefoneLocal(TelefoneLocalPK telefoneLocalPK) {
        this.telefoneLocalPK = telefoneLocalPK;
    }

    public TelefoneLocal(String telefone, int localIdlocal) {
        this.telefoneLocalPK = new TelefoneLocalPK(telefone, localIdlocal);
    }

    public TelefoneLocalPK getTelefoneLocalPK() {
        return telefoneLocalPK;
    }

    public void setTelefoneLocalPK(TelefoneLocalPK telefoneLocalPK) {
        this.telefoneLocalPK = telefoneLocalPK;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (telefoneLocalPK != null ? telefoneLocalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TelefoneLocal)) {
            return false;
        }
        TelefoneLocal other = (TelefoneLocal) object;
        if ((this.telefoneLocalPK == null && other.telefoneLocalPK != null) || (this.telefoneLocalPK != null && !this.telefoneLocalPK.equals(other.telefoneLocalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.each.enquadra.service.bd.amazon.entities.TelefoneLocal[ telefoneLocalPK=" + telefoneLocalPK + " ]";
    }
    
}
