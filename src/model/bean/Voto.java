package model.bean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Voto {

    private int id;
    private Cargo cargo;
    private Candidato candidato;
    private String tipoVoto; // "VALIDO", "BRANCO" ou "NULO"
    private LocalDateTime dataHora;

    /* Construtor completo */
    public Voto(int id, Cargo cargo, Candidato candidato, String tipoVoto, LocalDateTime dataHora) {
        this.id = id;
        this.cargo = cargo;
        this.candidato = candidato;
        this.tipoVoto = tipoVoto;
        this.dataHora = dataHora;
    }

    /* Construtor vazio */
    public Voto() {
    }

    /* Exibir informações do voto */
    public void exibirInfo() {
        String nomeCargo = (cargo != null) ? cargo.getNome() : "Sem cargo";
        String nomeCandidato = (candidato != null) ? candidato.getNome() : "Nenhum";
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = (dataHora != null) ? dataHora.format(formato) : "Sem data";

        System.out.printf("Voto [ID: %d | Cargo: %s | Tipo: %s | Candidato: %s | Data/Hora: %s]%n",
                id, nomeCargo, tipoVoto, nomeCandidato, dataFormatada);
    }

    /* Getters e Setters */
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Cargo getCargo() { return cargo; }
    public void setCargo(Cargo cargo) { this.cargo = cargo; }

    public Candidato getCandidato() { return candidato; }
    public void setCandidato(Candidato candidato) { this.candidato = candidato; }

    public String getTipoVoto() { return tipoVoto; }
    public void setTipoVoto(String tipoVoto) { this.tipoVoto = tipoVoto; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
}