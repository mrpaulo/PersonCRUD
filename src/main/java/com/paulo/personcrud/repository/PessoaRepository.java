/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paulo.personcrud.repository;

import com.paulo.personcrud.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author paulo
 */

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    public Pessoa findByCpf(String cpf);
    
}
