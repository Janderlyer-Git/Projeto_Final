
package model.bean;



public abstract class Pessoa {
    
    /*Atributos da classe mãe Pessoa*/
    
    private int id; 
    private String nome; 
    private String cpf;
    
    /*Construtor*/

    public Pessoa(int id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }
    
    /*Construtor Vazio*/
    
    public Pessoa() {
        
    }
    
    /*Metódo abstrato para exibir*/
    
    abstract void exibirInfo();
            
    
    /*Getters and Setters */
    
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
}

