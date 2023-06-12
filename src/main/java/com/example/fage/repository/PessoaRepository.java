package com.example.fage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fage.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}