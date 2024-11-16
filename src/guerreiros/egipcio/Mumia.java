/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerreiros.egipcio;

import guerreiros.Guerreiro;
import trabalhopoo.Arena;

/**
 *
 * @author Gilsepi
 */
public class Mumia extends Egipcio{

    
    public Mumia(int energia, int peso, int idade, String nome, int danoDeAtaque) {
        super(energia, peso, idade, nome, danoDeAtaque);
  
    }
    
    @Override
    public int[] atacar(Arena arena,int filaAtacando,int fila,boolean primeiroLadoAtacando){
        int atacados[] = new int[arena.getLado1().getFilas().size()];
        Guerreiro guerreiroAtacado = arena.getLado1().getFilas().get(fila-1).getLista().getFirst();
        guerreiroAtacado.sofrerDano(this.getDanoDeAtaque());
        atacados[0] = fila;
        
        if(guerreiroAtacado.getEnergia()<=0){
           Guerreiro mortoVivo = new MortoVivo(100,guerreiroAtacado.getPeso(),guerreiroAtacado.getIdade(),guerreiroAtacado.getNome(),5);
           arena.getLado2().getFilas().get(filaAtacando-1).getLista().add(mortoVivo);
        }
        
        this.verificarVeneno();
        return atacados;
            
    }
}
