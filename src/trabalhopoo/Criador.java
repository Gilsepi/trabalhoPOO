/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo;
import guerreiros.egipcio.*;
import guerreiros.atlante.*;
import guerreiros.nordico.*;
import guerreiros.grego.*;
import guerreiros.*;
/**
 *
 * @author Gilsepi
 */
public class Criador {
    
    public static Guerreiro criarGuerreiro(int tipo, int lado,String nome,int idade,int peso, int energia){
        Guerreiro guerreiro = null;
        if(lado == 1){
            switch(tipo){
                case 1 -> guerreiro = new Ciclope(energia,peso,idade,nome,35);
                case 2 -> guerreiro = new Manticora(energia,peso,idade,nome,30);
                case 3 -> guerreiro = new Hidra(energia,peso,idade,nome,50);
                case 4 -> guerreiro = new Valquiria(energia,peso,idade,nome,20);
                case 5 -> guerreiro = new LoboDeFenris(energia,peso,idade,nome,40);
                case 6 -> guerreiro = new GiganteDePedra(energia,peso,idade,nome,30);
            }
        }else{
            switch(tipo){
                case 1 -> guerreiro = new Prometeano(energia,peso,idade,nome,10);
                case 2 -> guerreiro = new Satiro(energia,peso,idade,nome,10);
                case 3 -> guerreiro = new Argus(60,peso,idade,nome);
                case 4 -> guerreiro = new Anubita(energia,peso,idade,nome,15);
                case 5 -> guerreiro = new HomemEscorpiao(energia,peso,idade,nome,20);
                case 6 -> guerreiro = new Mumia(energia,peso,idade,nome,50);
            }
        }
        return guerreiro;
        
    }
    
}
