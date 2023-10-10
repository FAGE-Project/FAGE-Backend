package com.example.fage.controller;

import com.example.fage.dto.AgendamentoDto;
import com.example.fage.dto.EmpresaDto;
import com.example.fage.dto.EmpresaListagemDto;
import com.example.fage.service.AgendamentoService;
import com.example.fage.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
@CrossOrigin
public class AgendamentoController {

    @Autowired
    AgendamentoService agendamentoService;

    @PostMapping()
    public ResponseEntity<?> cadastrar(@RequestBody AgendamentoDto agendamentoDto) {
        try {
            agendamentoService.cadastrar(agendamentoDto);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(agendamentoDto);
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
            List<AgendamentoDto> agendamentoDtoList = agendamentoService.listarAgendamentos();
            return ResponseEntity.status(HttpStatus.OK).body(agendamentoDtoList);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<?> buscaPorId(@PathVariable Long id){
        AgendamentoDto agendamentoDto = agendamentoService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(agendamentoDto);
    }

}
