/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Player;
import db.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor Not
 */
public class PlayerDAO {
    public void createPlayer(Player player) {
        Connection con = FabricaConexao.getConnection();
        PreparedStatement stmt = null;

        try {   
            stmt = con.prepareStatement("INSERT INTO player (nome,mana,wins,vez) VALUES (?,?,?,?)");
            stmt.setString(1, player.getNome());
            stmt.setInt(2, player.getMana());
            stmt.setInt(3, player.getWins());
            stmt.setInt(4, player.getVez());
            
            stmt.executeUpdate();
            
            System.out.println("Criado Com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(LutadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            FabricaConexao.closeConnection(con, stmt);
        }

    }
}
