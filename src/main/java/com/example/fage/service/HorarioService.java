package com.example.fage.service;

import com.example.fage.dto.HorarioDto;
import com.example.fage.entity.Horario;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class HorarioService {

    @Autowired
    HorarioRepository repository;

    public List<HorarioDto> buscarHorariosPorServico(Long id) {

        List<Horario> horarios = repository.findAllByServico_Id(id);

        if(horarios.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Horários não encontrados");

        List<HorarioDto> listaHorarioDtos = new ArrayList<>();

        for(Horario horario: horarios){
            HorarioDto horarioDto = new HorarioDto();
            BeanUtils.copyProperties(horario, horarioDto);
            listaHorarioDtos.add(horarioDto);
        }

        BeanUtils.copyProperties(horarios, listaHorarioDtos);

        return listaHorarioDtos;

    }
}
