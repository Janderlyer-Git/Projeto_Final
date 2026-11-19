package votacao;

public class Candidato extends Pessoa {

    private String numero;
    private Partido partido;
    private Cargo cargo;

    /* Construtor completo */
    public Candidato(int id, String nome, String cpf, String numero, Partido partido, Cargo cargo) {
        super(id, nome, cpf);
        this.numero = numero;
        this.partido = partido;
        this.cargo = cargo;
    }

    /* Construtor vazio */
    public Candidato() {
        super();
    }

    /* Exibir da classe mãe (Abstrato de Pessoa) */
    public void exibirInfo() {
        String siglaPartido = (partido != null) ? partido.getSigla() : "Sem partido";
        String nomeCargo = (cargo != null) ? cargo.getNome() : "Sem cargo";

        System.out.printf("Candidato [ID: %d | Nome: %s | CPF: %s | Número: %s | Partido: %s | Cargo: %s]%n",
                getId(), getNome(), getCpf(), numero, siglaPartido, nomeCargo);
    }

    /* Getters e Setters */
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}