/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerreiros.nordico;

import guerreiros.Guerreiro;
import trabalhopoo.Arena;

/**
 *
 * @author Gilsepi e Matheus Pereira
 */
public class Valquiria extends Nordico{
    private final int valorCura;
    
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
        Guerreiro guerreiroAtacado = arena.getLado2().getFilas().get(fila-1).getLista().getFirst(); // Localiza o guerreiro a ser atacado
        guerreiroAtacado.sofrerDano(this.getDanoDeAtaque()); // Ataca
        atacados[0] = fila;
        
        if(arena.getLado1().getFilas().get(filaAtacando-1).getLista().size()>1){ // Veridica se tem guerreiro atrás dela
            Guerreiro guerreiroCurado = arena.getLado1().getFilas().get(filaAtacando-1).getLista().get(1); // Localiza o guerreiro aliado
            this.curar(guerreiroCurado); // Cura o guerreiro
        }
        
        this.verificarVeneno();
        
        return atacados;
    }
    
    
    private void curar(Guerreiro g){
        g.receberCura(getValorCura());
    }
}
