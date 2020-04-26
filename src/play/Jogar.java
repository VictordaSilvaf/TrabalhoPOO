/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package play;

import combate.Combate;
import java.util.Random;
import model.bean.Player;
import java.util.Scanner;
import javax.swing.JOptionPane;
import model.dao.PlayerDAO;

/**
 *
 * @author Victor Not
 */
public class Jogar {

    private String modo;

    public void play() {
        Scanner in = new Scanner(System.in);

        PlayerDAO player = new PlayerDAO();
        Player player1 = new Player();      //instaciando o player1
        Player player2 = new Player();      //instanciando o player2
        Combate cbt = new Combate();        //instaciando o combate

        JOptionPane.showMessageDialog(null, "Bem vindos ao DarkGlory, um jogo onde você dependera da sua estrategia e da sua sorte para ganhar!");

        //loop do jogo
        while (!"sair".equals(modo)) {

            System.out.println();
            modo = JOptionPane.showInputDialog("Vai querer jogar 'Sozinho' ou contra um 'Amigo'? (Digite 'Sozinho', 'Amigo' ou 'Sair')");

            //Modo com "amigo"
            if (modo.equals("Amigo")) {
                JOptionPane.showMessageDialog(null, "Então vai querer batalhar contra seu 'Amigo'...");
                JOptionPane.showMessageDialog(null, "Não reclame depois que a amizade acabar!");

                //Gerar aleatoriamente a vez que cada jogador ira jogar {
                int quantidadeVezez = 2;
                int[] vez = new int[quantidadeVezez];
                Combate.definirVez(vez, quantidadeVezez); //funcao para criar o array que ordena a ordem de ataque (vez).

                int vez1 = vez[0];
                int vez2 = vez[1];
                // }

                //Definindo os players {
                player1.setVez(vez1);
                player1.setNome(JOptionPane.showInputDialog("Digite o nome do player 1:"));
                player.createPlayer(player1);

                player2.setVez(vez2);
                player2.setNome(JOptionPane.showInputDialog("Digite o nome do player 2:"));
                player.createPlayer(player2);
                //}
                
                cbt.iniciarCombate(player1.getNome(), player2.getNome());
                
                if (player1.getVez() > player2.getVez()) {
                    cbt.iniciarTurno(player1,player1,player2);
                }else if (player2.getVez() > player1.getVez()) {
                    cbt.iniciarTurno(player2,player1,player2);
                }else{
                    System.out.println("Erro Vez.");
                }
            }

        }
        System.out.println("Adeus.");
    }
}
