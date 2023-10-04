package com.example.fage.repository;

import com.example.fage.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository <Funcionario, Long> {
    List<Funcionario> findAllByEmpresa_Id(Long id);
}
