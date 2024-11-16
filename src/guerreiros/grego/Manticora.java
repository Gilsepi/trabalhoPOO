/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerreiros.grego;

import guerreiros.Guerreiro;
import trabalhopoo.Arena;
    
/**
 *
 * @author Gilsepi
 */
public class Manticora extends Grego{

    
    
    public Manticora(int energia, int peso, int idade, String nome, int danoDeAtaque) {
        super(energia, peso, idade, nome, danoDeAtaque);
    }
    
    @Override
    public int[] atacar(Arena arena,int filaAtacando,int fila,boolean primeiroLadoAtacando){
        int atacados[] = new int[arena.getLado2().getFilas().size()];
        
        // guerreiro atacado na fila principal
        Guerreiro guerreiroAtacado = arena.getLado2().getFilas().get(fila-1).getLista().getFirst();
        guerreiroAtacado.sofrerDano(this.getDanoDeAtaque());
        atacados[0] = fila;
        
        // guerreiro atacado na fila abaixo
        if(fila != 1){
            if(!arena.getLado2().getFilas().get(fila-2).getLista().isEmpty()){
                guerreiroAtacado = arena.getLado2().getFilas().get(fila-2).getLista().getFirst();
                guerreiroAtacado.sofrerDano(this.getDanoDeAtaque()/2);
                atacados[1] = fila-1;
            }
            
        }
        
        //guerreiro atacado na fila acima             
        if(fila != arena.getLado2().getFilas().size()){
            if(!arena.getLado2().getFilas().get(fila).getLista().isEmpty()){
                guerreiroAtacado = arena.getLado2().getFilas().get(fila).getLista().getFirst();
                guerreiroAtacado.sofrerDano(this.getDanoDeAtaque()/2);
                
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
