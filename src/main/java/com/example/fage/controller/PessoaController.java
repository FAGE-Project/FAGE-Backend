package com.example.fage.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//Indica que vai ter requisições

import com.example.fage.model.Pessoa;
import com.example.fage.service.PessoaService;


@RestController
//define o endPoint dos alunos
@RequestMapping("/pessoas")
@CrossOrigin
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<Pessoa> listarTodos(){
        return pessoaService.listarTodos();
    }

    @PostMapping
    public Pessoa salvar(@RequestBody Pessoa pessoa){
        return pessoaService.salvar(pessoa);
    }

    //localhost:8080/pessoas/1 - com o verbo delete
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable ("id") Long id){
        pessoaService.excluir(id);
    }

    

}