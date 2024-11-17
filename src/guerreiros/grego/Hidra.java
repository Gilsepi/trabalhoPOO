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
public class Hidra extends Grego{

    private int qtdCabecas;
    
    public Hidra(int energia, int peso, int idade, String nome, int danoDeAtaque, int qtdCabeca) {
        super(energia, peso, idade, nome, danoDeAtaque);
        this.qtdCabecas = qtdCabeca;
    }
    
    
    @Override
    public int[] atacar(Arena arena,int filaAtacando,int fila,boolean primeiroLadoAtacando){
        int atacados[] = new int[arena.getLado2().getFilas().size()];
        Guerreiro guerreiroAtacado = arena.getLado2().getFilas().get(fila-1).getLista().getFirst(); // Localiza o guerreiro a ser atacado
        guerreiroAtacado.sofrerDano(this.getDanoDeAtaque() + (5*this.getQtdCabecas())); // Ataca, dano aumentado por quantidade de cabeças
        atacados[0] = fila;
        
        if(guerreiroAtacado.getEnergia()<=0){ // Quando mata, gera uma nova cabeça na Hidra e cura 20 de energia
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
