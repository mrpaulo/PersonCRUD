/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paulo.personcrud.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author paulo
 */
@Entity
@Table(indexes = {
    @Index(name = "idx_cpf", columnList = "cpf"),})
public class Pessoa implements Serializable {
     @SequenceGenerator(name = "SEQ_PESSOA", allocationSize = 1, sequenceName = "pessoa_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PESSOA")
    @Id
    private long id;
    @Column(length = 100)
    @NotNull
    private String nome;
    @Column(length = 1)
    private String sexo;
    @Column(length = 100)
    private String email;
    @NotNull
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;
    @Column(length = 100)
    private String naturalidade;
    @Column(length = 100)
    private String nacionalidade;
    
    @Column(unique = true, length = 11)
    @NotNull
    private String cpf;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataCadastro;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
    
    
}

