package com.example.fage.controller;

import com.example.fage.dto.LoginDto;
import com.example.fage.dto.PessoaDto;
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
    public ResponseEntity<PessoaDto> cadastrar(@RequestBody PessoaDto pessoaDto) {
        pessoaService.cadastrar(pessoaDto);
        return new ResponseEntity(pessoaDto ,HttpStatus.CREATED);
    }

    @PostMapping("/auth")
    public ResponseEntity<LoginDto> autenticar(@RequestBody LoginDto loginDto) {
        pessoaService.autenticar(loginDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
