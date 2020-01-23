/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paulo.personcrud.controller;

import com.paulo.personcrud.model.ESituacao;
import com.paulo.personcrud.model.Pessoa;
import com.paulo.personcrud.model.Usuario;
import com.paulo.personcrud.service.ExcecaoPropria;
import com.paulo.personcrud.service.PessoaService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author paulo
 */
@RestController
@CrossOrigin(origins = "http://localhost:4060")
@RequestMapping("/api/v1")
public class PessoaController {

	@Autowired
	PessoaService pessoaService;

	@GetMapping("/pessoas")
	public List<Pessoa> getTodasPessoas() {
		return pessoaService.buscarTodas();
	}

	@GetMapping("/pessoa/{id}")
	public ResponseEntity<Pessoa> getPessoaPorId(@PathVariable(value = "id") Long pessoaId) throws ExcecaoPropria {
		Pessoa pessoa = pessoaService.buscarPorId(pessoaId);

		pessoaService.checarPessoaNull(pessoaId, pessoa);
		return ResponseEntity.ok().body(pessoa);
	}

	@PostMapping("/pessoa")
	public Pessoa criarPessoa(@Valid @RequestBody Pessoa pessoa) {
		Pessoa pessoaSalva = pessoaService.salvar(pessoa);
		return pessoaService.buscarPorId(pessoaSalva.getId());
	}

	@PutMapping("/pessoa/{id}")
	public ResponseEntity<Pessoa> updatePessoa(@PathVariable(value = "id") Long pessoaId, @Valid @RequestBody Pessoa pessoaDetalhes) throws ExcecaoPropria {
		
		final Pessoa pessoaAtualizada = pessoaService.editar(pessoaId, pessoaDetalhes);
		return ResponseEntity.ok(pessoaAtualizada);
	}

	@DeleteMapping("/pessoa/{id}")
	public Map<String, Boolean> deletePessoa(@PathVariable(value = "id") Long pessoaId) throws ExcecaoPropria {
		Pessoa pessoa = pessoaService.buscarPorId(pessoaId);
		pessoaService.checarPessoaNull(pessoaId, pessoa);

		pessoaService.excluir(pessoaId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	
	
	@GetMapping(produces = "application/json")
	@RequestMapping({ "/validateLogin" })
	public Usuario validateLogin() {
		return new Usuario(ESituacao.AUTORIZADO);
	}}
