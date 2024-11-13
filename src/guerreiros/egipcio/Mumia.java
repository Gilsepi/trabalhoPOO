/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerreiros.egipcio;

import guerreiros.Guerreiro;
import guerreiros.egipcio.Egipcio;
import trabalhopoo.Arena;

/**
 *
 * @author Gilsepi
 */
public class Mumia extends Egipcio{
    private int danoDeAtaque;
    
    public Mumia(int energia, int peso, int idade, String nome, int danoDeAtaque) {
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
