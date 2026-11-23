
package model.bean;

public class Administrador extends Pessoa {

    private String login;
    private String senha;

    /* Construtor completo */
    public Administrador(int id, String nome, String cpf, String login, String senha) {
        super(id, nome, cpf);
        this.login = login;
        this.senha = senha;
    }

    /* Construtor vazio */
    public Administrador() {
        super();
    }

    /*Exibir da classe filha (Herdaddo de pessoa) */
    public void exibirInfo() {
        System.out.printf("Administrador [ID: %d | Nome: %s | CPF: %s | Login: %s]%n",
                getId(), getNome(), getCpf(), this.login);
    }

    /* Getters e Setters */
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

