package com.academia.Academia.service;

import com.academia.Academia.entity.Aluno;
import com.academia.Academia.repository.AlunoRepository;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JasperReportService {

    private final AlunoRepository alunoRepository;

    @Autowired
    public JasperReportService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }


    public JasperPrint gerarReport() throws Exception {
        String caminhoDoArquivo = new ClassPathResource("relatorio.jasper").getFile().getPath();
        JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(caminhoDoArquivo);

        List<Aluno> alunos = alunoRepository.findAll();
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(alunos);

        Map<String, Object> parametros = new HashMap<>();

        return JasperFillManager.fillReport(jasperReport, parametros, dataSource);
    }
}
