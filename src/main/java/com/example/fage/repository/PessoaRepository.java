package com.example.fage.repository;

import com.example.fage.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    List<Pessoa> findByNomeContainingIgnoreCase(String nome);

    List<Pessoa> findByEmailContainingIgnoreCase(String email);

    List<Pessoa> findByDocumentoContainingIgnoreCase(String documento);

    Optional<Pessoa> findByEmailAndSenha(String email, String senha);
}
