package com.example.fage.controller;

import com.example.fage.dto.PessoaDto;
import com.example.fage.model.Pessoa;
import com.example.fage.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @PostMapping
    public void cadastrar(@RequestBody PessoaDto pessoaDto) {
        pessoaService.cadastrar(pessoaDto);
    }

    @PostMapping("/auth")
    public ResponseEntity<PessoaDto> autenticar(@RequestBody PessoaDto pessoaDto) {
        pessoaService.autenticar(pessoaDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
