/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.enquadra.service.bd.amazon.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juan_
 */
@Entity
@Table(name = "tecnico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tecnico.findAll", query = "SELECT t FROM Tecnico t")})
public class Tecnico implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TecnicoPK tecnicoPK;
    @Column(name = "data_gestao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataGestao;
    @JoinColumn(name = "time_idtime", referencedColumnName = "idtime", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Time time;
    @JoinColumn(name = "user_rg", referencedColumnName = "rg", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public Tecnico() {
    }

    public Tecnico(TecnicoPK tecnicoPK) {
        this.tecnicoPK = tecnicoPK;
    }

    public Tecnico(int userRg, int timeIdtime) {
        this.tecnicoPK = new TecnicoPK(userRg, timeIdtime);
    }

    public TecnicoPK getTecnicoPK() {
        return tecnicoPK;
    }

    public void setTecnicoPK(TecnicoPK tecnicoPK) {
        this.tecnicoPK = tecnicoPK;
    }

    public Date getDataGestao() {
        return dataGestao;
    }

    public void setDataGestao(Date dataGestao) {
        this.dataGestao = dataGestao;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
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
        hash += (tecnicoPK != null ? tecnicoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tecnico)) {
            return false;
        }
        Tecnico other = (Tecnico) object;
        if ((this.tecnicoPK == null && other.tecnicoPK != null) || (this.tecnicoPK != null && !this.tecnicoPK.equals(other.tecnicoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.each.enquadra.service.bd.amazon.entities.Tecnico[ tecnicoPK=" + tecnicoPK + " ]";
    }
    
}
