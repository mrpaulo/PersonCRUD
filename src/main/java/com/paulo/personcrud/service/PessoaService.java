/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paulo.personcrud.service;

import com.paulo.personcrud.model.Pessoa;
import com.paulo.personcrud.repository.PessoaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author paulo
 */
@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    public List<Pessoa> buscarTodas() {
        return pessoaRepository.findAll();
    }

    public Pessoa buscarPorId(Long pessoaId) {
        return pessoaRepository.findOne(pessoaId);
    }

    public Pessoa buscarPorCpf(String cpf) {
        return pessoaRepository.findByCpf(cpf);
    }

    public Pessoa salvar(Pessoa pessoa) {
        return pessoaRepository.saveAndFlush(pessoa);
    }

    public Pessoa editar(Long pessoaId, Pessoa pessoaDetalhes) throws ExcecaoPropria {
        Pessoa pessoa = buscarPorId(pessoaId);
        checarPessoaNull(pessoaId, pessoa);
        pessoa.setNome(pessoaDetalhes.getNome());
        pessoa.setSexo(pessoaDetalhes.getSexo());
        pessoa.setEmail(pessoaDetalhes.getEmail());
        pessoa.setDataNascimento(pessoaDetalhes.getDataNascimento());
        pessoa.setNaturalidade(pessoaDetalhes.getNaturalidade());
        pessoa.setNacionalidade(pessoaDetalhes.getNacionalidade());
        pessoa.setCpf(pessoaDetalhes.getCpf());

        return pessoaRepository.saveAndFlush(pessoa);
    }

    public void excluir(Long pessoaId) {
        pessoaRepository.delete(pessoaId);
    }

    public void checarPessoaNull(Long pessoaId, Pessoa pessoa) throws ExcecaoPropria {
        if (pessoa == null) {
            throw new ExcecaoPropria("Pessoa não encontrada para o id: " + pessoaId);
        }
    }

}
