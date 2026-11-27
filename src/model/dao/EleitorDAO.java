package model.dao;

import model.bean.Eleitor;
import conection.Conexao;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
        
public class EleitorDAO {
    private Connection conexao;

    public EleitorDAO(){
        this.conexao = new Conexao().getConexao();        
    }
    
           
    //inserir os dados de uma pessoa no mysql
    public void inserir(Eleitor el){
      try{   
        String sql = "insert into Eleitor (nome, cpf, tituloEleitoral, zona, secao, jaVotou) values ( ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        
        ps.setString(1, el.getNome());
        ps.setString(2, el.getCpf());
        ps.setString(3, el.getTituloEleitoral());
        ps.setString(4, el.getZona());
        ps.setString(5, el.getSecao());
        ps.setBoolean(6, el.isJaVotou());
         
        ps.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Cadastro de Eleitor realizado");
      }catch(Exception e){
          System.out.println("Erro na insercao: "+e);
      }
    }
    
        
   public ArrayList<Eleitor> consultarTodos(){
        ArrayList<Eleitor> eleitor = new ArrayList<Eleitor>();
        
        try{
            String sql = "select * from Eleitor"; 
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Eleitor el = new Eleitor(rs.getInt("id"), rs.getString("nome"),
                rs.getString("cpf"), rs.getString("tituloEleitoral"), rs.getString("zona"),
                rs.getString("secao"), rs.getBoolean("jaVotou"));
               
                eleitor.add(el);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro na consulta");
        }
        
        return eleitor;
    }
   
   
   
   public void atualizar(Eleitor el){
      try{   
        String sql = "UPDATE Eleitor SET nome = ?, cpf = ?, tituloEleitoral = ?, zona = ?, secao = ?, jaVotou = ? WHERE id = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        
        ps.setString(1, el.getNome());
        ps.setString(2, el.getCpf());
        ps.setString(3, el.getTituloEleitoral());
        ps.setString(4, el.getZona());
        ps.setString(5, el.getSecao());
        ps.setBoolean(6, el.isJaVotou());
        ps.setInt(7, el.getId());

         
        ps.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Atualizaçao de Eleitor realizado");
      }catch(Exception e){
          System.out.println("Erro ao Atualizar: "+e);
      }
    }
   
   public void delete(Eleitor el){
      try{   
        String sql = "DELETE FROM Eleitor WHERE id = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);

        ps.setInt(1, el.getId());

         
        ps.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Eleitor excluido com sucesso");
      }catch(Exception e){
          System.out.println("Erro ao excluir: "+e);
      }
    }
    
}