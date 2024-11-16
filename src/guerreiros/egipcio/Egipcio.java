/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerreiros.egipcio;

import guerreiros.Guerreiro;
import trabalhopoo.Arena;

/**
 *
 * @author Gilsepi e Matheus Pereira
 */
public abstract class Egipcio extends Guerreiro {
    
    public Egipcio(int energia, int peso, int idade, String nome, int danoDeAtaque) {
        super(energia, peso, idade, nome, danoDeAtaque);
    }
    
    @Override
    public abstract int[] atacar(Arena arena,int filaAtacando,int fila,boolean primeiroLadoAtacando);
}
