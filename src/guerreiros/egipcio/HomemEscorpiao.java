/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerreiros.egipcio;

import guerreiros.Guerreiro;
import trabalhopoo.Arena;

/**
 *
 * @author Gilsepi e Matheus Pereira
 */
public class HomemEscorpiao extends Egipcio {
    
    public HomemEscorpiao(int energia, int peso, int idade, String nome, int danoDeAtaque) {
        super(energia, peso, idade, nome, danoDeAtaque);
    
    }
    
    @Override
    public int[] atacar(Arena arena,int filaAtacando,int fila,boolean primeiroLadoAtacando){
        int atacados[] = new int[arena.getLado1().getFilas().size()];
        Guerreiro guerreiroAtacado = arena.getLado1().getFilas().get(fila-1).getLista().getFirst(); // Localiza o guerreiro a ser atacado
        guerreiroAtacado.sofrerDano(this.getDanoDeAtaque()); // Ataca
        guerreiroAtacado.setEnvenenado(5); // Envenena o guerreiro
        atacados[0] = fila;
        
        
        
       
        this.verificarVeneno();
     
        return atacados;
    }
}
