package model.dao;

import model.bean.Partido;
import conection.Conexao;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
        
public class PartidoDAO {
    Connection conexao;

    public PartidoDAO(){
        conexao = Conexao.getConexao();        
    }
    
           
    //inserir os dados de uma pessoa no mysql
    public void inserir(Partido p){
      try{   
        String sql = "insert into Partido (id, numeroPartido, sigla, nome) values ( ?, ?, ?, ?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        
        ps.setInt(1, p.getId());
        ps.setString(2, p.getNumeroPartido());
        ps.setString(3, p.getSigla());
        ps.setString(4, p.getNome());

         
        ps.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Cadastro de Administrador realizado");
      }catch(Exception e){
          System.out.println("Erro na insercao: "+e);
      }
    }
    
        
   public ArrayList<Partido> consultarTodos(){
        ArrayList<Partido> partido = new ArrayList<Partido>();
        
        try{
            String sql = "select * from administrador"; 
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Partido p = new Partido(rs.getInt("id"), rs.getString("numeroPartido"),
                rs.getString("sigla"), rs.getString("nome"));
               
                partido.add(p);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro na consulta");
        }
        
        return partido;
    }
    
}