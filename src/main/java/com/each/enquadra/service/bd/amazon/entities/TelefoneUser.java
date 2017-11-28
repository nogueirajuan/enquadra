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
@Table(name = "telefone_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TelefoneUser.findAll", query = "SELECT t FROM TelefoneUser t")})
public class TelefoneUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TelefoneUserPK telefoneUserPK;
    @JoinColumn(name = "user_rg", referencedColumnName = "rg", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public TelefoneUser() {
    }

    public TelefoneUser(TelefoneUserPK telefoneUserPK) {
        this.telefoneUserPK = telefoneUserPK;
    }

    public TelefoneUser(String telefone, int userRg) {
        this.telefoneUserPK = new TelefoneUserPK(telefone, userRg);
    }

    public TelefoneUserPK getTelefoneUserPK() {
        return telefoneUserPK;
    }

    public void setTelefoneUserPK(TelefoneUserPK telefoneUserPK) {
        this.telefoneUserPK = telefoneUserPK;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (telefoneUserPK != null ? telefoneUserPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TelefoneUser)) {
            return false;
        }
        TelefoneUser other = (TelefoneUser) object;
        if ((this.telefoneUserPK == null && other.telefoneUserPK != null) || (this.telefoneUserPK != null && !this.telefoneUserPK.equals(other.telefoneUserPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.each.enquadra.service.bd.amazon.entities.TelefoneUser[ telefoneUserPK=" + telefoneUserPK + " ]";
    }
    
}
