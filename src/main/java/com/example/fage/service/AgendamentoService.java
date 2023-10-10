package com.example.fage.service;

import com.example.fage.Exceptions.InvalidCompanyNameException;
import com.example.fage.dto.AgendamentoDto;
import com.example.fage.dto.EmpresaDto;
import com.example.fage.dto.EmpresaListagemDto;
import com.example.fage.entity.*;
import com.example.fage.repository.AgendamentoRepository;
import com.example.fage.repository.EmpresaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class AgendamentoService {

    @Autowired
    AgendamentoRepository agendamentoRepository;

    public Agendamento cadastrar(AgendamentoDto agendamentoDto) throws Exception {
        Agendamento agendamento = new Agendamento();
        Pessoa pessoa = new Pessoa();
        Servico servico = new Servico();

        BeanUtils.copyProperties(agendamentoDto, agendamento);
        BeanUtils.copyProperties(agendamentoDto.getPessoa(), pessoa);
        BeanUtils.copyProperties(agendamentoDto.getServicoDto(), servico);
        agendamento.setPessoa(pessoa);
        agendamento.setServico(servico);
        agendamentoRepository.save(agendamento);

        return agendamento;
    }



    public List<Agendamento> listarTodos() {
        return agendamentoRepository.findAll();
    }

    public List<AgendamentoDto> listarAgendamentos(){
        List<Agendamento> agendamentoList = agendamentoRepository.findAll();

        List<AgendamentoDto> agendamentoDtoList = new ArrayList<>();

        for (Agendamento value : agendamentoList) {
            AgendamentoDto agendamentoDto = new AgendamentoDto();
            BeanUtils.copyProperties(value, agendamentoDto);
            agendamentoDtoList.add(agendamentoDto);
        }

        return agendamentoDtoList;
    }

    public AgendamentoDto buscarPorId(Long id) {
        try {
            Optional<Agendamento> agendamento = agendamentoRepository.findById(id);
            if (agendamento.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum agendamento foi encontrado");
            }

            AgendamentoDto agendamentoDto = new AgendamentoDto();

            BeanUtils.copyProperties(agendamento.get(), agendamentoDto);
            return agendamentoDto;

        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getReason());
        }
    }

    public void atualizar(AgendamentoDto agendamentoDto) {
        try {
            Agendamento agendamento = new Agendamento();
            BeanUtils.copyProperties(agendamentoDto, agendamento);
            agendamentoRepository.save(agendamento);
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getReason());
        }
    }

    public void excluir(Long id) {
        Agendamento agendamento = new Agendamento();
        agendamento.setId(id);
        agendamentoRepository.delete(agendamento);
    }

}
