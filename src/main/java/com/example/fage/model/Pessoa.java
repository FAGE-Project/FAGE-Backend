package com.example.fage.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String documento;
    @Column(nullable = false)
    private String email;
    @Column
    private String senha;
    private Pessoa(String nome, String documento, String email) {
        this.nome = nome;
        this.documento = documento;
        this.email = email;
    }
}
