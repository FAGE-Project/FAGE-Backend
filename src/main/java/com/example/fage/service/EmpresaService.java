package com.example.fage.service;

import com.example.fage.dto.EmpresaDto;
import com.example.fage.entity.Empresa;
import com.example.fage.repository.EmpresaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository empresaRepository;

    public void cadastrar(EmpresaDto empresaDto) {
        Empresa empresa = new Empresa();
        BeanUtils.copyProperties(empresaDto, empresa);
        empresaRepository.save(empresa);
    }



    public List<Empresa> listarTodos() {
        return empresaRepository.findAll();
    }

    public EmpresaDto buscarPorId(Long id) {

        try {
            Optional<Empresa> empresaOptional = empresaRepository.findById(id);

            if (empresaOptional.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma Estado foi encontrada");
            }
            EmpresaDto empresaDto = new EmpresaDto();
            BeanUtils.copyProperties(empresaOptional.get(), empresaDto);

            return empresaDto;

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
}
