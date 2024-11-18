package com.academia.Academia.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Treino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_treino;
    @Enumerated(EnumType.STRING)
    private DiaDaSemana diaDaSemana;

    @ManyToMany(mappedBy = "treinos")
    private List<Aluno> alunos;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "treino_exercicios",
            joinColumns = @JoinColumn(name = "id_treino"),
            inverseJoinColumns = @JoinColumn(name = "id_exercicio")
    )
    private List<Exercicio> exercicios;

}
