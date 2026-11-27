package model.dao;

import model.bean.Administrador;
import conection.Conexao;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
        
public class AdministradorDAO {
    private Connection conexao;

    public AdministradorDAO(){
        this.conexao = new Conexao().getConexao();        
    }
    
           
    //inserir os dados de uma pessoa no mysql
    public void inserir(Administrador a){
      try{   
        String sql = "insert into Administrador (nome, cpf, login, senha) values ( ?, ?, ?, ?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        
        ps.setString(1, a.getNome());
        ps.setString(2, a.getCpf());
        ps.setString(3, a.getLogin());
        ps.setString(4, a.getSenha());
         
        ps.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Cadastro de Administrador realizado");
      }catch(Exception e){
          System.out.println("Erro na insercao: "+e);
      }
    }
    
        
   public ArrayList<Administrador> consultarTodos(){
        ArrayList<Administrador> administrador = new ArrayList<Administrador>();
        
        try{
            String sql = "select * from Administrador"; 
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Administrador a = new Administrador(rs.getInt("id"), rs.getString("nome"),
                rs.getString("cpf"), rs.getString("login"), rs.getString("senha"));
               
                administrador.add(a);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro na consulta");
        }
        
        return administrador;
    }
   
   public void atualizar(Administrador a){
      try{   
        String sql = "UPDATE Administrador SET nome = ?, cpf = ?, login = ?, senha = ? WHERE id = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        
        ps.setString(1, a.getNome());
        ps.setString(2, a.getCpf());
        ps.setString(3, a.getLogin());
        ps.setString(4, a.getSenha());
        ps.setInt(5, a.getId());

         
        ps.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Atualizaçao de Administrador realizado");
      }catch(Exception e){
          System.out.println("Erro ao Atualizar: "+e);
      }
    }
   
   public void delete(Administrador a){
      try{   
        String sql = "DELETE FROM Administrador WHERE id = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);

        ps.setInt(1, a.getId());

         
        ps.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Administrador excluido com sucesso");
      }catch(Exception e){
          System.out.println("Erro ao excluir: "+e);
      }
    }
    
}