package com.example.fage.repository;

import com.example.fage.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    List<Empresa> findByNomeContainingIgnoreCase(String nome);

    
}