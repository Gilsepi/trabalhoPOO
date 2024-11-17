/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerreiros.atlante;

import guerreiros.Guerreiro;
import java.util.LinkedList;
import trabalhopoo.Arena;

/**
 *
 * @author Gilsepi e Matheus Pereira
 */
public class Satiro extends Atlante{
    
    public Satiro(int energia, int peso, int idade, String nome, int danoDeAtaque) {
        super(energia, peso, idade, nome, danoDeAtaque);
    }
    
    @Override
    public int[] atacar(Arena arena,int filaAtacando,int fila,boolean primeiroLadoAtacando){
        int atacados[] = new int[arena.getLado1().getFilas().size()];
        LinkedList<Guerreiro> lista = arena.getLado1().getFilas().get(fila-1).getLista(); // Localiza a fila de guerreiros atacados
        
        for(Guerreiro guerreiroAtacado : lista){ // Para cada guerreiro na lista, o Satiro profere um ataque
            guerreiroAtacado.sofrerDano(this.getDanoDeAtaque()); // Ataca
            
        }
        
  
        atacados[0] = fila;
        this.verificarVeneno();
        
        return atacados;
    }
}
