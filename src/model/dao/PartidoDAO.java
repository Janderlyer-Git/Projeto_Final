package model.dao;

import model.bean.Partido;
import conection.Conexao;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
        
public class PartidoDAO {
    private Connection conexao;

    public PartidoDAO(){
        this.conexao = new Conexao().getConexao();        
    }
    
           
    //inserir os dados de uma pessoa no mysql
    public void inserir(Partido p){
      try{   
        String sql = "insert into Partido (numeroPartido, sigla, nomePartido) values ( ?, ?, ?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        
        ps.setString(1, p.getNumeroPartido());
        ps.setString(2, p.getSigla());
        ps.setString(3, p.getNomePartido());

         
        ps.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Cadastro de Partido realizado");
      }catch(Exception e){
          System.out.println("Erro na insercao: "+e);
      }
    }
    
        
   public ArrayList<Partido> consultarTodos(){
        ArrayList<Partido> partido = new ArrayList<Partido>();
        
        try{
            String sql = "select * from Partido"; 
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Partido p = new Partido(rs.getInt("id"), rs.getString("numeroPartido"),
                rs.getString("sigla"), rs.getString("nomePartido"));
               
                partido.add(p);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro na consulta");
        }
        
        return partido;
    }
   
   
   
   public void atualizar(Partido p){
      try{   
        String sql = "UPDATE Partido SET numeroPartido = ?, sigla = ?, nomePartido = ? WHERE id = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        
        ps.setString(1, p.getNumeroPartido());
        ps.setString(2, p.getSigla());
        ps.setString(3, p.getNomePartido());
        ps.setInt(4, p.getId());

         
        ps.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Atualizaçao de Partido realizado");
      }catch(Exception e){
          System.out.println("Erro ao Atualizar: "+e);
      }
    }
   
   public void delete(Partido p){
      try{   
        String sql = "DELETE FROM Partido WHERE id = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);

        ps.setInt(1, p.getId());

         
        ps.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Partido excluido com sucesso");
      }catch(Exception e){
          System.out.println("Erro ao excluir: "+e);
      }
    }
   
   
   public Partido buscarPorSigla(String sigla) {
    Partido p = null;
    try {
        String sql = "SELECT * FROM Partido WHERE sigla = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, sigla);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            p = new Partido(
                rs.getInt("id"),
                rs.getString("numeroPartido"),
                rs.getString("sigla"),
                rs.getString("nomePartido")
            );
        }
    } catch (Exception e) {
        System.out.println("Erro ao buscar Partido por sigla: " + e);
    }
    return p;
}
    
}