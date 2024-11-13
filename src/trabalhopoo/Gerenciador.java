/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo;

import guerreiros.Guerreiro;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Gilsepi
 */
public class Gerenciador {
    private static Guerreiro maisVelho;
    private static int maiorIdade = 0;
    private static int somaPesoGN = 0;
    private static int somaPesoAE = 0;

    public static void printMaisVelho() {
        System.out.println("O " + maisVelho.getClass().getSimpleName() + " " + maisVelho.getNome() + " eh o mais velho e tem " + String.valueOf(maisVelho.getIdade()) + " anos");
    }
    
    public static void printPesoDosLados(){
        System.out.println("Gregos e Nordicos pesam " + String.valueOf(somaPesoGN) + " kilos");
        System.out.println("Atlantes e Egipcios pesam " + String.valueOf(somaPesoAE) + " kilos");
    }
    
    private static void somatorioDePesos(int lado,Guerreiro g){
        if(lado == 1 ){
            somaPesoGN = somaPesoGN + g.getPeso();
        }else{
            somaPesoAE = somaPesoAE + g.getPeso();
        }
    }
    
    
  
    public static void listarFilas(Arena arena){
        int lado,fila;
         
        for(lado = 1;lado<=2;lado++){
            Iterator it1 = arena.getFilas(lado).iterator();
            System.out.println("LADO " + String.valueOf(lado) + ":");
            fila = 1;
            while(it1.hasNext()){
                System.out.println(" Fila " + String.valueOf(fila) + ":");
                Iterator it2 = arena.getLista(lado,fila).iterator();
                
                while(it2.hasNext()){
                    Guerreiro g = (Guerreiro) it2.next();
                    System.out.println("    " + g.getClass().getSimpleName() + ": " + g.getNome() + ", " + String.valueOf(g.getIdade()) + " anos, " + String.valueOf(g.getPeso()) + " kilos" );
                   
                }
                it1.next();
                fila++;
            }
            System.out.println();
            
            
        }
        
    }
    
    private static void definirGuerreiroMaisVelho(int idade,Guerreiro g){
        if(idade > maiorIdade ){
            maiorIdade = idade;
            maisVelho = g;
        }
    }
    
    
    public static void lerArquivo(Arena arena) {
       int lado,fila,verificaLeitura,tipo,peso,idade;
       String arq, nome;
       FileInputStream file;
       Scanner scan;
       for(lado=1; lado <=2; lado++){
           
           fila = 1;
           verificaLeitura = 0;
           do{
               arq = "fila" + String.valueOf(lado) + String.valueOf(fila) + ".txt";
               
               try{
                   file = new FileInputStream(arq);
                   scan = new Scanner(file);
                   //System.out.println(arq);
                   arena.getFilas(lado).add(new Fila());
                   int posicao = 0;
                   while(scan.hasNext()){
                        tipo = scan.nextInt();
                        nome = scan.next();
                        idade = scan.nextInt();
                        peso = scan.nextInt();
                        arena.getLista(lado,fila).add(Criador.criarGuerreiro(tipo,lado,nome,idade,peso,100));
                        
                        
                        
                        somatorioDePesos(lado,arena.getGuerreiro(lado,fila,posicao));
                        definirGuerreiroMaisVelho(idade,arena.getGuerreiro(lado,fila,posicao));
                        
                        posicao++;
                        
                   }
                   scan.close();
             
               }catch(FileNotFoundException erro){
                   verificaLeitura = 1;
               }
               fila++;
               
           }while(verificaLeitura != 1);
           
       }
       
       
       
       
 }
       public static int randomizarTurno(){
          int num = (int)(Math.random()*100);
          if(num % 2 == 0){
              return 2;
          }else{
              return 1;
          }
          
       } 
    
   
    
}
