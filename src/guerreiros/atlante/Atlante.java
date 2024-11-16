
package guerreiros.atlante;

import guerreiros.Guerreiro;
import trabalhopoo.Arena;

/**
 *
 * @author Gilsepi e Matheus Pereira
 */
public abstract class Atlante extends Guerreiro {
    
    public Atlante(int energia, int peso, int idade, String nome, int danoDeAtaque) {
        super(energia, peso, idade, nome, danoDeAtaque);
    }
    
    @Override
    public abstract int[] atacar(Arena arena,int filaAtacando,int fila,boolean primeiroLadoAtacando);
    
}
