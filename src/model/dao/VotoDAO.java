package model.dao;

import votacao.*;
import conection.Conexao;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
        
public class VotoDAO {
    Connection conexao;

    public VotoDAO(){
        conexao = Conexao.getConexao();        
    }
    
           
    //inserir os dados de um voto no mysql
    public void inserir(Voto v){
      try{   
        String sql = "insert into Voto (id, idCandidato, nomeCandidato, cpfCandidato, numeroCandidato, idPartido, numeroPartido, sigla, nomePartido, idCargo, nomeCargo, quantidadeDigitos, descricao, tipoVoto, dataHora) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        
        ps.setInt(1, v.getId());
        ps.setInt(2, v.getCandidato().getId());
        ps.setString(3, v.getCandidato().getNome());
        ps.setString(4, v.getCandidato().getCpf());
        ps.setString(5, v.getCandidato().getNumero());
        ps.setInt(6, v.getCandidato().getPartido().getId());
        ps.setString(7, v.getCandidato().getPartido().getNumeroPartido());
        ps.setString(8, v.getCandidato().getPartido().getSigla());
        ps.setString(9, v.getCandidato().getPartido().getNome());
        ps.setInt(10, v.getCandidato().getCargo().getId());
        ps.setString(11, v.getCandidato().getCargo().getNome());
        ps.setInt(12, v.getCandidato().getCargo().getQuantidadeDigitos());
        ps.setString(13, v.getCandidato().getCargo().getDescricao());
        ps.setString(14, v.getTipoVoto());
        ps.setTimestamp(15, Timestamp.valueOf(v.getDataHora()));
         
        ps.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Cadastro de Voto realizado");
      }catch(Exception e){
          System.out.println("Erro na insercao: "+e);
      }
    }
    
        
   public ArrayList<Voto> consultarTodos(){
        ArrayList<Voto> voto = new ArrayList<Voto>();
        
        try{
            String sql = "select * from voto"; 
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

        // 3. Monta o objeto Candidato
        Candidato candidato = new Candidato(
            rs.getInt("idCandidato"),
            rs.getString("nomeCandidato"),
            rs.getString("cpfCandidato"),
            rs.getString("numeroCandidato"),
            partido, cargo);

        // 4. Passa os objetos prontos para o Voto
        Voto v = new Voto(
            rs.getInt("id"),
            candidato,
            rs.getString("tipoVoto"),
            rs.getTimestamp("dataHora").toLocalDateTime());

    voto.add(v);
}
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro na consulta");
        }
        
        return voto;
    }
    
}