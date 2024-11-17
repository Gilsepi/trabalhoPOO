/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo;

import guerreiros.Guerreiro;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Gilsepi e Matheus Pereira
 */
public class Gerenciador {
    private static Guerreiro maisVelho;
    private static int maiorIdade = 0;
    private static int somaPesoGN = 0;
    private static int somaPesoAE = 0;
    private static Arena arena;
    private static Guerreiro ultimoGuerreiroMorto;
    private static Guerreiro ultimoGuerreiroAtacou;
    private static Lado ladoVencedor;
    private static Lado ladoPerdedor;
    private static final LinkedList<Guerreiro> guerreirosParaAdicionar = new LinkedList<>();
    
    private static void instanciarArena(){
        LinkedList<Fila> filas1 = new LinkedList<>();
        LinkedList<Fila> filas2 = new LinkedList<>();
        Lado lado1 = new Lado(filas1,"Gregos e Nordicos");
        Lado lado2 = new Lado(filas2,"Atlantes e Egipcios");
        arena = new Arena(lado1,lado2);
    }
    
    private static void printUltimoMorto(){
        System.out.println("O(A) " + ultimoGuerreiroMorto + " foi o(a) ultimo(a) a ser derrotado(a) do lado dos " + ladoPerdedor.getNome());
    } 
    
    private static void printUltimoAtacou(){
        if(ultimoGuerreiroAtacou != null){
            System.out.println("\nO(A) " + ultimoGuerreiroAtacou + " transferiu o ultimo ataque no(a) " + ultimoGuerreiroMorto);
        }else{
            System.out.println("\nNao teve ultimo golpe transferido, O(A) " + ultimoGuerreiroMorto.getClass().getSimpleName() + " " + ultimoGuerreiroMorto.getNome() + " de " + String.valueOf(ultimoGuerreiroMorto.getIdade()) + " anos e " + String.valueOf(ultimoGuerreiroMorto.getPeso()) + " kilos, morreu envenenado(a)");
        }
    }
    
    public static void iniciarJogo(){
        instanciarArena();
        lerArquivo();
        System.out.println("\n\n\t====== RELATORIO DA PARTIDA ======\n\n");
        listarFilas();
        printPesoDosLados();
        printMaisVelho();
        System.out.println("\n\n\t====RESULTADO DA ARENA====\n\n");
        iniciarTurnos();
        listarFilas();
        System.out.println("\n" + ladoVencedor.getNome() + " venceram\n" );
        printUltimoMorto();
        printUltimoAtacou();
    }
    
    private static void adicionarGuerreirosNaFila(int lado,int fila){
        for(Guerreiro g : guerreirosParaAdicionar){ //adiciona os guerreiros da linkedlist, caso existam, na fila
            if(g != null)getLista(lado,fila).add(g); 
        }
        guerreirosParaAdicionar.removeAll(guerreirosParaAdicionar); //remove todos os guerreiros da linkedlist
    }   
  
    
    private static void ladoAtacar(int ladoAtacante, int ladoAtacado,boolean atacaPrimeiro){
        int fila;
        int i;
        int filasAtacadas[];
        Guerreiro vetorGuerreiros[];
        Guerreiro guerreiroAtacando;
        for(fila = 1;fila<=getFilas(ladoAtacante).size();fila++ ){ // Pega o lado atacante e percorre suas filas
            if(!getLista(ladoAtacante,fila).isEmpty()){ // Vê si há vila não está vazia, ou seja, tem guerreiro
                guerreiroAtacando = getLista(ladoAtacante,fila).getFirst(); // Pega o primeiro guerreiro da fila
                int localizar = localizarAtaque(getLado(ladoAtacado),ladoAtacado,fila); //Localiza um inimigo do outro lado
                
                if(localizar == -1){
                    break;// Se não achou ninguém para atacar para o loop, um lado venceu!
                }
                
                ultimoGuerreiroAtacou = guerreiroAtacando;
                filasAtacadas = guerreiroAtacando.atacar(arena, fila, localizar , atacaPrimeiro); // chama o atacar() do guerreiro
                if(verificarMorteGuerreiro(guerreiroAtacando)){              // Verifica se o próprio guerreiro que atacou morreu, por conta de veneno
                    vetorGuerreiros = guerreiroAtacando.morrer(arena, fila); // Se o guerreiro atacando morreu chama o método morrer dele
                    ultimoGuerreiroMorto = getLista(ladoAtacante,fila).remove();         // remove o guerreiro da fila
                    ultimoGuerreiroAtacou = null;
                    
                    if(vetorGuerreiros != null){                    //Verifica se tem guerreiros para adicionar, ja que alguns guerreiros
                        for(i=0;i<vetorGuerreiros.length;i++){      // quando morrem instânciam outros guerreiros
                            guerreirosParaAdicionar.add(vetorGuerreiros[i]);  //Salva novos guerreiros em uma linkelist
                        }
                    }

                }
                for(Guerreiro g : guerreirosParaAdicionar){ //adiciona os guerreiros da linkedlist, caso existam, na fila
                    if(g != null)getLista(ladoAtacante,fila).add(g); 
                }
                guerreirosParaAdicionar.removeAll(guerreirosParaAdicionar); //remove todos os guerreiros da linkedlist
                
                
                if(verificarVitoria()) break; // Se há um vencedor nesse ponto significa que o ultimo guerreiro morreu envenenado


                for(i = 0;i<filasAtacadas.length;i++){ //Pega todas as filas que foram atacadas pelo guerreiroAtacando
                    if(filasAtacadas[i]==0){
                        break; // para o loop quando acabarem as filas com indices válidos(maiores que zero)
                    }
                    LinkedList<Guerreiro> lista = getLista(ladoAtacado,filasAtacadas[i]);
                    Iterator<Guerreiro> it = lista.iterator();

                    while (it.hasNext()) { // Itera sobre a fila atacada
                        Guerreiro g = it.next(); // Pega um guerreiro da fila
                        if (verificarMorteGuerreiro(g)) { // Verifica se ele morreu
                            vetorGuerreiros = g.morrer(arena,filasAtacadas[i]);
                            ultimoGuerreiroMorto = g;
                            it.remove();  // Remove o guerreiro de forma segura
                            if(vetorGuerreiros != null){
                                for(i=0;i<vetorGuerreiros.length;i++){
                                    guerreirosParaAdicionar.add(vetorGuerreiros[i]);

                                }
                             }
                        }

                    }
                    
                    for(Guerreiro g : guerreirosParaAdicionar){
                     if(g != null)lista.add(g);
                    }
                    guerreirosParaAdicionar.removeAll(guerreirosParaAdicionar);


                }
            }

        }
    }
    
    
    
    
    
    
    private static void iniciarTurnos(){
        while(!verificarVitoria()){
            int ladoQueAtacaPrimeiro = randomizarTurno(); // Escolhe o lado que ataca primeiro aleatoriamente
            int outroLado = (ladoQueAtacaPrimeiro == 2) ? 1 : 2; // Define o outro lado
            ladoAtacar(ladoQueAtacaPrimeiro,outroLado,true);
            ladoAtacar(outroLado,ladoQueAtacaPrimeiro,false);
            levarGuerreirosParaFinalDaFila();
            resetarConfiguracaoArena();
        }
        
    }
   
   private static void resetarConfiguracaoArena(){
       getLado(1).setFlagFilaDoGuerreiroAlvo(-1);
       getLado(2).setFlagFilaDoGuerreiroAlvo(-1);
   }
    
    
 
    private static int localizarAtaque(Lado ladoAtacado,int lado,int filaAtacando){
        int filaDoGuerreiroAtacado;
        int filaAtacada = filaAtacando; // A principio a fila que será atacada é a mesma fila que está atacando 
        int forcarAtaque = ladoAtacado.getFlagFilaDoGuerreiroAlvo();
        filaDoGuerreiroAtacado = forcarAtaque;
        int tamanho = getFilas(lado).size();
        int i;
        // Caso forcarAtaque seja diferente de -1 o alvo estará no indice que forcarAtaque contém (poder do Gigante de pedra)
        if(forcarAtaque == -1){
            
 
            if(filaAtacando > tamanho){    //No caso de existirem numero de filas diferentes para cada lado, quando a fila 
                filaAtacada = 1;          //que o guerreiro atacando for maior que o numero de filas do outro lado, ele deve 
            }                             //começar atacando a primeira fila
            
            
            for(i = 0;i<tamanho;i++){                       //entra em um loop perguntando se a fila a ser atacada não está vazia
                if(!getLista(lado,filaAtacada).isEmpty()){  // se não vazia é ela que será atacada, se vazia pula pra próxima
                    filaDoGuerreiroAtacado = filaAtacada;
                    break;
                }
                filaAtacada++;              // Caso chegue na ultima fila e não ache ningúem para atacar
                if(filaAtacada > tamanho){  // procura na primeira fila e seus conseguintes
                    filaAtacada = 1;
                }
            }
        }else{
            // No caso do indice do forcarAtaque for lista vazia, percorre as outras lista para achar algum guerreiro alvo
            filaAtacada = forcarAtaque;
            for(i = 0;i<tamanho;i++){                       
                if(!getLista(lado,filaAtacada).isEmpty()){  
                    filaDoGuerreiroAtacado = filaAtacada;
                    break;
                }
                filaAtacada++;              
                if(filaAtacada > tamanho){  
                    filaAtacada = 1;
                }
            }
            filaDoGuerreiroAtacado = -1;// Se chegar aqui não encontrou guerreiros em nenhuma fila
            
        }
        
        return filaDoGuerreiroAtacado; // atenção retorna -1 se não houver guerreiros para atacar, ou seja acabou a partida
    }
    

    private static void printMaisVelho() {
        System.out.println("\nO(A) " + maisVelho.getClass().getSimpleName() + " " + maisVelho.getNome() + " eh o(a) mais velho(a) e tem " + String.valueOf(maisVelho.getIdade()) + " anos");
    }
    
    private static void printPesoDosLados(){
        System.out.println("\nGregos e Nordicos pesam " + String.valueOf(somaPesoGN) + " kilos");
        System.out.println("Atlantes e Egipcios pesam " + String.valueOf(somaPesoAE) + " kilos");
    }
    
    private static void somatorioDePesos(int lado,Guerreiro g){
        if(lado == 1 ){
            somaPesoGN = somaPesoGN + g.getPeso();
        }else{
            somaPesoAE = somaPesoAE + g.getPeso();
        }
    }
    

    private static void listarFilas(){
        int lado,fila;
         
        for(lado = 1;lado<=2;lado++){ // Define o lado
            Iterator it1 = getFilas(lado).iterator();
            System.out.println("LADO " + String.valueOf(lado) + ":");
            fila = 1;
            while(it1.hasNext()){ // Itera sofre as filas desse lado
                System.out.println(" Fila " + String.valueOf(fila) + ":");
                Iterator it2 = getLista(lado,fila).iterator();
                
                while(it2.hasNext()){ // Itera sofre a lista de guerreiros de cada fila
                    Guerreiro g = (Guerreiro) it2.next(); // Pega o guerreiro e printa suas informações
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
    
    private static void lerArquivo() {
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
                   // adiciona uma nova fila, para o lado
                   LinkedList<Guerreiro> lista = new LinkedList();
                   getFilas(lado).add(new Fila(lista));
                   
                   int posicao = 0;
                   while(scan.hasNext()){
                        //Lê dos arquivos e guarda as informações dos guerreiros
                        tipo = scan.nextInt();
                        nome = scan.next();
                        idade = scan.nextInt();
                        peso = scan.nextInt();
                        //Usa as informações guardadas para inserir um novo guerreiro no lugar certo
                        getLista(lado,fila).add(Criador.criarGuerreiro(tipo,lado,nome,idade,peso,100));
                        
                        // função para somar os pesos dos lados, a cada passagem do loop o peso do guerreiro é somado numa variavel estatica
                        somatorioDePesos(lado,getGuerreiro(lado,fila,posicao));
                        //função para definir qual guerreiro é o mais velho, a cada passagem compara a maiorIdade com uma nova idade e salva o guerreiro mais velho
                        definirGuerreiroMaisVelho(idade,getGuerreiro(lado,fila,posicao));
                        
                        posicao++;
                        
                   }
                   scan.close();
             
               }catch(FileNotFoundException erro){ // Exceção que possibilita infinitas filas, se o arquivo delas exitirem
                   verificaLeitura = 1;
               }
               fila++;
               
           }while(verificaLeitura != 1);// sai do loop quando não encontrar mais arquivos de fila corretos
           
       }
       
    }
    
    private static int randomizarTurno(){
       int num = (int)(Math.random()*100);//gera um número entre 0 e 99
       if(num % 2 == 0){ // se o numero for par retorna 2, para o segundo lado começar atacando
           return 2;
       }else{ // se for impar retorna 1, e o lado que ataca é o primeiro
           return 1;
       }

    } 
       
    private static Lado getLado(int lado){
        if(lado == 1){
            return arena.getLado1();
        }else{
            return arena.getLado2();
        }
    }

    private static LinkedList<Fila> getFilas(int lado){ // Atalho para o gerenciador pegar as filas de um lado
     return getLado(lado).getFilas();
    }

    private static LinkedList<Guerreiro> getLista(int lado,int fila){ // Atalho para o gerenciador pegar a lista  de guerreiros de um fila
     return getFilas(lado).get(fila-1).getLista();
    }

    private static Guerreiro getGuerreiro(int lado,int fila,int posicao){ // Atalho para o gerenciador pegar um guerreiro
     return getLista(lado,fila).get(posicao);
    }
   
    private static boolean verificarMorteGuerreiro(Guerreiro g){
        if(g.getEnergia()<=0){ // Se energia do guerreiro <= 0 quer dizer que ele morreu
            return true;
        } else{
            return false;
        }   
    }
    
    private static boolean verificarVitoria(){
       LinkedList<Fila> lado = getFilas(1);
       ladoVencedor = getLado(2); //Define os lados vencedor e perdedor
       ladoPerdedor = getLado(1);
       boolean temGuerreiro = false;
       int fila;
       for(fila = 1;fila<=lado.size();fila++){ // Analisa o lado 1
           LinkedList<Guerreiro> lista = getLista(1,fila);
           if (!lista.isEmpty()){ // Se encontrar algum guerreiro, então ele não é mais o lado perdedor
               temGuerreiro = true;
               ladoVencedor = getLado(1); // inverte os lados vencedor e perdedor
               ladoPerdedor = getLado(2);
               break;
           } // se não encontrar guerreiros, o loop de baixo nunca retorna false, então significa que o lado 1 perdeu e o lado 2 venceu
          
       }
       
       lado = getFilas(2);
       for(fila = 1;fila<=lado.size();fila++){ // Analisa o lado 2
           LinkedList<Guerreiro> lista = getLista(2,fila); 
           if (!lista.isEmpty() && temGuerreiro == true){ // Se encontrar algum guerreiro e o outro lado também haver guerreiro
               return false;                              // Significa que a partida ainda não acabou, verificaVitoria retorna false
           }
       }// Se não encontrar guerreiro mesmo tendo algum guerreiro no lado 1, significa que o lado 2 perdeu e o lado 1 venceu
        
        return true;
    }
    
    private static void levarGuerreirosParaFinalDaFila(){
        int lado;
        int fila;
        for(lado = 1;lado<=2;lado++){ 
            for(fila = 1;fila<= getFilas(lado).size();fila++){
                LinkedList<Guerreiro> lista = getLista(lado,fila);
                if(!lista.isEmpty()){
                    Guerreiro aux = lista.removeFirst(); // Pega o primeiro guerreiro de todos as filas de cada lado e remove salvando um copia
                    lista.addLast(aux); // Devolve o guerreiro para o final da fila
                }
                
            }
        }
    }
       
}
