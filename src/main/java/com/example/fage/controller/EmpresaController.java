package com.example.fage.controller;

import com.example.fage.dto.LoginDto;
import com.example.fage.dto.EmpresaDto;
import com.example.fage.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<EmpresaDto> cadastrar(@RequestBody EmpresaDto empresaDto) {
        empresaService.cadastrar(empresaDto);
        return new ResponseEntity(empresaDto ,HttpStatus.CREATED);
    }

    
}
