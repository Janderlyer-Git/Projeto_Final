package model.bean;

public class Candidato extends Pessoa {

    private int numero;
    private Partido partido;
    private Cargo cargo;
    private byte[] foto;
    private int votos;

    /* Construtor completo */
    public Candidato(int id, String nome, String cpf, int numero, Partido partido, Cargo cargo, byte[] foto) {
        super(id, nome, cpf);
        this.numero = numero;
        this.partido = partido;
        this.cargo = cargo;
        this.foto = foto;
        this.votos = 0;
    }

    /* Construtor vazio (necessário para o DAO montar o objeto vindo do SELECT) */
    public Candidato() {
        super();
    }

    /* Exibir da classe mãe (Abstrato de Pessoa) */
    @Override
    public void exibirInfo() {
        String siglaPartido = (partido != null) ? partido.getSigla() : "Sem partido";
        String nomeCargo = (cargo != null) ? cargo.getNome() : "Sem cargo";

        System.out.printf("Candidato [ID: %d | Nome: %s | Número: %d | Partido: %s | Cargo: %s | Votos: %d]%n",
                getId(), getNome(), numero, siglaPartido, nomeCargo, votos);
    }

    /* Getters e Setters */
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public Partido getPartido() { return partido; }
    public void setPartido(Partido partido) { this.partido = partido; }

    public Cargo getCargo() { return cargo; }
    public void setCargo(Cargo cargo) { this.cargo = cargo; }

    public byte[] getFoto() { return foto; }
    public void setFoto(byte[] foto) { this.foto = foto; }

    public int getVotos() { return votos; }
    public void setVotos(int votos) { this.votos = votos; }
}