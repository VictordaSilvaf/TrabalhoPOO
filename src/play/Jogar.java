/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package play;

import combate.Combate;
import model.bean.Player;
import java.util.Scanner;
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

        System.out.println("Bem vindos ao DarkGlory, um jogo onde você dependera da sua estrategia e da sua sorte para ganhar!");

        //loop do jogo
        while (!"sair".equals(modo)) {

            System.out.println("Vai querer jogar 'sozinho' ou contra um 'amigo'? (Digite 'sozinho', 'amigo' ou 'sair')");
            modo = in.next();

            //Modo com "amigo"
            if (modo.equals("amigo")) {
                System.out.println("Então vai querer batalhar contra seu 'amigo'...");
                System.out.println("Não reclame depois que a amizade acabar!");

                
                //Gerar aleatoriamente a vez que cada jogador ira jogar {
                int quantidadeVezez = 2;
                int[] vez = new int[quantidadeVezez];
                Combate.definirVez(vez, quantidadeVezez); //funcao para criar o array que ordena a ordem de ataque (vez).
                
                int vez1 = vez[0];
                int vez2 = vez[1];
                // }
                
                //Definindo os players {
                System.out.println("Digite o nome do player 1:");
                player1.setNome(in.next());
                player1.setVez(vez1);
                player.createPlayer(player1);

                System.out.println("Digite o nome do player 2:");
                player2.setVez(vez2);
                player2.setNome(in.next());
                player.createPlayer(player2);
                //}

                int comecar = 2;        //O valor dois é somente para ser diferente dos valores que irao ser gerados aleatoriamente na função iniciar combate.

                cbt.iniciarCombate(player1.getNome(), player2.getNome(), comecar);

                if (comecar == 0) {

                }

            }

        }
        System.out.println("Adeus.");
    }
}
