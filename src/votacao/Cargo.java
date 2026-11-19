package votacao;

public class Cargo {

    private int id;
    private String nome;
    private int quantidadeDigitos;
    private String descricao;

    /* Construtor completo */
    public Cargo(int id, String nome, int quantidadeDigitos, String descricao) {
        this.id = id;
        this.nome = nome;
        this.quantidadeDigitos = quantidadeDigitos;
        this.descricao = descricao;
    }

    /* Construtor vazio */
    public Cargo() {
    }

    /* Exibir informações do cargo */
    public void exibirInfo() {
        System.out.printf("Cargo [ID: %d | Nome: %s | Dígitos: %d | Descrição: %s]%n",
                id, nome, quantidadeDigitos, descricao);
    }

    /* Getters e Setters */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeDigitos() {
        return quantidadeDigitos;
    }

    public void setQuantidadeDigitos(int quantidadeDigitos) {
        this.quantidadeDigitos = quantidadeDigitos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}