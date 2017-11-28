/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.enquadra.service.bd.amazon.entities;

import java.io.Serializable;
import javax.persistence.Column;
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
@Table(name = "diretor_modalidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiretorModalidade.findAll", query = "SELECT d FROM DiretorModalidade d")})
public class DiretorModalidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DiretorModalidadePK diretorModalidadePK;
    @Column(name = "ano_mandato")
    private Integer anoMandato;
    @JoinColumn(name = "time_idtime", referencedColumnName = "idtime", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Time time;
    @JoinColumn(name = "user_rg", referencedColumnName = "rg", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public DiretorModalidade() {
    }

    public DiretorModalidade(DiretorModalidadePK diretorModalidadePK) {
        this.diretorModalidadePK = diretorModalidadePK;
    }

    public DiretorModalidade(int userRg, int timeIdtime) {
        this.diretorModalidadePK = new DiretorModalidadePK(userRg, timeIdtime);
    }

    public DiretorModalidadePK getDiretorModalidadePK() {
        return diretorModalidadePK;
    }

    public void setDiretorModalidadePK(DiretorModalidadePK diretorModalidadePK) {
        this.diretorModalidadePK = diretorModalidadePK;
    }

    public Integer getAnoMandato() {
        return anoMandato;
    }

    public void setAnoMandato(Integer anoMandato) {
        this.anoMandato = anoMandato;
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
        hash += (diretorModalidadePK != null ? diretorModalidadePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiretorModalidade)) {
            return false;
        }
        DiretorModalidade other = (DiretorModalidade) object;
        if ((this.diretorModalidadePK == null && other.diretorModalidadePK != null) || (this.diretorModalidadePK != null && !this.diretorModalidadePK.equals(other.diretorModalidadePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.each.enquadra.service.bd.amazon.entities.DiretorModalidade[ diretorModalidadePK=" + diretorModalidadePK + " ]";
    }
    
}
