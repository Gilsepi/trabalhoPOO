/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerreiros.nordico;

import guerreiros.Guerreiro;
import trabalhopoo.Arena;

/**
 *
 * @author Gilsepi
 */
public class Valquiria extends Nordico{
    private int valorCura;
    
    public Valquiria(int energia, int peso, int idade, String nome, int danoDeAtaque, int valorCura) {
        super(energia, peso, idade, nome, danoDeAtaque);
        this.valorCura = valorCura;

   }

    public int getValorCura() {
        return valorCura;
    }
    
    @Override
    public int[] atacar(Arena arena,int filaAtacando,int fila,boolean primeiroLadoAtacando){
        int atacados[] = new int[arena.getLado2().getFilas().size()];
        Guerreiro guerreiroAtacado = arena.getLado2().getFilas().get(fila-1).getLista().getFirst();
        guerreiroAtacado.sofrerDano(this.getDanoDeAtaque());
        atacados[0] = fila;
        
        if(arena.getLado1().getFilas().get(filaAtacando-1).getLista().size()>1){
            Guerreiro guerreiroCurado = arena.getLado1().getFilas().get(filaAtacando-1).getLista().get(1);
            this.curar(guerreiroCurado);
        }
        
        this.verificarVeneno();
        
        return atacados;
    }
    
    
    private void curar(Guerreiro g){
        g.receberCura(getValorCura());
    }
}
