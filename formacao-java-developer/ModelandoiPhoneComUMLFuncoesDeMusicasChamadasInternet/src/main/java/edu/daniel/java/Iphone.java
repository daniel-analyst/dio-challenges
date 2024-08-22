package edu.daniel.java;

import edu.daniel.java.enums.StatusReprodutorMusical;
import edu.daniel.java.exceptions.AudioNaoSelecionadoException;
import edu.daniel.java.interfaces.AparelhoTelefonico;
import edu.daniel.java.interfaces.NavegadorInternet;
import edu.daniel.java.interfaces.ReprodutorMusical;

public class Iphone implements ReprodutorMusical, AparelhoTelefonico, NavegadorInternet {

    private boolean isAudioSelecionado;
    private StatusReprodutorMusical statusReprodutorMusical;
    private String audio;
    private String url;

    @Override
    public void selecionarMusica(String audio) {
        System.out.println("Áudio selecionado: " + audio);
        this.audio = audio;
        this.isAudioSelecionado = true;
    }

    @Override
    public void tocar() {
        try {
            if (!this.isAudioSelecionado) {
                throw new AudioNaoSelecionadoException();
            }
            System.out.println("Tocando áudio: " + this.audio);
            this.statusReprodutorMusical = StatusReprodutorMusical.TOCANDO;
        } catch (AudioNaoSelecionadoException audioNaoSelecionadoException) {
            System.out.println("Audio nao selecionado.");
        }
    }

    @Override
    public void pausar() {
        try {
            if (this.statusReprodutorMusical != StatusReprodutorMusical.TOCANDO) {
                throw new AudioNaoSelecionadoException();
            }
            System.out.println("Pausando áudio: " + this.audio);
        } catch (AudioNaoSelecionadoException audioNaoSelecionadoException) {
            System.out.println("Audio nao selecionado ou não está sendo reproduzido.");
        }
    }

    @Override
    public void ligar(String numero) {
        System.out.println("Ligando para o número: " + numero);
    }

    @Override
    public void atender() {
        System.out.println("Atendendo a ligação de fulano.");
    }

    @Override
    public void iniciarCorreioVoz() {
        System.out.println("Iniciando Correio Voz.");
    }

    @Override
    public void exibirPagina(String url) {
        System.out.println("Exibindo a página: " + url);
        this.url = url;
    }

    @Override
    public void adicionarNovaAba() {
        System.out.println("Adicionando uma nova aba ao navegador.");
    }

    @Override
    public void atualizarPagina() {
        System.out.println("Página atualizada.");
    }
}