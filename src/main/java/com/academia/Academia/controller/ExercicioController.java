package com.academia.Academia.controller;

import com.academia.Academia.entity.Exercicio;
import com.academia.Academia.service.ExercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercicios")
public class ExercicioController {

    private final ExercicioService exercicioService;

    @Autowired
    public ExercicioController(ExercicioService exercicioService) {
        this.exercicioService = exercicioService;
    }

    @PostMapping("/criarExercicio")
    public ResponseEntity<Exercicio> criarExercicio(@RequestBody Exercicio exercicio) {
        return new ResponseEntity<>(exercicioService.salvarExercicio(exercicio), HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Exercicio>> listar() {
        return new ResponseEntity<>(exercicioService.buscarExercicios(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exercicio> buscarPorId(@PathVariable int id) {
        return new ResponseEntity<>(exercicioService.buscarExercicioPorId(id), HttpStatus.OK);
    }

    @PutMapping("/editarExercicio/{id}")
    public ResponseEntity<Exercicio> editarExercicio(@RequestBody Exercicio exercicio, @PathVariable int id) {
        return new ResponseEntity<>(exercicioService.atualizarExercicio(id, exercicio), HttpStatus.OK);
    }

    @DeleteMapping("/deletarExercicio/{id}")
    public ResponseEntity<String> deletarExercicio(@PathVariable int id) {
        return new ResponseEntity<>(exercicioService.excluirExercicio(id), HttpStatus.OK);
    }
}