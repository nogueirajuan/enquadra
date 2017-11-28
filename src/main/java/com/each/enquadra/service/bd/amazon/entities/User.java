/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.enquadra.service.bd.amazon.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author juan_
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GenericGenerator(name = "seqUser", strategy = "org.hibernate.id.IncrementGenerator")
    @GeneratedValue(generator = "seqUser")
    @Column(name = "rg")
    private Integer rg;
    @Size(max = 45)
    @Column(name = "nome")
    private String nome;
    @Size(max = 1)
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "nascimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nascimento;
    @Size(max = 45)
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "e_diretor")
    private Short eDiretor;
    @Column(name = "e_tecnico")
    private Short eTecnico;
    @Column(name = "e_aluno")
    private Short eAluno;
    @Column(name = "senha")
    private String senha;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<DiretorModalidade> diretorModalidadeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<TelefoneUser> telefoneUserList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Tecnico> tecnicoList;

    public User() {
    }

    public User(Integer rg) {
        this.rg = rg;
    }

    public Integer getRg() {
        return rg;
    }

    public void setRg(Integer rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Short getEDiretor() {
        return eDiretor;
    }

    public void setEDiretor(Short eDiretor) {
        this.eDiretor = eDiretor;
    }

    public Short getETecnico() {
        return eTecnico;
    }

    public void setETecnico(Short eTecnico) {
        this.eTecnico = eTecnico;
    }

    public Short getEAluno() {
        return eAluno;
    }

    public void setEAluno(Short eAluno) {
        this.eAluno = eAluno;
    }
    public List<DiretorModalidade> getDiretorModalidadeList() {
        return diretorModalidadeList;
    }

    public void setDiretorModalidadeList(List<DiretorModalidade> diretorModalidadeList) {
        this.diretorModalidadeList = diretorModalidadeList;
    }

    public List<TelefoneUser> getTelefoneUserList() {
        return telefoneUserList;
    }

    public void setTelefoneUserList(List<TelefoneUser> telefoneUserList) {
        this.telefoneUserList = telefoneUserList;
    }

    public List<Tecnico> getTecnicoList() {
        return tecnicoList;
    }

    public void setTecnicoList(List<Tecnico> tecnicoList) {
        this.tecnicoList = tecnicoList;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "com.each.enquadra.service.bd.amazon.entities.User[ rg=" + rg + " ]";
    }
    
}
