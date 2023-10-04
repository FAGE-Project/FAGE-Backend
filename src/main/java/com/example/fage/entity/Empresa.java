package com.example.fage.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empresa {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String nome;

    @NotBlank
    private String documento;

    @NotBlank
    private String descricao;

    private String foto;

    @NotNull
    private int nota;

    @NotNull
    @Column(columnDefinition = "tinyint(1) default 1")
    private boolean aberta;

    @OneToMany(mappedBy = "empresa")
    private List<Funcionario> funcionarios;
}
