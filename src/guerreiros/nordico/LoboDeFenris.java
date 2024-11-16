/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerreiros.nordico;

import guerreiros.Guerreiro;
import java.util.Iterator;
import trabalhopoo.Arena;

/**
 *
 * @author Gilsepi
 */
public class LoboDeFenris extends Nordico{

    
    public LoboDeFenris(int energia, int peso, int idade, String nome, int danoDeAtaque) {
        super(energia, peso, idade, nome, danoDeAtaque);
 
    }
    
    @Override
    public int[] atacar(Arena arena,int filaAtacando,int fila,boolean primeiroLadoAtacando){
        int atacados[] = new int[arena.getLado2().getFilas().size()];
        int lobosNaFila = 0;
        Guerreiro guerreiroAtacado = arena.getLado2().getFilas().get(fila-1).getLista().getFirst();
        Iterator  it = arena.getLado1().getFilas().get(filaAtacando-1).getLista().iterator();
        it.next();
        while(it.hasNext()){
            Guerreiro g = (Guerreiro)it.next();
            if(g.getClass().getSimpleName().equals("LoboDeFenris")){
                lobosNaFila++;
            }else{
                break;
            }
                
        }

        guerreiroAtacado.sofrerDano(this.getDanoDeAtaque()+(lobosNaFila * 8));
        atacados[0] = fila;
        
        
        this.verificarVeneno();
        
        return atacados;
    }
}
