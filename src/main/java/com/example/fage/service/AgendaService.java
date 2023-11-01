package com.example.fage.service;

import com.example.fage.dto.AgendaDto;
import com.example.fage.entity.Agenda;
import com.example.fage.entity.Pessoa;
import com.example.fage.entity.Servico;
import com.example.fage.repository.AgendaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AgendaService {

    @Autowired
    AgendaRepository agendaRepository;

    public Agenda cadastrar(AgendaDto agendaDto) throws Exception {
        Agenda agenda = new Agenda();
        Pessoa pessoa = new Pessoa();
        Servico servico = new Servico();

        BeanUtils.copyProperties(agendaDto, agenda);
      //  BeanUtils.copyProperties(agendaDto.getPessoa(), pessoa);
      //  BeanUtils.copyProperties(agendaDto.getServicoDto(), servico);
        agenda.setPessoa(pessoa);
        agendaRepository.save(agenda);

        return agenda;
    }



    public List<Agenda> listarTodos() {
        return agendaRepository.findAll();
    }

    public List<AgendaDto> listarAgendas(){
        List<Agenda> agendamentoList = agendaRepository.findAll();

        List<AgendaDto> agendaDtoList = new ArrayList<>();

        for (Agenda value : agendamentoList) {
            AgendaDto agendaDto = new AgendaDto();
            BeanUtils.copyProperties(value, agendaDto);
            agendaDtoList.add(agendaDto);
        }

        return agendaDtoList;
    }

    public AgendaDto buscarPorId(Long id) {
        try {
            Optional<Agenda> agenda = agendaRepository.findById(id);
            if (agenda.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma agenda foi encontrado");
            }

            AgendaDto agendaDto = new AgendaDto();

            BeanUtils.copyProperties(agenda.get(), agendaDto);
            return agendaDto;

        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getReason());
        }
    }

    public void atualizar(AgendaDto agendaDto) {
        try {
            Agenda agenda = new Agenda();
            BeanUtils.copyProperties(agendaDto, agenda);
            agendaRepository.save(agenda);
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getReason());
        }
    }

    public void excluir(Long id) {
        Agenda agenda = new Agenda();
        agenda.setId(id);
        agendaRepository.delete(agenda);
    }

}
