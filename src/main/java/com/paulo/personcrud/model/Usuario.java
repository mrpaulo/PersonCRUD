/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paulo.personcrud.model;

/**
 *
 * @author paulo
 */
public class Usuario {
    private ESituacao situacao;
    private String identificador;

    public Usuario() {
    }

    public Usuario(ESituacao situacao) {
        this.situacao = situacao;
    }

    public Usuario(ESituacao situacao, String identificador) {
        this.situacao = situacao;
        this.identificador = identificador;
    }

    public ESituacao getSituacao() {
        return situacao;
    }

    public void setSituacao(ESituacao situacao) {
        this.situacao = situacao;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    
    
}
