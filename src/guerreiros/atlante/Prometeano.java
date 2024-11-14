/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerreiros.atlante;

import guerreiros.Guerreiro;
import guerreiros.atlante.Atlante;
import trabalhopoo.Arena;

/**
 *
 * @author Gilsepi
 */
public class Prometeano extends Atlante {
    private int danoDeAtaque;
    
    public Prometeano(int energia, int peso, int idade, String nome, int danoDeAtaque) {
        super(energia, peso, idade, nome);
        this.danoDeAtaque = danoDeAtaque;
    }
    
    @Override
    public void sofrerAtaque(Guerreiro g,int dano){
        
    }
    @Override
    public void atacar(Arena arena,int lado,int fila){
        
    }
}
