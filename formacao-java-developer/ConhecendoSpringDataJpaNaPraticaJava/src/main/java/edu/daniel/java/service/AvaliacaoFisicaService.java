package edu.daniel.java.service;

import edu.daniel.java.dto.AvaliacaoFisicaDTO;
import edu.daniel.java.dto.AvaliacaoFisicaUpdateDTO;
import edu.daniel.java.entity.Aluno;
import edu.daniel.java.entity.AvaliacaoFisica;
import edu.daniel.java.interfaces.IAvaliacaoFisicaService;
import edu.daniel.java.repository.AlunoRepository;
import edu.daniel.java.repository.AvaliacaoFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoFisicaService implements IAvaliacaoFisicaService {

  @Autowired
  private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

  @Autowired
  private AlunoRepository alunoRepository;

  @Override
  public AvaliacaoFisica create(AvaliacaoFisicaDTO form) {
    AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
    Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

    avaliacaoFisica.setAluno(aluno);
    avaliacaoFisica.setPeso(form.getPeso());
    avaliacaoFisica.setAltura(form.getAltura());

    return avaliacaoFisicaRepository.save(avaliacaoFisica);
  }

  @Override
  public AvaliacaoFisica get(Long id) {
    return null;
  }

  @Override
  public List<AvaliacaoFisica> getAll() {

    return avaliacaoFisicaRepository.findAll();
  }

  @Override
  public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateDTO formUpdate) {
    return null;
  }

  @Override
  public void delete(Long id) {

  }
}
