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
       Arena arena = new Arena();
       Gerenciador.lerArquivo(arena);
       System.out.println("Teste de coordenadas: " + arena.getGuerreiro(1,1,0).getNome());
       Gerenciador.printMaisVelho();
       Gerenciador.listarFilas(arena);
       Gerenciador.printPesoDosLados();
       Guerreiro g = arena.getGuerreiro(1,1,0);
       System.out.println(g.getEnergia());
       g.sofrerAtaque(g,60);
       System.out.println(g.getEnergia());
       arena.getLista(1,2).remove();

       Gerenciador.listarFilas(arena);
       for(int i= 0;i<5;i++){
           System.out.println(Gerenciador.randomizarTurno());
       }
       if(!arena.verificarVitoria()){
         System.out.println("Nao ha vitoria");
       }else{
           System.out.println("Vitoria");
       }
       
    }
    
}
    

// criar as filas para elas apontarem para os guerreiros
    
 