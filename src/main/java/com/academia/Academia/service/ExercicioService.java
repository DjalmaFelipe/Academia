package com.academia.Academia.service;

import com.academia.Academia.entity.Exercicio;
import com.academia.Academia.repository.ExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercicioService {

    private final ExercicioRepository exercicioRepository;

    @Autowired
    public ExercicioService(ExercicioRepository exercicioRepository) {
        this.exercicioRepository = exercicioRepository;
    }

    public Exercicio salvarExercicio(Exercicio exercicio) {
        return exercicioRepository.save(exercicio);
    }

    public Exercicio buscarExercicioPorId(int id) {
        return exercicioRepository.findById(id).orElseThrow(() -> new RuntimeException("Exercicio não Encontrado"));
    }

    public List<Exercicio> buscarExercicios() {
        return exercicioRepository.findAll();
    }

    public Exercicio atualizarExercicio(int id, Exercicio exercicio) {
        Exercicio exercicioAtual = buscarExercicioPorId(id);
        exercicioAtual.setDescricao(exercicio.getDescricao());
        exercicioAtual.setRepeticoes(exercicio.getRepeticoes());
        exercicioAtual.setSeries(exercicio.getSeries());
        return exercicioAtual;
    }

    public String excluirExercicio(int id) {
        Exercicio exercicio = buscarExercicioPorId(id);
        exercicioRepository.delete(exercicio);
        return "Exercicio removido com sucesso";
    }
}
