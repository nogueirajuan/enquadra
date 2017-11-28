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
@Table(name = "aluno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aluno.findAll", query = "SELECT a FROM Aluno a")})
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlunoPK alunoPK;
    
    @Column(name = "nro_usp")
    private Integer nroUsp;
    
    @JoinColumn(name = "time_idtime", referencedColumnName = "idtime", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Time time;
    @JoinColumn(name = "user_rg", referencedColumnName = "rg", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public Aluno() {
    }

    public Aluno(AlunoPK alunoPK) {
        this.alunoPK = alunoPK;
    }

    public Aluno(AlunoPK alunoPK, int nroUsp) {
        this.alunoPK = alunoPK;
        this.nroUsp = nroUsp;
    }

    public Aluno(int userRg, int timeIdtime) {
        this.alunoPK = new AlunoPK(userRg, timeIdtime);
    }

    public AlunoPK getAlunoPK() {
        return alunoPK;
    }

    public void setAlunoPK(AlunoPK alunoPK) {
        this.alunoPK = alunoPK;
    }

    public int getNroUsp() {
        return nroUsp;
    }

    public void setNroUsp(int nroUsp) {
        this.nroUsp = nroUsp;
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
        hash += (alunoPK != null ? alunoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "com.each.enquadra.service.bd.amazon.entities.Aluno[ alunoPK=" + alunoPK + " ]";
    }
    
}
