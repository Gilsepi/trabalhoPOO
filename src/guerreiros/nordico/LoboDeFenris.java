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
 * @author Gilsepi e Matheus Pereira
 */
public class LoboDeFenris extends Nordico{

    
    public LoboDeFenris(int energia, int peso, int idade, String nome, int danoDeAtaque) {
        super(energia, peso, idade, nome, danoDeAtaque);
 
    }
    
    @Override
    public int[] atacar(Arena arena,int filaAtacando,int fila,boolean primeiroLadoAtacando){
        int atacados[] = new int[arena.getLado2().getFilas().size()];
        int lobosNaFila = 0;
        Guerreiro guerreiroAtacado = arena.getLado2().getFilas().get(fila-1).getLista().getFirst(); // Localiza o guerreiro a ser atacado
        Iterator  it = arena.getLado1().getFilas().get(filaAtacando-1).getLista().iterator();
        it.next();
        while(it.hasNext()){ // Loop para verificar se há lobos atrás dele
            Guerreiro g = (Guerreiro)it.next();
            if(g.getClass().getSimpleName().equals("LoboDeFenris")){ ///Se for lobo acréscenta 1 na variável de lobosNaFila
                lobosNaFila++;
            }else{ // Se não for, para o loop, porque só queremos lobos sequênciais
                break;
            }
                
        }

        guerreiroAtacado.sofrerDano(this.getDanoDeAtaque()+(lobosNaFila * 8)); // Ataca com dano aumentado caso tenha LobosDeFenris atrás dele em sequência
        atacados[0] = fila;
        
        
        this.verificarVeneno();
        
        return atacados;
    }
}
