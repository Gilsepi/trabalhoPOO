package trabalhopoo;

import java.util.Scanner;


public class TrabalhoPOO {

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       System.out.println("Bem vindo ao jogo Age Of Mythology Retold Arena");
       System.out.print("\n\n\t\tJOGAR\n\n\n\n");
       System.out.print("Pressione enter...");
       scanner.nextLine();
       do{
           Gerenciador.iniciarJogo();
           System.out.print("\n\nDeseja jogar novamente sim[s] ou nao[n]: ");
       }while(scanner.next().toLowerCase().equals("s"));
       
      
    }
   
}
    

    
 