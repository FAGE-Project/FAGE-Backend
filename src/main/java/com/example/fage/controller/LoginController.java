package com.example.fage.controller;

import com.example.fage.model.Pessoa;
import com.example.fage.model.Prestador;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping("/cliente")
    public RequestEntity loginCliente(@RequestBody Pessoa pessoa){

    }

    @PostMapping("/prestador")
    public RequestEntity loginPrestadorServico(@RequestBody Prestador prestador){

    }

}
