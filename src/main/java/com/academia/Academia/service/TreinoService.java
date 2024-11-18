package com.academia.Academia.service;

import com.academia.Academia.entity.Treino;
import com.academia.Academia.repository.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreinoService {

    private final TreinoRepository treinoRepository;

    @Autowired
    public TreinoService(TreinoRepository treinoRepository) {
        this.treinoRepository = treinoRepository;
    }

    public Treino criarTreino(Treino treino) {
        return treinoRepository.save(treino);
    }

    public List<Treino> listarTreinos() {
        return treinoRepository.findAll();
    }

    public Treino buscarTreinoPorId(int id) {
        return treinoRepository.findById(id).orElseThrow(() -> new RuntimeException("Treino não encontrado"));
    }

    public Treino atualizarTreino(int id, Treino treino) {
        Treino sendoAtualizado = buscarTreinoPorId(id);
        sendoAtualizado.setDiaDaSemana(treino.getDiaDaSemana());
        sendoAtualizado.setExercicios(treino.getExercicios());
        return sendoAtualizado;
    }

    public String excluirTreino(int id) {
        treinoRepository.deleteById(id);
        return "Treino Excluído com sucesso";
    }
}
