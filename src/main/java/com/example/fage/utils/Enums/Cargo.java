package com.example.fage.utils.Enums;

public enum Cargo {
    GERENTE(1, "Gerente"),
    FUNCIONARIO(2, "Funcionário");

    private final int id;
    private final String descricao;

    private Cargo(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
}