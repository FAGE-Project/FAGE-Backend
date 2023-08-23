package com.example.fage.controller;

import com.example.fage.dto.PessoaDto;
import com.example.fage.service.PessoaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.badRequest;

@RestController
@RequestMapping("/cadastro")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody PessoaDto pessoaDto) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(pessoaService.cadastrar(pessoaDto));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}
