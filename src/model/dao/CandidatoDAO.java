package model.dao;

import model.bean.*;
import conection.Conexao;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
        
public class CandidatoDAO {
    private Connection conexao;

    public CandidatoDAO(){
        this.conexao = new Conexao().getConexao();        
    }
    
           
    //inserir os dados de uma pessoa no mysql
    public void inserir(Candidato c){
      try{   
        String sql = "insert into Candidato ( nome, cpf, numero, foto, idPartido, idCargo) values ( ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        

        ps.setString(1, c.getNome());
        ps.setString(2, c.getCpf());
        ps.setInt(3, c.getNumero());
        ps.setBytes(4, c.getFoto());
        ps.setInt(5, c.getPartido().getId());;
        ps.setInt(6, c.getCargo().getId());
         
        ps.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Cadastro de Candidato realizado");
      }catch(Exception e){
          System.out.println("Erro na insercao: "+e);
      }
    }
    
        
   public ArrayList<Candidato> consultarTodos(){
        ArrayList<Candidato> candidato = new ArrayList<Candidato>();
        
        try{
            String sql = "select * from Candidato"; 
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
        // 1. Monta o objeto Partido
        Partido partido = new Partido(
            rs.getInt("idPartido"),
            rs.getString("numeroPartido"),
            rs.getString("sigla"),
            rs.getString("nomePartido")
        );

        // 2. Monta o objeto Cargo
        Cargo cargo = new Cargo(
            rs.getInt("idCargo"),
            rs.getString("nomeCargo"),
            rs.getInt("quantidadeDigitos"),
            rs.getString("descricao")
        );

        // 3. Passa os objetos prontos para o Candidato
        Candidato c = new Candidato(
            rs.getInt("id"),
            rs.getString("nome"),
            rs.getString("cpf"),
            rs.getInt("numero"),
            partido, cargo, 
            rs.getBytes("foto"));

    candidato.add(c);
}
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro na consulta");
        }
        
        return candidato;
    }
   
   
   public void atualizar(Candidato c){
      try{   
        String sql = "UPDATE Candidato SET nome = ?, cpf = ?, numero = ?, foto = ?, idPartido = ?, idCargo = ? WHERE id = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        
        ps.setString(1, c.getNome());
        ps.setString(2, c.getCpf());
        ps.setInt(3, c.getNumero());
        ps.setBytes(4, c.getFoto());
        ps.setInt(5, c.getPartido().getId());;
        ps.setInt(6, c.getCargo().getId());
        ps.setInt(7, c.getId());

         
        ps.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Atualizaçao de Candidato realizado");
      }catch(Exception e){
          System.out.println("Erro ao Atualizar: "+e);
      }
    }
   
   public void delete(Candidato c){
      try{   
        String sql = "DELETE FROM Candidato WHERE id = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);

        ps.setInt(1, c.getId());

         
        ps.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Candidato excluido com sucesso");
      }catch(Exception e){
          System.out.println("Erro ao excluir: "+e);
      }
    }
    
}