package com.example.fage.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class HorarioDto {
    @NotNull
    private long id;

    @NotNull
    private Date data;

    @NotNull
    private boolean status;
}
