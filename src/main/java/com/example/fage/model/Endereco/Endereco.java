package com.example.fage.model.Endereco;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
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