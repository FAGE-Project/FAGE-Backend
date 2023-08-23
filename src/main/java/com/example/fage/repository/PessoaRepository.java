package com.example.fage.repository;

import com.example.fage.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    List<Pessoa> findByNomeContainingIgnoreCase(String nome);

    Optional<Pessoa> findByEmailContainingIgnoreCase(String email);

    Optional<Pessoa> findByDocumentoContainingIgnoreCase(String documento);

    Optional<Pessoa> findByEmailAndPassword(String email, String password);

    Optional<Pessoa> findByDocumentoAndPassword(String documento, String password);

    Optional<Pessoa> findByDocumento(String documento);
}
