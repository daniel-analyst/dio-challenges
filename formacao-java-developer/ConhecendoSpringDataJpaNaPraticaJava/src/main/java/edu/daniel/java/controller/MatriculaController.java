package edu.daniel.java.controller;

import edu.daniel.java.dto.MatriculaDTO;
import edu.daniel.java.entity.Matricula;
import edu.daniel.java.interfaces.IMatriculaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

  @Autowired
  private IMatriculaService service;

  @PostMapping
  public Matricula create(@Valid @RequestBody MatriculaDTO form) {
    return service.create(form);
  }

  @GetMapping
  public List<Matricula> getAll(@RequestParam(value = "bairro", required = false) String bairro) {
    return service.getAll(bairro);
  }

}

