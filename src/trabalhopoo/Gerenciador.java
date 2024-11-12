/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo;

import guerreiros.Guerreiro;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Gilsepi
 */
public class Gerenciador {
    
    
    
    
    public static void lerArquivo(Arena arena) {
       int lado,fila,verificaLeitura,tipo,peso,idade;
       String arq, nome;
       FileInputStream file;
       Scanner scan;

       for(lado=1; lado <=2; lado++){
           fila = 1;
           verificaLeitura = 0;
           do{
               arq = "lado" + String.valueOf(lado) + String.valueOf(fila) + ".txt";
               
               try{
                   file = new FileInputStream(arq);
                   scan = new Scanner(file);
                   System.out.println(arq);
                   arena.getLado(lado).getFila().add(new Fila());
                   int index = 0;
                   while(scan.hasNext()){
                        tipo = scan.nextInt();
                        nome = scan.next();
                        idade = scan.nextInt();
                        peso = scan.nextInt();
                        arena.getLado(lado).getFila().get(fila-1).getLista().add(Criador.criarGuerreiro(tipo,lado,nome,peso,idade,100));
                        
                        
                        System.out.println( tipo + " " + arena.getLado(lado).getFila().get(fila-1).getLista().get(index).getNome() + " " + idade + " " + peso);
                        index++;
                   }
                   scan.close();
             
               }catch(FileNotFoundException erro){
                   verificaLeitura = 1;
               }
               fila++;
               
           }while(verificaLeitura != 1);
           
       }
       
 }
    
}
