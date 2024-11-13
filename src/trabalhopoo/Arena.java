/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo;

import guerreiros.Guerreiro;
import java.util.LinkedList;

/**
 *
 * @author Gilsepi
 */
public class Arena {
    private Lado lado1; 
    private Lado lado2;

    public Arena() {
        this.lado1 = new Lado();
        this.lado2 = new Lado();
    }

    public Lado getLado(int lado) {
        if(lado == 1){
            return lado1;
        }else{
            return lado2;
        }
        
    }
    
    public LinkedList<Fila> getFilas(int lado){
        return getLado(lado).getFilas();
    }
    
     public LinkedList<Guerreiro> getLista(int lado,int fila){
        return getFilas(lado).get(fila-1).getLista();
    }
    
    public Guerreiro getGuerreiro(int lado,int fila,int posicao){
        return getLista(lado,fila).get(posicao);
    }
    
    
    
    
    
}
