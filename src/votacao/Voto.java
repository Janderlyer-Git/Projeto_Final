package votacao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Voto {

    /*atributos*/
    private int id;
    private Candidato candidato;
    private String tipoVoto; // "VALIDO", "BRANCO" ou "NULO"
    private LocalDateTime dataHora;

    /* Construtor completo */
    public Voto(int id, Candidato candidato, String tipoVoto, LocalDateTime dataHora) {
        this.id = id;
        this.candidato = candidato;
        this.tipoVoto = tipoVoto;
        this.dataHora = dataHora;
    }

    /* Construtor vazio */
    public Voto() {
    }

    /* Exibir informações do voto */
    public void exibirInfo() {
        String nomeCandidato = (candidato != null) ? candidato.getNome() : "Nenhum";
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = (dataHora != null) ? dataHora.format(formato) : "Sem data";

        System.out.printf("Voto [ID: %d | Tipo: %s | Candidato: %s | Data/Hora: %s]%n",
                id, tipoVoto, nomeCandidato, dataFormatada);
    }

    /* Getters e Setters */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public String getTipoVoto() {
        return tipoVoto;
    }

    public void setTipoVoto(String tipoVoto) {
        this.tipoVoto = tipoVoto;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}