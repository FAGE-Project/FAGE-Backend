package com.example.fage.controller;

import com.example.fage.dto.EmpresaDto;
import com.example.fage.dto.ServicoDto;
import com.example.fage.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
@CrossOrigin
public class ServicoController {

    @Autowired
    ServicoService servicoService;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody ServicoDto servicoDto) {
        try {
            servicoService.cadastrar(servicoDto);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(servicoDto);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

//    @GetMapping
//    public  ResponseEntity<?> buscaTodos(){
//        try {
//             List<Empresa> empresas = servicoService.listarTodos();
//            return ResponseEntity.status(HttpStatus.OK).body(empresas);
//        } catch (Exception e) {
//           return ResponseEntity
//                    .status(HttpStatus.BAD_REQUEST)
//                    .body(e.getMessage());
//        }
//    }

    @GetMapping
    public ResponseEntity<?> listarServicosPorEmpresa(@RequestParam Long empresaId) {
        try {
            List<ServicoDto> servicoDtoList = servicoService.listarServicosPorEmpresa(empresaId);
            return ResponseEntity.status(HttpStatus.OK).body(servicoDtoList);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<?> buscaPorId(@PathVariable Long id){
        ServicoDto servicoDto = servicoService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(servicoDto);
    }

}
