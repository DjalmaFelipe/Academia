package com.academia.Academia.controller;

import com.academia.Academia.entity.Treino;
import com.academia.Academia.service.TreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/treino")
public class TreinoController {

    private final TreinoService treinoService;

    @Autowired
    public TreinoController(TreinoService treinoService) {
        this.treinoService = treinoService;
    }

    @PostMapping("/criarTreino")
    public ResponseEntity<Treino> criarTreino(@RequestBody Treino treino) {
        return new ResponseEntity<>(treinoService.criarTreino(treino), HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Treino>> listarTreino() {
        return new ResponseEntity<>(treinoService.listarTreinos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Treino> buscarTreino(@PathVariable int id) {
        return new ResponseEntity<>(treinoService.buscarTreinoPorId(id), HttpStatus.OK);
    }

    @PutMapping("/editarTreino/{id}")
    public ResponseEntity<Treino> editarTreino(@PathVariable int id, @RequestBody Treino treino) {
        return new ResponseEntity<>(treinoService.atualizarTreino(id, treino), HttpStatus.OK);
    }

    @DeleteMapping("/deletarTreino/{id}")
    public ResponseEntity<String> deletarTreino(@PathVariable int id) {
        return new ResponseEntity<>(treinoService.excluirTreino(id), HttpStatus.OK);
    }
}