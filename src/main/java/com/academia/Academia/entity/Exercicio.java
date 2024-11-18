package com.academia.Academia.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_exercicio;
    @Column
    private String descricao;
    @Column
    private int series;
    @Column
    private int repeticoes;

    @ManyToMany(mappedBy = "exercicios")
    private List<Treino> treinos;
}
