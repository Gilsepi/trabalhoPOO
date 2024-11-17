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
public abstract class Grego extends Guerreiro {
    
    public Grego(int energia, int peso, int idade, String nome, int danoDeAtaque) {
        super(energia, peso, idade, nome, danoDeAtaque);
    }

    @Override
    public void receberCura(int cura){ // Gregos não podem ter mais de 100 de energia
        this.setEnergia(this.getEnergia() + cura);
        if(this.getEnergia()>100){
            this.setEnergia(100);
        }
    }

    @Override
    public abstract int[] atacar(Arena arena,int filaAtacando,int fila,boolean primeiroLadoAtacando);
        
    
}
