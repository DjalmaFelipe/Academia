package com.academia.Academia.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Funcionario extends Pessoa{
    private int id;
    private String turno;
}
