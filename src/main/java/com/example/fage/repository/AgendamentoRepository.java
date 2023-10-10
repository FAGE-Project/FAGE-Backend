package com.example.fage.repository;

import com.example.fage.entity.Agendamento;
import com.example.fage.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

}
