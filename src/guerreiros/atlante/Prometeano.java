/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerreiros.atlante;

import guerreiros.Guerreiro;
import trabalhopoo.Arena;

/**
 *
 * @author Gilsepi e Matheus Pereira
 */
public class Prometeano extends Atlante {
    private final int vidaQueNasceu;
    
    public Prometeano(int energia, int peso, int idade, String nome, int danoDeAtaque,int vidaQueNasceu) {
        super(energia, peso, idade, nome,danoDeAtaque);
        this.vidaQueNasceu = vidaQueNasceu;
    }
    

    public int getVidaQueNasceu() {
        return vidaQueNasceu;
    }
    
    @Override
    public Guerreiro[] morrer(){
        Guerreiro vetor[] = new Guerreiro[2];
        this.setEnergia(0);
        if(this.getVidaQueNasceu()>1){ // Se o Prometeano morrer e a vida que ele nasceu for maior que 1 ele gera dois prometeanos novos
            int i;
            for(i = 0;i<2;i++){
               Guerreiro g = new Prometeano(((int)(this.getVidaQueNasceu()/2)),this.getPeso(),this.getIdade(), this.getNome().concat(String.valueOf(i+1)),this.getDanoDeAtaque(),((int)(this.getVidaQueNasceu()/2)));
               vetor[i] = g;
            }
        }
        return vetor;
    }
    
    @Override
    public int[] atacar(Arena arena,int filaAtacando,int fila,boolean primeiroLadoAtacando){
        int atacados[] = new int[arena.getLado1().getFilas().size()];
        Guerreiro guerreiroAtacado = arena.getLado1().getFilas().get(fila-1).getLista().getFirst(); // Localiza o guerreiro a ser atacado
        guerreiroAtacado.sofrerDano(this.getDanoDeAtaque()); // Ataca
        atacados[0] = fila;
        
        this.verificarVeneno();
        
        
        
        return atacados;
    }
}
