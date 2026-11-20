package model.dao;

import votacao.Cargo;
import conection.Conexao;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
        
public class CargoDAO {
    Connection conexao;

    public CargoDAO(){
        conexao = Conexao.getConexao();        
    }
    
           
    //inserir os dados de uma pessoa no mysql
    public void inserir(Cargo c){
      try{   
        String sql = "insert into Cargo (id, nome, quantidadeDigitos, descricao) values ( ?, ?, ?, ?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        
        ps.setInt(1, c.getId());
        ps.setString(2, c.getNome());
        ps.setInt(3, c.getQuantidadeDigitos());
        ps.setString(4, c.getDescricao());

         
        ps.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Cadastro de Administrador realizado");
      }catch(Exception e){
          System.out.println("Erro na insercao: "+e);
      }
    }
    
        
   public ArrayList<Cargo> consultarTodos(){
        ArrayList<Cargo> cargo = new ArrayList<Cargo>();
        
        try{
            String sql = "select * from administrador"; 
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Cargo p = new Cargo(rs.getInt("id"), rs.getString("nome"),
                rs.getInt("quantidadeDigitos"), rs.getString("descricao"));
               
                cargo.add(p);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro na consulta");
        }
        
        return cargo;
    }
    
}