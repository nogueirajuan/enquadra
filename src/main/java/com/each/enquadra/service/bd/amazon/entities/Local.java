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
@Table(name = "local")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Local.findAll", query = "SELECT l FROM Local l")})
public class Local implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GenericGenerator(name = "seqLocal", strategy = "org.hibernate.id.IncrementGenerator")
    @GeneratedValue(generator = "seqLocal")
    @Column(name = "idlocal")
    private Integer idlocal;
    @Size(max = 45)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "rua")
    private String rua;
    @Column(name = "numero")
    private Integer numero;
    @Size(max = 45)
    @Column(name = "cidade")
    private String cidade;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localIdlocal")
    private List<PracaEsportiva> pracaEsportivaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "local")
    private List<TelefoneLocal> telefoneLocalList;

    public Local() {
    }

    public Local(Integer idlocal) {
        this.idlocal = idlocal;
    }

    public Local(Integer idlocal, String rua) {
        this.idlocal = idlocal;
        this.rua = rua;
    }

    public Integer getIdlocal() {
        return idlocal;
    }

    public void setIdlocal(Integer idlocal) {
        this.idlocal = idlocal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    public List<PracaEsportiva> getPracaEsportivaList() {
        return pracaEsportivaList;
    }

    public void setPracaEsportivaList(List<PracaEsportiva> pracaEsportivaList) {
        this.pracaEsportivaList = pracaEsportivaList;
    }

    
    public List<TelefoneLocal> getTelefoneLocalList() {
        return telefoneLocalList;
    }

    public void setTelefoneLocalList(List<TelefoneLocal> telefoneLocalList) {
        this.telefoneLocalList = telefoneLocalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlocal != null ? idlocal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Local)) {
            return false;
        }
        Local other = (Local) object;
        if ((this.idlocal == null && other.idlocal != null) || (this.idlocal != null && !this.idlocal.equals(other.idlocal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.each.enquadra.service.bd.amazon.entities.Local[ idlocal=" + idlocal + " ]";
    }
    
}
