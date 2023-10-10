package com.example.fage.repository;

import com.example.fage.entity.Empresa;
import com.example.fage.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

    List<Servico> findAllByEmpresa(Empresa empresa);

}
