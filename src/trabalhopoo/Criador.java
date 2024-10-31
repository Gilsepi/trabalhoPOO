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
    
    public static Guerreiro criarGuerreiro(int tipo, int lado){
        Guerreiro guerreiro = null;
        if(lado == 1){
            switch(tipo){
                case 1:
                    guerreiro = new Ciclope();
                    break;
                case 2:
                    guerreiro = new Manticora();
                    break;
                case 3:
                    guerreiro = new Hidra();
                    break;
                case 4:
                    guerreiro = new Valquiria();
                    break;
                case 5:
                    guerreiro = new LoboDeFenris();
                    break;
                case 6:
                    guerreiro = new GiganteDePedra();
                    break;
            }
        }else{
            switch(tipo){
                case 1:
                    guerreiro = new Prometeano();
                    break;
                case 2:
                    guerreiro = new Satiro();
                    break;
                case 3:
                    guerreiro = new Argus();
                    break;
                case 4:
                    guerreiro = new Anubita();
                    break;
                case 5:
                    guerreiro = new HomemEscorpiao();
                    break;
                case 6:
                    guerreiro = new Mumia();
                    break;
            }
        }
        return guerreiro;
        
    }
    
}
