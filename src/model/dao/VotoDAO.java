package model.dao;

import model.bean.*;
import conection.Conexao;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
        
public class VotoDAO {
    private Connection conexao;

    public VotoDAO(){
        this.conexao = new Conexao().getConexao();        
    }
    
           
    //inserir os dados de um voto no mysql
    public void inserir(Voto v){
      try{   
        String sql = "insert into Voto (idCandidato, idPartido, idCargo, tipoVoto, dataHora) values ( ?, ?, ?, ?, ?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        
        ps.setInt(1, v.getCandidato().getId());
        ps.setInt(2, v.getCandidato().getPartido().getId());
        ps.setInt(3, v.getCandidato().getCargo().getId());
        ps.setString(4, v.getTipoVoto());
        ps.setTimestamp(5, Timestamp.valueOf(v.getDataHora()));
         
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
            rs.getInt("numeroCandidato"),
            partido, cargo, rs.getBytes("foto"));

        // 4. Passa os objetos prontos para o Voto
        Voto v = new Voto(
            rs.getInt("id"),
            cargo,
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