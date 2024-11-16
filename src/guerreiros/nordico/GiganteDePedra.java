/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerreiros.nordico;

import guerreiros.Guerreiro;
import guerreiros.nordico.Nordico;
import trabalhopoo.Arena;

/**
 *
 * @author Gilsepi
 */
public class GiganteDePedra extends Nordico{

    
    public GiganteDePedra(int energia, int peso, int idade, String nome, int danoDeAtaque) {
        super(energia, peso, idade, nome, danoDeAtaque);
    }
    
    @Override
    public int[] atacar(Arena arena,int filaAtacando,int fila,boolean primeiroLadoAtacando){
        int atacados[] = new int[arena.getLado2().getFilas().size()];
        Guerreiro guerreiroAtacado = arena.getLado2().getFilas().get(fila-1).getLista().getFirst();
        guerreiroAtacado.sofrerDano(this.getDanoDeAtaque());
        atacados[0] = fila;
        
        if(primeiroLadoAtacando == true){
            arena.getLado1().setFlagFilaDoGuerreiroAlvo(filaAtacando);
        }
        
        
        this.verificarVeneno();
        
        return atacados;
    }
}
