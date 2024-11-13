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
public abstract class Nordico extends Guerreiro {
    
    public Nordico(int energia, int peso, int idade, String nome) {
        super(energia, peso, idade, nome);
    }
    @Override
    public abstract void sofrerAtaque(Guerreiro g,int dano);
    @Override
    public abstract void atacar(Arena arena);
}
