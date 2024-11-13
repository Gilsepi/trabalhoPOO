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
public class Ciclope extends Grego {
    private int danoDeAtaque;
    
    
    public Ciclope(int energia, int peso, int idade, String nome, int danoDeAtaque) {
        super(energia, peso, idade, nome);
        this.danoDeAtaque = danoDeAtaque;
    }
    
    
    @Override
    public void atacar(Arena arena){
        
    }
        
    
    
    @Override
    public void sofrerAtaque(Guerreiro g,int dano){
        g.setEnergia(g.getEnergia() - dano);
        if(g.getEnergia() < 0){
            g.setEnergia(0);
        }
    }
    
    
    
}
