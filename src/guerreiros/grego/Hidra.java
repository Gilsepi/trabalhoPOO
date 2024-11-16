/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerreiros.grego;

import guerreiros.Guerreiro;
import guerreiros.grego.Grego;
import trabalhopoo.Arena;

/**
 *
 * @author Gilsepi
 */
public class Hidra extends Grego{

    private int qtdCabecas;
    
    public Hidra(int energia, int peso, int idade, String nome, int danoDeAtaque, int qtdCabeca) {
        super(energia, peso, idade, nome, danoDeAtaque);
        this.qtdCabecas = qtdCabeca;
    }
    
    
    @Override
    public int[] atacar(Arena arena,int filaAtacando,int fila,boolean primeiroLadoAtacando){
        int atacados[] = new int[arena.getLado2().getFilas().size()];
        Guerreiro guerreiroAtacado = arena.getLado2().getFilas().get(fila-1).getLista().getFirst();
        guerreiroAtacado.sofrerDano(this.getDanoDeAtaque() + (5*this.getQtdCabecas()));
        atacados[0] = fila;
        
        if(guerreiroAtacado.getEnergia()<=0){
            this.setQtdCabecas(this.getQtdCabecas()+1);
            this.receberCura(20);
        }
        this.verificarVeneno();
        
        
        return atacados;
    }

    public void setQtdCabecas(int qtdCabecas) {
        this.qtdCabecas = qtdCabecas;
    }

    public int getQtdCabecas() {
        return qtdCabecas;
    }
}
