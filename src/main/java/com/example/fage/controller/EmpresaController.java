package com.example.fage.controller;

import com.example.fage.dto.EmpresaListagemDto;
// import com.example.fage.dto.LoginDto;
import com.example.fage.entity.Empresa;
import com.example.fage.dto.EmpresaDto;
import com.example.fage.service.EmpresaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empresa")
@CrossOrigin
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody EmpresaDto empresaDto) {
        try {
            empresaService.cadastrar(empresaDto);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(empresaDto);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

//    @GetMapping
//    public  ResponseEntity<?> buscaTodos(){
//        try {
//             List<Empresa> empresas = empresaService.listarTodos();
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
            List<EmpresaListagemDto> empresaListagem = empresaService.listarEmpresas();
            return ResponseEntity.status(HttpStatus.OK).body(empresaListagem);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<?> buscaPorId(@PathVariable Long id){
        // EmpresaService empresaService = new EmpresaService();
        EmpresaListagemDto empresa = empresaService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(empresa);
    }




}
