package model.dao;

import model.bean.*;
import conection.Conexao;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
        
public class CandidatoDAO {
    Connection conexao;

    public CandidatoDAO(){
        conexao = Conexao.getConexao();        
    }
    
           
    //inserir os dados de uma pessoa no mysql
    public void inserir(Candidato c){
      try{   
        String sql = "insert into Candidato (id, nome, cpf, numero, foto, votos, idPartido, numeroPartido, sigla, nomePartido, idCargo, nomeCargo, quantidadeDigitos, descricao) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        
        ps.setInt(1, c.getId());
        ps.setString(2, c.getNome());
        ps.setString(3, c.getCpf());
        ps.setInt(4, c.getNumero());
        ps.setBytes(5, c.getFoto());
        ps.setInt(6, c.getVotos());
        ps.setInt(7, c.getPartido().getId());
        ps.setString(8, c.getPartido().getNumeroPartido());
        ps.setString(9, c.getPartido().getSigla());
        ps.setString(10, c.getPartido().getNome());
        ps.setInt(11, c.getCargo().getId());
        ps.setString(12, c.getCargo().getNome());
        ps.setInt(13, c.getCargo().getQuantidadeDigitos());
        ps.setString(14, c.getCargo().getDescricao());
         
        ps.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Cadastro de Candidato realizado");
      }catch(Exception e){
          System.out.println("Erro na insercao: "+e);
      }
    }
    
        
   public ArrayList<Candidato> consultarTodos(){
        ArrayList<Candidato> candidato = new ArrayList<Candidato>();
        
        try{
            String sql = "select * from candidato"; 
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
    
}