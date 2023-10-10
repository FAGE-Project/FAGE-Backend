package com.example.fage.service;

import com.example.fage.dto.EmpresaDto;
import com.example.fage.dto.ServicoDto;
import com.example.fage.entity.Empresa;
import com.example.fage.entity.Servico;
import com.example.fage.repository.ServicoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class ServicoService {

    @Autowired
    ServicoRepository servicoRepository;

    public Servico cadastrar(ServicoDto servicoDto) throws Exception {
        Servico servico = new Servico();

        BeanUtils.copyProperties(servicoDto, servico);
        servicoRepository.save(servico);

        return servico;
    }



    public List<Servico> listarTodos() {
        return servicoRepository.findAll();
    }

    public List<ServicoDto> listarServicosPorEmpresa(Long empresaId){
        Empresa empresa = new Empresa();
        empresa.setId(empresaId);

        List<Servico> servicoList = servicoRepository.findAllByEmpresa(empresa);

        List<ServicoDto> servicoDtoList = new ArrayList<>();

        for (Servico value : servicoList) {
            ServicoDto servicoDto = new ServicoDto();
            EmpresaDto empresaDto = new EmpresaDto();
            BeanUtils.copyProperties(value, servicoDto);
            BeanUtils.copyProperties(value.getEmpresa(), empresaDto);
            servicoDto.setEmpresaDto(empresaDto);
            servicoDtoList.add(servicoDto);
        }

        return servicoDtoList;
    }

    public ServicoDto buscarPorId(Long id) {
        try {
            Optional<Servico> servicoOptional = servicoRepository.findById(id);
            if (servicoOptional.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma Estado foi encontrada");
            }

            ServicoDto servicoDto = new ServicoDto();

            BeanUtils.copyProperties(servicoOptional.get(), servicoDto);
            return servicoDto;

        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getReason());
        }
    }

    public void atualizar(ServicoDto servicoDto) {
        try {
            Servico servico = new Servico();
            BeanUtils.copyProperties(servicoDto, servico);
            servicoRepository.save(servico);
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getReason());
        }
    }

    public void excluir(Long id) {
        Servico servico = new Servico();
        servico.setId(id);
        servicoRepository.delete(servico);
    }

}
