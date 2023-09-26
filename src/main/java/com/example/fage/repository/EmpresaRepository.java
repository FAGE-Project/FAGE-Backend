package com.example.fage.repository;

import com.example.fage.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    List<Empresa> findByNomeContainingIgnoreCase(String nome);

    Optional<Empresa> findById(Long id);
    
}
