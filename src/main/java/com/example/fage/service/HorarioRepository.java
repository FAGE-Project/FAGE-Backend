package com.example.fage.service;

import com.example.fage.entity.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HorarioRepository extends JpaRepository<Horario, Long> {
    //List<Horario> findAllByServico_Id(Long id);
}
