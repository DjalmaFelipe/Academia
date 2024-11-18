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
public class Aluno extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matricula;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "aluno_treino",
            joinColumns = @JoinColumn(name = "matricula"),
            inverseJoinColumns = @JoinColumn(name = "id_treino")
    )
    private List<Treino> treinos;

}
