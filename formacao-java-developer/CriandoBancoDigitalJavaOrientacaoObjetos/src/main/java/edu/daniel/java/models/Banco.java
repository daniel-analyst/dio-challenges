package edu.daniel.java.models;

import edu.daniel.java.abstracts.Conta;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Banco {
    private String nome;
    private List<Conta> contas;
}
