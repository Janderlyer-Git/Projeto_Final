package model.dao;

import model.bean.Cargo;
import conection.Conexao;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
        
public class CargoDAO {
    private Connection conexao;

    public CargoDAO(){
        this.conexao = new Conexao().getConexao();        
    }
    
           
    //inserir os dados de uma pessoa no mysql
    public void inserir(Cargo c){
      try{   
        String sql = "insert into Cargo (nome, quantidadeDigitos, descricao) values ( ?, ?, ?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        
        ps.setString(1, c.getNome());
        ps.setInt(2, c.getQuantidadeDigitos());
        ps.setString(3, c.getDescricao());

         
        ps.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Cadastro de Cargo realizado");
      }catch(Exception e){
          System.out.println("Erro na insercao: "+e);
      }
    }
    
        
   public ArrayList<Cargo> consultarTodos(){
        ArrayList<Cargo> cargo = new ArrayList<Cargo>();
        
        try{
            String sql = "select * from Cargo"; 
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Cargo p = new Cargo(rs.getInt("id"),rs.getString("nome"),
                rs.getInt("quantidadeDigitos"), rs.getString("descricao"));
               
                cargo.add(p);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro na consulta");
        }
        
        return cargo;
    }
    
}