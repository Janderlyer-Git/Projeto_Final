package model.dao;

import votacao.Eleitor;
import conection.Conexao;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
        
public class EleitorDAO {
    Connection conexao;

    public EleitorDAO(){
        conexao = Conexao.getConexao();        
    }
    
           
    //inserir os dados de uma pessoa no mysql
    public void inserir(Eleitor el){
      try{   
        String sql = "insert into Eleitor (id, nome, cpf, tituloEleitoral, zona, secao, jaVotou) values ( ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        
        ps.setInt(1, el.getId());
        ps.setString(2, el.getNome());
        ps.setString(3, el.getCpf());
        ps.setString(4, el.getTituloEleitoral());
        ps.setString(5, el.getZona());
        ps.setString(6, el.getSecao());
        ps.setBoolean(7, el.isJaVotou());
         
        ps.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Cadastro de Administrador realizado");
      }catch(Exception e){
          System.out.println("Erro na insercao: "+e);
      }
    }
    
        
   public ArrayList<Eleitor> consultarTodos(){
        ArrayList<Eleitor> eleitor = new ArrayList<Eleitor>();
        
        try{
            String sql = "select * from administrador"; 
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
    
}