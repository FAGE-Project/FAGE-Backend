package com.example.fage.service;

import com.example.fage.dto.FuncionarioListagemDto;
import com.example.fage.entity.Empresa;
import com.example.fage.entity.Funcionario;
import com.example.fage.repository.EmpresaRepository;
import com.example.fage.repository.FuncionarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class FuncionarioService {
    
    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Autowired
    EmpresaRepository empresaRepository;

    public List<Funcionario> buscarTodosPorEmpresa(Long id) {

        List<Funcionario> funcionarios = funcionarioRepository.findAllByEmpresa_Id(id);

        if(funcionarios.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionarios não encontrados");


//        List<FuncionarioListagemDto> funcionariosDto = new ArrayList<>();
//
//        BeanUtils.copyProperties(funcionarios, funcionariosDto);

        return funcionarios;

    }

}
