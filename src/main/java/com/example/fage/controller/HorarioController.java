package com.example.fage.controller;

import com.example.fage.dto.HorarioDto;
import com.example.fage.entity.Funcionario;
import com.example.fage.entity.Horario;
import com.example.fage.service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horario")
@CrossOrigin
public class HorarioController {

    @Autowired
    HorarioService service;

    @GetMapping("{id}")
    public ResponseEntity<?> listarHorariosPorServico(@PathVariable Long id){
        List<HorarioDto> horarios = service.buscarHorariosPorServico(id);
        return ResponseEntity.status(HttpStatus.OK).body(horarios);
    }


}
