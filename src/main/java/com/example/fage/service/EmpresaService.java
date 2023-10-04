package com.example.fage.service;

import com.example.fage.Exceptions.CannotBeBlankException;
import com.example.fage.Exceptions.InvalidCompanyNameException;
import com.example.fage.dto.EmpresaDto;
import com.example.fage.dto.EmpresaListagemDto;
import com.example.fage.entity.Empresa;
import com.example.fage.repository.EmpresaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository empresaRepository;

    public Empresa cadastrar(EmpresaDto empresaDto) throws Exception {
        Empresa empresa = new Empresa();
        if(empresaDto.getNome().isEmpty())
            throw new InvalidCompanyNameException("Nome da empresa inválido");

        validarEmpresa(empresaDto);

        BeanUtils.copyProperties(empresaDto, empresa);
        empresaRepository.save(empresa);

        return empresa;
    }



    public List<Empresa> listarTodos() {
        return empresaRepository.findAll();
    }

    public List<EmpresaListagemDto> listarEmpresas(){
        List<Empresa> empresaOptional = empresaRepository.findAll();

        List<EmpresaListagemDto> empresasListadas = new ArrayList<>();

        for (Empresa value : empresaOptional) {
            EmpresaListagemDto empresa = new EmpresaListagemDto();
            BeanUtils.copyProperties(value, empresa);
            empresasListadas.add(empresa);
        }

        BeanUtils.copyProperties(empresaOptional, empresasListadas);

        return empresasListadas;
    }

    public EmpresaDto buscarPorId(Long id) {
        try {
            Optional<Empresa> empresaOptional = empresaRepository.findById(id);
            if (empresaOptional.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma Estado foi encontrada");
            }

            EmpresaDto empresa = new EmpresaDto();

            BeanUtils.copyProperties(empresaOptional.get(), empresa);
            return empresa;

        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getReason());
        }
    }

    public List<Empresa> buscarPorNome(String nome) {

        try {
            List<Empresa> listaEmpresa = empresaRepository.findByNomeContainingIgnoreCase(nome);

            if (listaEmpresa.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma Empresa foi encontrada");
            }

            return listaEmpresa;

        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getReason());
        }
    }

    public void atualizar(EmpresaDto empresaDto) {
        try {
            validarAtualizacaoEmpresa(empresaDto);
            Empresa empresa = new Empresa();
            BeanUtils.copyProperties(empresaDto, empresa);
            empresaRepository.save(empresa);
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getReason());
        }
    }

    public void excluir(Long id) {
        Empresa empresa = new Empresa();
        empresa.setId(id);
        empresaRepository.delete(empresa);
    }

    private void validarAtualizacaoEmpresa(EmpresaDto empresaDto) throws ResponseStatusException {
        try {

            if (empresaDto == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Informe uma empresa para atualizar");
            }
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getReason());
        }
    }

    private void validarEmpresa(EmpresaDto empresaDto) throws CannotBeBlankException {
        if(empresaDto == null )
            throw new CannotBeBlankException("O campo não pode ser Nulo ou estar em branco, insira um valor para cadastrar");
    }
}
