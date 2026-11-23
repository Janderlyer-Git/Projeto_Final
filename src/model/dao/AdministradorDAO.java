package model.dao;

import model.bean.Administrador;
import conection.Conexao;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
        
public class AdministradorDAO {
    Connection conexao;

    public AdministradorDAO(){
        conexao = Conexao.getConexao();        
    }
    
           
    //inserir os dados de uma pessoa no mysql
    public void inserir(Administrador a){
      try{   
        String sql = "insert into Administrador (id, nome, cpf, login, senha) values ( ?, ?, ?, ?, ?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        
        ps.setInt(1, a.getId());
        ps.setString(2, a.getNome());
        ps.setString(3, a.getCpf());
        ps.setString(4, a.getLogin());
        ps.setString(5, a.getSenha());
         
        ps.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Cadastro de Administrador realizado");
      }catch(Exception e){
          System.out.println("Erro na insercao: "+e);
      }
    }
    
        
   public ArrayList<Administrador> consultarTodos(){
        ArrayList<Administrador> administrador = new ArrayList<Administrador>();
        
        try{
            String sql = "select * from administrador"; 
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
    
}