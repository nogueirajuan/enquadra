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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "praca_esportiva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PracaEsportiva.findAll", query = "SELECT p FROM PracaEsportiva p")})
public class PracaEsportiva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GenericGenerator(name = "seqPraca", strategy = "org.hibernate.id.IncrementGenerator")
    @GeneratedValue(generator = "seqPraca")
    @Column(name = "praca_esportiva_id")
    private Integer pracaesportivaId;
    @Size(max = 45)
    @Column(name = "nome")
    private String nome;
    @Size(max = 45)
    @Column(name = "descricao")
    private String descricao;
    @JoinTable(name = "modalidades_praca", joinColumns = {
        @JoinColumn(name = "praca_esportiva_praca_esportiva_id", referencedColumnName = "praca_esportiva_id")}, inverseJoinColumns = {
        @JoinColumn(name = "Modalidades_ModalidadesId", referencedColumnName = "id")})
    @ManyToMany
    private List<Modalidades> modalidadesList;
    @JoinColumn(name = "local_idlocal", referencedColumnName = "idlocal")
    @ManyToOne(optional = false)
    private Local localIdlocal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pracaesportivapracaesportivaId")
    private List<Reserva> reservaList;

    public PracaEsportiva() {
    }

    public PracaEsportiva(Integer pracaesportivaId) {
        this.pracaesportivaId = pracaesportivaId;
    }

    public Integer getPracaesportivaId() {
        return pracaesportivaId;
    }

    public void setPracaesportivaId(Integer pracaesportivaId) {
        this.pracaesportivaId = pracaesportivaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<Modalidades> getModalidadesList() {
        return modalidadesList;
    }

    public void setModalidadesList(List<Modalidades> modalidadesList) {
        this.modalidadesList = modalidadesList;
    }

    public Local getLocalIdlocal() {
        return localIdlocal;
    }

    public void setLocalIdlocal(Local localIdlocal) {
        this.localIdlocal = localIdlocal;
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
        hash += (pracaesportivaId != null ? pracaesportivaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PracaEsportiva)) {
            return false;
        }
        PracaEsportiva other = (PracaEsportiva) object;
        if ((this.pracaesportivaId == null && other.pracaesportivaId != null) || (this.pracaesportivaId != null && !this.pracaesportivaId.equals(other.pracaesportivaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.each.enquadra.service.bd.amazon.entities.PracaEsportiva[ pracaesportivaId=" + pracaesportivaId + " ]";
    }
    
}
