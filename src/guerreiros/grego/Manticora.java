/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerreiros.grego;

import guerreiros.Guerreiro;
import trabalhopoo.Arena;
    
/**
 *
 * @author Gilsepi e Matheus Pereira
 */
public class Manticora extends Grego{

    
    
    public Manticora(int energia, int peso, int idade, String nome, int danoDeAtaque) {
        super(energia, peso, idade, nome, danoDeAtaque);
    }
    
    @Override
    public int[] atacar(Arena arena,int filaAtacando,int fila,boolean primeiroLadoAtacando){
        int atacados[] = new int[arena.getLado2().getFilas().size()];
        
        // guerreiro atacado na fila principal
        Guerreiro guerreiroAtacado = arena.getLado2().getFilas().get(fila-1).getLista().getFirst(); // Localiza o guerreiro a ser atacado
        guerreiroAtacado.sofrerDano(this.getDanoDeAtaque()); // Ataca
        atacados[0] = fila;
        
        // guerreiro atacado na fila abaixo
        if(fila != 1){ // Verifica se existe fila abaixo
            if(!arena.getLado2().getFilas().get(fila-2).getLista().isEmpty()){ // Se fila não vazia, ataca
                guerreiroAtacado = arena.getLado2().getFilas().get(fila-2).getLista().getFirst(); // Localiza o guerreiro a ser atacado
                guerreiroAtacado.sofrerDano(this.getDanoDeAtaque()/2); // Ataca, metade de seu dano
                atacados[1] = fila-1;
            }
            
        }
        
        //guerreiro atacado na fila acima             
        if(fila != arena.getLado2().getFilas().size()){ // Verifica se existe fila acima
            if(!arena.getLado2().getFilas().get(fila).getLista().isEmpty()){ // Se fila não vazia, ataca
                guerreiroAtacado = arena.getLado2().getFilas().get(fila).getLista().getFirst(); // Localiza o guerreiro a ser atacado
                guerreiroAtacado.sofrerDano(this.getDanoDeAtaque()/2); // Ataca, metade de seu dano
                
                if(atacados[1]==0){ 
                    atacados[1] = fila+1;
                }else{
                    atacados[2] = fila+1;
                }
            }
        }
        
        this.verificarVeneno();
        
        return atacados;
    }
}
