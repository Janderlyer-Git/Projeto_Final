package votacao;

public class Eleitor extends Pessoa {

    private String tituloEleitoral;
    private String zona;
    private String secao;
    private boolean jaVotou;

    /* Construtor completo */
    public Eleitor(int id, String nome, String cpf, String tituloEleitoral, String zona, String secao, boolean jaVotou) {
        super(id, nome, cpf);
        this.tituloEleitoral = tituloEleitoral;
        this.zona = zona;
        this.secao = secao;
        this.jaVotou = jaVotou;
    }

    /* Construtor vazio*/
    public Eleitor() {
        super();
    }

    /* Saber se já votou e se está qapto para votar*/
    public boolean AptoParaVotar() {
        return !this.jaVotou;
    }

    /* Exibir da classe mãe (Abstrato de Pessoa*/
    public void exibirInfo() {
        String statusVoto = jaVotou ? "Sim" : "Não";
        System.out.printf("Eleitor [ID: %d | Nome: %s | CPF: %s | Título: %s | Zona: %s | Seção: %s | Já votou: %s]%n",
                getId(), getNome(), getCpf(), tituloEleitoral, zona, secao, statusVoto);
    }

    /* Getters e Setters */
    public String getTituloEleitoral() {
        return tituloEleitoral;
    }

    public void setTituloEleitoral(String tituloEleitoral) {
        this.tituloEleitoral = tituloEleitoral;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getSecao() {
        return secao;
    }

    public void setSecao(String secao) {
        this.secao = secao;
    }

    public boolean isJaVotou() {
        return jaVotou;
    }

    public void setJaVotou(boolean jaVotou) {
        this.jaVotou = jaVotou;
    }
}