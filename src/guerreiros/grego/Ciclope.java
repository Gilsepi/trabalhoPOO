/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerreiros.grego;

import guerreiros.Guerreiro;
import java.util.LinkedList;
import trabalhopoo.Arena;

/**
 *
 * @author Gilsepi e Matheus Pereira
 */
public class Ciclope extends Grego {

    
    
    public Ciclope(int energia, int peso, int idade, String nome, int danoDeAtaque) {
        super(energia, peso, idade, nome, danoDeAtaque);

    }
    
 
    @Override
    public int[] atacar(Arena arena,int filaAtacando,int fila,boolean primeiroLadoAtacando){
        int atacados[] = new int[arena.getLado2().getFilas().size()];
        Guerreiro guerreiroAtacado = arena.getLado2().getFilas().get(fila-1).getLista().getFirst(); // Localiza o guerreiro a ser atacado
        guerreiroAtacado.sofrerDano(this.getDanoDeAtaque()); // Ataca
        atacados[0] = fila;
        
        if(primeiroLadoAtacando){ // Empurra o guerreiro atacado para o final da fila, se for o primeiro lado a atacar
            this.empurrarParaFinalFila(arena,fila);
        }
        
        this.verificarVeneno();
        
        
        return atacados;
    }
    
    private void empurrarParaFinalFila(Arena arena,int fila){
        LinkedList<Guerreiro> lista = arena.getLado2().getFilas().get(fila-1).getLista();
        Guerreiro aux = lista.removeFirst();
        lista.addLast(aux);  
                
    }
        
    

}
