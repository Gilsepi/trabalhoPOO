/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo;

import guerreiros.Guerreiro;
import java.util.Iterator;
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
    
    public boolean verificarMorteGuerreiro(Guerreiro g){
        if(g.getEnergia()==0){
            return true;
        } else{
            return false;
        }
         
    }
    
    public boolean verificarVitoria(){
       LinkedList<Fila> lado = getFilas(1);
       boolean temGuerreiro = false;
       int fila;
       for(fila = 1;fila<=lado.size();fila++){
           LinkedList<Guerreiro> lista = getLista(1,fila);
           if (!lista.isEmpty()){
               temGuerreiro = true;
               break;
           }
          
       }
       
       lado = getFilas(2);
       for(fila = 1;fila<=lado.size();fila++){
           LinkedList<Guerreiro> lista = getLista(2,fila);
           if (!lista.isEmpty() && temGuerreiro == true){
               return false;
           }
       }
       
    
        return true;
    }
    
    public void levarGuerreiroParaFinalDaFila(int lado,int fila){
        LinkedList<Guerreiro> lista = getLista(lado,fila);
        Guerreiro aux = lista.removeFirst();
        lista.addLast(aux);
    }
    
    
}
