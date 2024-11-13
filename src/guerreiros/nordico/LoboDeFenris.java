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
public class LoboDeFenris extends Nordico{
    private int danoDeAtaque;
    
    public LoboDeFenris(int energia, int peso, int idade, String nome, int danoDeAtaque) {
        super(energia, peso, idade, nome);
        this.danoDeAtaque = danoDeAtaque;
    }
    @Override
    public void sofrerAtaque(Guerreiro g,int dano){
        
    }
    @Override
    public void atacar(Arena arena){
        
    }
}
