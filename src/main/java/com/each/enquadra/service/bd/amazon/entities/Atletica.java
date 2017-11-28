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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author juan_
 */
@Entity
@Table(name = "atletica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Atletica.findAll", query = "SELECT a FROM Atletica a")})
public class Atletica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GenericGenerator(name = "seqAtletica", strategy = "org.hibernate.id.IncrementGenerator")
    @GeneratedValue(generator = "seqAtletica")
    @Column(name = "idatletica")
    private Integer idatletica;
    @Size(max = 45)
    @Column(name = "nome")
    private String nome;
    @Size(max = 45)
    @Column(name = "sigla")
    private String sigla;
    @Size(max = 45)
    @Column(name = "presidente")
    private String presidente;
    @Size(max = 45)
    @Column(name = "vice")
    private String vice;
    @Size(max = 45)
    @Column(name = "faculdade")
    private String faculdade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "financeiro")
    private Double financeiro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "atleticaIdatletica")
    private List<Time> timeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "atletica")
    private List<TelefoneAtletica> telefoneAtleticaList;

    public Atletica() {
    }

    public Atletica(Integer idatletica) {
        this.idatletica = idatletica;
    }

    public Integer getIdatletica() {
        return idatletica;
    }

    public void setIdatletica(Integer idatletica) {
        this.idatletica = idatletica;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getPresidente() {
        return presidente;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    public String getVice() {
        return vice;
    }

    public void setVice(String vice) {
        this.vice = vice;
    }

    public String getFaculdade() {
        return faculdade;
    }

    public void setFaculdade(String faculdade) {
        this.faculdade = faculdade;
    }

    public Double getFinanceiro() {
        return financeiro;
    }

    public void setFinanceiro(Double financeiro) {
        this.financeiro = financeiro;
    }

    public List<Time> getTimeList() {
        return timeList;
    }

    public void setTimeList(List<Time> timeList) {
        this.timeList = timeList;
    }

    public List<TelefoneAtletica> getTelefoneAtleticaList() {
        return telefoneAtleticaList;
    }

    public void setTelefoneAtleticaList(List<TelefoneAtletica> telefoneAtleticaList) {
        this.telefoneAtleticaList = telefoneAtleticaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idatletica != null ? idatletica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atletica)) {
            return false;
        }
        Atletica other = (Atletica) object;
        if ((this.idatletica == null && other.idatletica != null) || (this.idatletica != null && !this.idatletica.equals(other.idatletica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.each.enquadra.service.bd.amazon.entities.Atletica[ idatletica=" + idatletica + " ]";
    }
    
}
