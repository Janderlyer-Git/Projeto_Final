package votacao;


public class Partido {
    
    private String sigla, nome, id, numeroPartido;

    
    // Construtor:
    
    public Partido(String id, String numeroPartido, String sigla, String nome) {
        this.id = id;
        this.numeroPartido = numeroPartido;
        this.sigla = sigla;
        this.nome = nome;
    }

    
    
    //Metodos:
    
    public void exibirInfo(){
        System.out.println("Informações: ");
        System.out.println("ID: "+id);
        System.out.println("Número do Partido: "+numeroPartido);
        System.out.println("Sigla: "+sigla);
        System.out.println("Nome: "+nome);
    }  
    
    // Getter's e Setter's:
    
    public String getId() {
        return id;
    }

    public String getNumeroPartido() {
        return numeroPartido;
    }

    public String getSigla() {
        return sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNumeroPartido(String numeroPartido) {
        this.numeroPartido = numeroPartido;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
