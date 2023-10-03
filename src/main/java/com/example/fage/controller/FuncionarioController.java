package com.example.fage.controller;

import com.example.fage.dto.FuncionarioListagemDto;
import com.example.fage.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
@CrossOrigin
public class FuncionarioController {

    @Autowired
    FuncionarioService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> listarFuncionariosPorEmpresa(@PathVariable Long id){
        List<FuncionarioListagemDto> funcionarios = service.buscarTodosPorEmpresa(id);
        return ResponseEntity.status(HttpStatus.OK).body(funcionarios);
    }


}
