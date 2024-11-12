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
       System.out.println("\n\n\n\n");
       System.out.println( arena.getLado(1).getFila().get(0).getLista().get(0).getNome());
       
 }
    
}
    

// criar as filas para elas apontarem para os guerreiros
    
 