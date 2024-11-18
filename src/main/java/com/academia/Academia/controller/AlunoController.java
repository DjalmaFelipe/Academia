package com.academia.Academia.controller;

import com.academia.Academia.entity.Aluno;
import com.academia.Academia.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoService alunoService;

    @Autowired
    public AlunoController (AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Aluno>> lista(){
        return new ResponseEntity<>(alunoService.listar(),HttpStatus.OK);
    }

    @GetMapping("matricula/{id}")
    public ResponseEntity<Aluno> buscarAluno(@PathVariable int id){
        return new ResponseEntity<>(alunoService.buscarPorMatricula(id),HttpStatus.OK);
    }

    @PostMapping("/cadastrarAluno")
    public ResponseEntity<Aluno> novoAluno(@RequestBody Aluno aluno){
        return new ResponseEntity<>(alunoService.salvar(aluno),HttpStatus.CREATED);
    }

    @PutMapping("/editarAluno/{id}")
    public ResponseEntity<Aluno> editarAluno(@RequestBody Aluno aluno , @PathVariable int id){
        return new ResponseEntity<>(alunoService.atualizar(aluno,id),HttpStatus.OK);
    }

    @DeleteMapping("/deletarAluno/{id}")
    public ResponseEntity<String> deletarAluno(@PathVariable int id){
        return new ResponseEntity<>(alunoService.remover(id), HttpStatus.OK);
    }
}
