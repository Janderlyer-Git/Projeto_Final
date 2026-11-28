
package model.bean;


public class Partido {

    private int id;
    private String numeroPartido;
    private String sigla;
    private String nomePartido;

    /* Construtor completo */
    public Partido(int id, String numeroPartido, String sigla, String nomePartido) {
        this.id = id;
        this.numeroPartido = numeroPartido;
        this.sigla = sigla;
        this.nomePartido = nomePartido;
    }

    /* Construtor vazio */
    public Partido() {
    }

    /* Exibir informações */
public void exibirInfo(){
System.out.println("Informações: ");
System.out.println("ID: "+id);
System.out.println("Número do Partido: "+numeroPartido);
System.out.println("Sigla: "+sigla);
System.out.println("Nome: "+nomePartido);

}

    /* Getters e Setters */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroPartido() {
        return numeroPartido;
    }

    public void setNumeroPartido(String numeroPartido) {
        this.numeroPartido = numeroPartido;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNomePartido() {
        return nomePartido;
    }

    public void setNomePartido(String nome) {
        this.nomePartido = nome;
    }
}