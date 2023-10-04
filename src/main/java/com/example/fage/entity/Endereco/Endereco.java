package com.example.fage.entity.Endereco;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String rua;

    @Column(nullable = false)
    private String numero;

    @Column
    private String bairro;

    @Column
    private String complemento;

    @Column(nullable = false)
    private String CEP;

    @Column(nullable = false)
    private String pais;
}