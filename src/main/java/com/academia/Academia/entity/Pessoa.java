package com.academia.Academia.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@MappedSuperclass
public class Pessoa {
    private String nome;
    private String data_de_nascimento;
    private String sexo;
    private String email;
    private String telefone;
    private String objetivo;
}
