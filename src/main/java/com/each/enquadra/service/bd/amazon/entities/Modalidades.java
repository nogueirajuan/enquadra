/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.enquadra.service.bd.amazon.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author juan_
 */
@Entity
@Table(name = "modalidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modalidades.findAll", query = "SELECT m FROM Modalidades m")})
public class Modalidades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GenericGenerator(name = "seqModalidade", strategy = "org.hibernate.id.IncrementGenerator")
    @GeneratedValue(generator = "seqModalidade")
    @Column(name = "id")
    private Integer Id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "sigla")
    private String sigla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome")
    private String nome;
    @ManyToMany(mappedBy = "modalidadesList")
    private List<PracaEsportiva> pracaEsportivaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modalidadesModalidadesId")
    private List<Time> timeList;

    public Modalidades() {
    }

    public Modalidades(Integer modalidadesId) {
        this.Id = modalidadesId;
    }

    public Modalidades(Integer modalidadesId, String sigla, String nome) {
        this.Id = modalidadesId;
        this.sigla = sigla;
        this.nome = nome;
    }

    public Integer getId() {
        return Id;
    }
    
    public Integer getModalidadesId() {
        return Id;
    }

    public void setModalidadesId(Integer modalidadesId) {
        this.Id = modalidadesId;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<PracaEsportiva> getPracaEsportivaList() {
        return pracaEsportivaList;
    }

    public void setPracaEsportivaList(List<PracaEsportiva> pracaEsportivaList) {
        this.pracaEsportivaList = pracaEsportivaList;
    }

    public List<Time> getTimeList() {
        return timeList;
    }

    public void setTimeList(List<Time> timeList) {
        this.timeList = timeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (Id != null ? Id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modalidades)) {
            return false;
        }
        Modalidades other = (Modalidades) object;
        if ((this.Id == null && other.Id != null) || (this.Id != null && !this.Id.equals(other.Id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.each.enquadra.service.bd.amazon.entities.Modalidades[ modalidadesId=" + Id + " ]";
    }
    
}
