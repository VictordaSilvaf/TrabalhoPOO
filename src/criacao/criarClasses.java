/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criacao;

import combate.Combate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import model.bean.Lutador;
import model.dao.LutadorDAO;

/**
 *
 * @author Victor Not
 */
public class criarClasses {

    public void CriarClasse(String nome, int numBase, List<Integer> vezes) {
        
        Lutador Dragao = new Lutador();
        Lutador OrcMontanha = new Lutador();
        Lutador OrcAreia = new Lutador();
        Lutador Arqueiro = new Lutador();

        Random random = new Random();

        OrcMontanha.setNome("Orc da Montanha");
        OrcMontanha.setDono(nome);
        OrcMontanha.setDano(3 + random.nextInt(11));
        OrcMontanha.setVida(28 + random.nextInt(11));
        OrcMontanha.setBarreira(0);
        OrcMontanha.setVez(vezes.get(numBase++));

        OrcAreia.setNome("Orc da Areia");
        OrcAreia.setDono(nome);
        OrcAreia.setDano(6 + random.nextInt(11));
        OrcAreia.setVida(22 + random.nextInt(11));
        OrcAreia.setBarreira(0);
        OrcAreia.setVez(vezes.get(numBase++));

        Arqueiro.setNome("Arqueiro");
        Arqueiro.setDono(nome);
        Arqueiro.setDano(10 + random.nextInt(11));
        Arqueiro.setVida(12 + random.nextInt(11));
        Arqueiro.setBarreira(0);
        Arqueiro.setVez(vezes.get(numBase++));
        
        Dragao.setNome("Dragão");
        Dragao.setDono(nome);
        Dragao.setDano(7 + random.nextInt(11));
        Dragao.setVida(24 + random.nextInt(11));
        Dragao.setBarreira(0);
        Dragao.setVez(vezes.get(numBase++));
        
        LutadorDAO.createLutador(Dragao);
        LutadorDAO.createLutador(OrcMontanha);
        LutadorDAO.createLutador(OrcAreia);
        LutadorDAO.createLutador(Arqueiro);
        
    }
}
