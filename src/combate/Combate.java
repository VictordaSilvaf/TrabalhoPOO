/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combate;

import criacao.criarClasses;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import model.bean.Lutador;
import model.dao.LutadorDAO;

/**
 *
 * @author Victor Not
 */
public class Combate {

    public int turno = 1;
    public int round = 1;

    public static int[] definirVez(int[] vez, int quantidadeVezez) {
        Random random = new Random(); //definindo o objeto random
        boolean temnumero = false; //verificando se tem o numero
        for (int i = 0; i < vez.length; i++) { //percorrendo a tabela

            int valor = random.nextInt((vez.length+1));

            for (int j = 0; j < vez.length; j++) {

                if (vez[j] == valor) {

                    j = quantidadeVezez;

                    temnumero = true;
                }
            }

            if (!temnumero) {
                vez[i] = valor;
            } else {
                temnumero = false;
                i--;
            }
        }

        for (int i = 0; i < vez.length; i++) {
            System.out.println(vez[i]);
        }
        return vez;
    }

    public int iniciarCombate(String player1, String player2, int comecar) {
        
        int numBase = 0;
        int numBase2 = 4;
        criarClasses criarClasse = new criarClasses();
         
        /*//Criando as classes de cada player.
        int[] vez = new int[numeroLutadores];
        Combate.definirVez(vez, numeroLutadores); //funcao para criar o array que ordena a ordem de ataque (vez).*/
        
        //Arraylist aleatorizando a ordem dos lutadores (vezes)
        List<Integer> vezes = new ArrayList<Integer>(8);
        
        
        vezes.add(1);
        vezes.add(2);
        vezes.add(3);
        vezes.add(4);
        vezes.add(5);
        vezes.add(6);
        vezes.add(7);
        vezes.add(8);
        
        Collections.shuffle(vezes); // aleatorizando o arraylist

        criarClasse.CriarClasse(player1, numBase, vezes);
        criarClasse.CriarClasse(player2, numBase2, vezes);

        Random random = new Random();

        comecar = random.nextInt(2); //Define quem vai comecar se comecar igual a 0 player1 comeca se igual a 1 player2.
        return comecar;
    }

    public void mostrarClasses(String nomeP) {
        Scanner in = new Scanner(System.in);
        boolean nome = false;
        
        LutadorDAO ldao = new LutadorDAO();
        Lutador lutador = new Lutador();
        
        for (Lutador l: ldao.read()){
            
        }
        
        
        
        
        
        
        /*if (lutador.getDono().equals(nomeP)) {
        
        }*/
        
    }

    public void iniciarTurno() {

    }

    public void iniciarRound() {

    }

    public void passarTurno() {

    }

    public void passarRound() {

    }
}
