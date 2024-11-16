/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerreiros.atlante;

import guerreiros.Guerreiro;
import java.util.Iterator;
import java.util.LinkedList;
import trabalhopoo.Arena;

/**
 *
 * @author Gilsepi
 */
public class Prometeano extends Atlante {
    private int vidaQueNasceu;
    
    public Prometeano(int energia, int peso, int idade, String nome, int danoDeAtaque,int vidaQueNasceu) {
        super(energia, peso, idade, nome,danoDeAtaque);
        this.vidaQueNasceu = vidaQueNasceu;
    }

    public int getVidaQueNasceu() {
        return vidaQueNasceu;
    }
    
    @Override
    public void morrer(Arena arena,int fila){
        this.setEnergia(0);
        /*if(this.getVidaQueNasceu()>1){
            Guerreiro g = new Prometeano(((int)(this.getVidaQueNasceu()/2)),this.getPeso(),this.getIdade(), this.getNome().concat(String.valueOf(1)),this.getDanoDeAtaque(),((int)(this.getVidaQueNasceu()/2)));
            Guerreiro h = new Prometeano(((int)(this.getVidaQueNasceu()/2)),this.getPeso(),this.getIdade(), this.getNome().concat(String.valueOf(2)),this.getDanoDeAtaque(),((int)(this.getVidaQueNasceu()/2)));
            LinkedList<Guerreiro> lista = arena.getLado2().getFilas().get(fila-1).getLista();
            lista.addLast(g);
            lista.addLast(h);
        }*/
    }
    
    @Override
    public int[] atacar(Arena arena,int filaAtacando,int fila,boolean primeiroLadoAtacando){
        int atacados[] = new int[arena.getLado1().getFilas().size()];
        Guerreiro guerreiroAtacado = arena.getLado1().getFilas().get(fila-1).getLista().getFirst();
        guerreiroAtacado.sofrerDano(this.getDanoDeAtaque());
        atacados[0] = fila;
        
        this.verificarVeneno();
        
        
        
        return atacados;
    }
}
