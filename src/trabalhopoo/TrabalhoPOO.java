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
       int lado,fila,verificaLeitura;
       String arq;
       FileInputStream file;
       Scanner scan;
       int tipo,peso,idade;
       String nome;
       
       for(lado=1; lado <=2; lado++){
           fila = 1;
           verificaLeitura = 0;
           do{
               arq = "lado" + String.valueOf(lado) + String.valueOf(fila) + ".txt";
               System.out.println(arq);
               try{
                   file = new FileInputStream(arq);
                   scan = new Scanner(file);
                   while(scan.hasNext()){
                        tipo = scan.nextInt();
                        nome = scan.next();
                        idade = scan.nextInt();
                        peso = scan.nextInt();
                        Guerreiro g1 = Criador.criarGuerreiro(tipo,lado);
                        g1.setNome(nome);
                        g1.setIdade(idade);
                        g1.setPeso(peso);
                        g1.setEnergia(100);
                       
                        System.out.println( tipo + " " + nome + " " + idade + " " + peso);
                   }
               
             
               }catch(FileNotFoundException erro){
                   verificaLeitura = 1;
               }
               fila++;
               
           }while(verificaLeitura != 1);
           
       }
       
 }
    
}
    

// criar as filas para elas apontarem para os guerreiros
    
 