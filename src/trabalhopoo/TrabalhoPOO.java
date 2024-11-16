package trabalhopoo;

import java.io.*;
import java.util.Scanner;
import guerreiros.*;
import guerreiros.grego.*;
import guerreiros.nordico.*;
import guerreiros.egipcio.*;
import guerreiros.atlante.*;


public class TrabalhoPOO {

    public static void main(String[] args) {
       Gerenciador.instanciarArena();
       Gerenciador.lerArquivo();
       System.out.println("Teste de coordenadas: " + Gerenciador.getGuerreiro(1,1,0).getNome());
       Gerenciador.printMaisVelho();
       Gerenciador.printPesoDosLados();
       Guerreiro g = Gerenciador.getGuerreiro(1,1,0);
       System.out.println(g.getEnergia());
       g.sofrerDano(60);
       System.out.println(g.getEnergia());
       int valor = Gerenciador.localizarAtaque(Gerenciador.getLado(2),2,1);
       System.out.println(valor);
       Gerenciador.listarFilas();
       for(int i= 0;i<5;i++){
           System.out.println(Gerenciador.randomizarTurno());
       }
       if(!Gerenciador.verificarVitoria()){
         System.out.println("Nao ha vitoria");
       }else{
           System.out.println("Vitoria");
       }
       
       Gerenciador.iniciarTurnos();
       Gerenciador.printUltimoMorto();
      
    }
    
}
    

// criar as filas para elas apontarem para os guerreiros
    
 