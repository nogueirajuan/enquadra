/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.enquadra.service.bd.amazon.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author juan_
 */
@Entity
@Table(name = "time")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Time.findAll", query = "SELECT t FROM Time t")})
public class Time implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GenericGenerator(name = "seqTime", strategy = "org.hibernate.id.IncrementGenerator")
    @GeneratedValue(generator = "seqTime")
    @Column(name = "idtime")
    private Integer idtime;
    @Size(max = 45)
    @Column(name = "nome")
    private String nome;
    @Size(max = 1)
    @Column(name = "genero")
    private String genero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "time")
    private List<Aluno> alunoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "time")
    private List<DiretorModalidade> diretorModalidadeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "time")
    private List<Tecnico> tecnicoList;
    @JoinColumn(name = "modalidades_modalidades_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Modalidades modalidadesModalidadesId;
    @JoinColumn(name = "atletica_idatletica", referencedColumnName = "idatletica")
    @ManyToOne(optional = false)
    private Atletica atleticaIdatletica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "timeIdtime")
    private List<Reserva> reservaList;

    public Time() {
    }

    public Time(Integer idtime) {
        this.idtime = idtime;
    }

    public Integer getIdtime() {
        return idtime;
    }

    public void setIdtime(Integer idtime) {
        this.idtime = idtime;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @XmlTransient
    public List<Aluno> getAlunoList() {
        return alunoList;
    }

    public void setAlunoList(List<Aluno> alunoList) {
        this.alunoList = alunoList;
    }

    @XmlTransient
    public List<DiretorModalidade> getDiretorModalidadeList() {
        return diretorModalidadeList;
    }

    public void setDiretorModalidadeList(List<DiretorModalidade> diretorModalidadeList) {
        this.diretorModalidadeList = diretorModalidadeList;
    }

    @XmlTransient
    public List<Tecnico> getTecnicoList() {
        return tecnicoList;
    }

    public void setTecnicoList(List<Tecnico> tecnicoList) {
        this.tecnicoList = tecnicoList;
    }

    public Modalidades getModalidadesModalidadesId() {
        return modalidadesModalidadesId;
    }

    public void setModalidadesModalidadesId(Modalidades modalidadesModalidadesId) {
        this.modalidadesModalidadesId = modalidadesModalidadesId;
    }

    public Atletica getAtleticaIdatletica() {
        return atleticaIdatletica;
    }

    public void setAtleticaIdatletica(Atletica atleticaIdatletica) {
        this.atleticaIdatletica = atleticaIdatletica;
    }

    @XmlTransient
    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtime != null ? idtime.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Time)) {
            return false;
        }
        Time other = (Time) object;
        if ((this.idtime == null && other.idtime != null) || (this.idtime != null && !this.idtime.equals(other.idtime))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.each.enquadra.service.bd.amazon.entities.Time[ idtime=" + idtime + " ]";
    }

}
