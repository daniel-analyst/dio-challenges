package edu.daniel.java.controller;

import edu.daniel.java.dto.AlunoDTO;
import edu.daniel.java.entity.Aluno;
import edu.daniel.java.entity.AvaliacaoFisica;
import edu.daniel.java.interfaces.IAlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/alunos")
public class AlunoController {

  @Autowired
  private IAlunoService service;

  @PostMapping
  public Aluno create(@Valid @RequestBody AlunoDTO form) {
    return service.create(form);
  }

  @GetMapping("/avaliacoes/{id}")
  public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id) {
    return service.getAllAvaliacaoFisicaId(id);
  }

  @GetMapping
  public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false)
                                  String dataDeNacimento){
    return service.getAll(dataDeNacimento);
  }


}
