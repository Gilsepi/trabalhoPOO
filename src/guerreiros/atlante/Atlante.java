
package guerreiros.atlante;

import guerreiros.Guerreiro;
import trabalhopoo.Arena;

/**
 *
 * @author Gilsepi
 */
public abstract class Atlante extends Guerreiro {
    
    public Atlante(int energia, int peso, int idade, String nome) {
        super(energia, peso, idade, nome);
    }
    
    @Override
    public abstract void atacar(Arena arena);
    @Override
    public abstract void sofrerAtaque(Guerreiro g,int dano);
}
