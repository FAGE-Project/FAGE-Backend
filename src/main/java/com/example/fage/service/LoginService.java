package com.example.fage.service;

import com.example.fage.model.Pessoa;
import com.example.fage.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LoginService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa buscarCliente(String documento, String senha){

    }

    public Pessoa buscarPrestadorServico(String documento, String senha){

    }

}