/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerreiros.atlante;

import guerreiros.Guerreiro;
import guerreiros.atlante.Atlante;
import java.util.LinkedList;
import trabalhopoo.Arena;

/**
 *
 * @author Gilsepi
 */
public class Satiro extends Atlante{
    
    public Satiro(int energia, int peso, int idade, String nome, int danoDeAtaque) {
        super(energia, peso, idade, nome, danoDeAtaque);
    }
    
    @Override
    public int[] atacar(Arena arena,int filaAtacando,int fila,boolean primeiroLadoAtacando){
        int atacados[] = new int[arena.getLado1().getFilas().size()];
        LinkedList<Guerreiro> lista = arena.getLado1().getFilas().get(fila-1).getLista();
        
        for(Guerreiro guerreiroAtacado : lista){
            guerreiroAtacado.sofrerDano(this.getDanoDeAtaque());
            
        }
        
  
        atacados[0] = fila;
        this.verificarVeneno();
        
        return atacados;
    }
}
