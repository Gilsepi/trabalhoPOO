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
public class Mumia extends Egipcio{

    
    public Mumia(int energia, int peso, int idade, String nome, int danoDeAtaque) {
        super(energia, peso, idade, nome, danoDeAtaque);
  
    }
    
    
    @Override
    public Guerreiro[] morrer( ){
       Guerreiro vetor[] = new Guerreiro[4];
       this.setEnergia(0);
       int i;
       for(i=0;i<4;i++){
           Guerreiro g = new Anubita(100,60,0,this.getNome(),15);
           vetor[i] = g;
       }
       
       return vetor;
    }
    
    @Override
    public int[] atacar(Arena arena,int filaAtacando,int fila,boolean primeiroLadoAtacando){
        int atacados[] = new int[arena.getLado1().getFilas().size()];
        Guerreiro guerreiroAtacado = arena.getLado1().getFilas().get(fila-1).getLista().getFirst(); // Localiza o guerreiro a ser atacado
        guerreiroAtacado.sofrerDano(this.getDanoDeAtaque()); // Ataca
        atacados[0] = fila;
        
        if(guerreiroAtacado.getEnergia()<=0){ // Quando mata, cria um guerreiro MortoVivo em sua fila
           Guerreiro mortoVivo = new MortoVivo(100,guerreiroAtacado.getPeso(),guerreiroAtacado.getIdade(),guerreiroAtacado.getNome(),5);
           arena.getLado2().getFilas().get(filaAtacando-1).getLista().add(mortoVivo);
        }
        
        this.verificarVeneno();
        return atacados;
            
    }
}
