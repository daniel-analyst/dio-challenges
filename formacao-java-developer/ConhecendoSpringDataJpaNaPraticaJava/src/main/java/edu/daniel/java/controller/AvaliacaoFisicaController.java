package edu.daniel.java.controller;

import edu.daniel.java.dto.AvaliacaoFisicaDTO;
import edu.daniel.java.entity.AvaliacaoFisica;
import edu.daniel.java.interfaces.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

  @Autowired
  private IAvaliacaoFisicaService service;

  @PostMapping
  public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaDTO form) {
    return service.create(form);
  }

  @GetMapping
  public List<AvaliacaoFisica> getAll(){
    return service.getAll();
  }

}
