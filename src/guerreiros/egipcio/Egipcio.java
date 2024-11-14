/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerreiros.egipcio;

import guerreiros.Guerreiro;
import trabalhopoo.Arena;

/**
 *
 * @author Gilsepi
 */
public abstract class Egipcio extends Guerreiro {
    
    public Egipcio(int energia, int peso, int idade, String nome) {
        super(energia, peso, idade, nome);
    }
    @Override
    public abstract void sofrerAtaque(Guerreiro g,int dano);
    @Override
    public abstract void atacar(Arena arena,int lado,int fila);
}
