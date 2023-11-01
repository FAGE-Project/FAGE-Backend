package com.example.fage.controller;

import com.example.fage.dto.AgendaDto;
import com.example.fage.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agenda")
@CrossOrigin
public class AgendaController {

    @Autowired
    AgendaService agendaService;

    @PostMapping()
    public ResponseEntity<?> cadastrar(@RequestBody AgendaDto agendaoDto) {
        try {
            agendaService.cadastrar(agendaoDto);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(agendaoDto);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

//    @GetMapping
//    public  ResponseEntity<?> buscaTodos(){
//        try {
//             List<Empresa> empresas = agendamentoService.listarTodos();
//            return ResponseEntity.status(HttpStatus.OK).body(empresas);
//        } catch (Exception e) {
//           return ResponseEntity
//                    .status(HttpStatus.BAD_REQUEST)
//                    .body(e.getMessage());
//        }
//    }

    @GetMapping
    public ResponseEntity<?> listarEmpresas(){
        try {
            List<AgendaDto> agendaDtoList = agendaService.listarAgendas();
            return ResponseEntity.status(HttpStatus.OK).body(agendaDtoList);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<?> buscaPorId(@PathVariable Long id){
        AgendaDto agendaDto = agendaService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(agendaDto);
    }

}
