package com.academia.Academia.service;

import com.academia.Academia.entity.Aluno;
import com.academia.Academia.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {


    private final AlunoRepository alunoRepository;

    @Autowired
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> listar() {
        return alunoRepository.findAll();
    }

    public Aluno buscarPorMatricula(int id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("aluno nao encontrado"));
    }

    public Aluno salvar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public String remover(int id) {
        Aluno alunoParaRemover = buscarPorMatricula(id);
        alunoRepository.delete(alunoParaRemover);
        return "deletado";
    }

    public Aluno atualizar(Aluno aluno, int id) {
        Aluno alunoASerAtualizado = buscarPorMatricula(id);

        alunoASerAtualizado.setNome(aluno.getNome());
        alunoASerAtualizado.setData_de_nascimento(aluno.getData_de_nascimento());
        alunoASerAtualizado.setSexo(aluno.getSexo());
        alunoASerAtualizado.setObjetivo(aluno.getObjetivo());
        alunoASerAtualizado.setTelefone(aluno.getTelefone());
        alunoASerAtualizado.setEmail(aluno.getEmail());

        return alunoRepository.save(alunoASerAtualizado);

    }
}
