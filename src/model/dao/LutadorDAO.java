package model.dao;

import db.FabricaConexao;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Lutador;
import java.sql.*;
import java.util.ArrayList;
import javax.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Victor Not
 */
public class LutadorDAO {

    public static void createLutador(Lutador lutador) {
        Connection con = FabricaConexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO lutadores (nome,dano,vida,dono,barreira,vez) VALUES (?,?,?,?,?,?)");
            stmt.setString(1, lutador.getNome());
            stmt.setInt(2, lutador.getDano());
            stmt.setInt(3, lutador.getVida());
            stmt.setString(4, lutador.getDono());
            stmt.setInt(5, lutador.getBarreira());
            stmt.setInt(6, lutador.getVez());

            stmt.executeUpdate();

            System.out.println("Criado Com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(LutadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            FabricaConexao.closeConnection(con, stmt);
        }

    }

    public List<Lutador> read() {
        Connection con = FabricaConexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Lutador> lutadores = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM (lutadores)");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Lutador lutador = new Lutador();
                
                lutador.setId(rs.getInt("id"));
                lutador.setNome(rs.getString("nome"));
                lutador.setDano(rs.getInt("dano"));
                lutador.setVida(rs.getInt("vida"));
                lutador.setVez(rs.getInt("vez"));
                lutador.setBarreira(rs.getInt("barreira"));
                lutador.setDono(rs.getString("dono"));
                
                lutadores.add(lutador);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(LutadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            FabricaConexao.closeConnection(con, stmt, rs);
        }
        return lutadores;
    }
    
    public List<Lutador> show(String nomeP, List lutadores) {
        Connection con = FabricaConexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("select * FROM (lutadores) where dono = '"+nomeP+"';");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Lutador lutador = new Lutador();
                
                lutador.setId(rs.getInt("id"));
                lutador.setNome(rs.getString("nome"));
                lutador.setDano(rs.getInt("dano"));
                lutador.setVida(rs.getInt("vida"));
                lutador.setVez(rs.getInt("vez"));
                lutador.setBarreira(rs.getInt("barreira"));
                lutador.setDono(rs.getString("dono"));
                
                lutadores.add(lutador);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(LutadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            FabricaConexao.closeConnection(con, stmt, rs);
        }
        return lutadores;
    }
}
