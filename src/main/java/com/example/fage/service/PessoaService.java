package com.example.fage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fage.model.Pessoa;
import com.example.fage.repository.PessoaRepository;

@Service
public class PessoaService {

    // crio o metodo repository chamando o @autowired, assim toda vez que eu utilizo
    // chamada de banco ele cria nova instancia, isso significa que a instancia será
    // gerenciada pelo Spring
    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> listarTodos() {
        return pessoaRepository.findAll();
    }

    // O save and flush salva no mesmo momento no banco de dados, diretamente.
    // Somente o save salva na memoria e depois manda ao banco
    public Pessoa salvar(Pessoa pessoa) {
        return pessoaRepository.saveAndFlush(pessoa);
    }

    public Pessoa atualizar(Pessoa pessoa) {
        return pessoaRepository.saveAndFlush(pessoa);
    }

    public void excluir(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id).get();
        pessoaRepository.delete(pessoa);
    }

}