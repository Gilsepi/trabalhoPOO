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
    private static LinkedList<Guerreiro> guerreirosParaAdicionar = new LinkedList<>();
    
    public static void instanciarArena(){
        LinkedList<Fila> filas1 = new LinkedList<>();
        LinkedList<Fila> filas2 = new LinkedList<>();
        Lado lado1 = new Lado(filas1,"Gregos e Nordicos");
        Lado lado2 = new Lado(filas2,"Atlantes e Egipcios");
        arena = new Arena(lado1,lado2);
    }
    
    public static void printUltimoMorto(){
        System.out.println("O(A) " + ultimoGuerreiroMorto.getClass().getSimpleName() + " " + ultimoGuerreiroMorto.getNome() + " de " + String.valueOf(ultimoGuerreiroMorto.getIdade()) + " anos e " + String.valueOf(ultimoGuerreiroMorto.getPeso()) + " kilos foi o(a) ultimo(a) a ser derrotado(a) do lado dos " + ladoPerdedor.getNome());
    } // lembrar pegar o toSring e fazer Override para cada guerreiro 
    //
    //ATENCAO ATENCAOATENCAO ATENCAOATENCAO ATENCAOATENCAO ATENCAOATENCAO ATENCAO
    //ATENCAO ATENCAOATENCAO ATENCAOATENCAO ATENCAOATENCAO ATENCAOATENCAO ATENCAO
    // ATENCAO ATENCAOATENCAO ATENCAOATENCAO ATENCAOATENCAO ATENCAOATENCAO ATENCAO
    //ATENCAO ATENCAOATENCAO ATENCAOATENCAO ATENCAOATENCAO ATENCAOATENCAO ATENCAO
    
    public static void printUltimoAtacou(){
        System.out.println("O(A) " + ultimoGuerreiroAtacou.getClass().getSimpleName() + " " + ultimoGuerreiroAtacou.getNome() + " de " + String.valueOf(ultimoGuerreiroAtacou.getIdade()) + " anos e " + String.valueOf(ultimoGuerreiroAtacou.getPeso()) + " kilos transferiu o ultimo ataque no(a) " + ultimoGuerreiroMorto.getClass().getSimpleName() + " " + ultimoGuerreiroMorto.getNome() + " de " + String.valueOf(ultimoGuerreiroMorto.getIdade()) + " anos e " + String.valueOf(ultimoGuerreiroMorto.getPeso()) + " kilos");
    }
    
    public static void iniciarJogo(){
        instanciarArena();
        lerArquivo();
        printMaisVelho();
        printPesoDosLados();
        listarFilas();
        iniciarTurnos();
        printUltimoMorto();
        printUltimoAtacou();
    }
    
    
    public static void iniciarTurnos(){
        while(!verificarVitoria()){
            int ladoQueAtacaPrimeiro = randomizarTurno(); // boolean em atacar() de guerreiro pra saber que ele é o primeiro a atacar
            int outroLado = (ladoQueAtacaPrimeiro == 2) ? 1 : 2;
            int fila;
            int i;
            int filasAtacadas[];
            Guerreiro vetorGuerreiros[] = null;
            Guerreiro guerreiroAtacando;
            for(fila = 1;fila<=getFilas(ladoQueAtacaPrimeiro).size();fila++ ){
                if(!getLista(ladoQueAtacaPrimeiro,fila).isEmpty()){
                    guerreiroAtacando = getLista(ladoQueAtacaPrimeiro,fila).getFirst();
                    int localizar = localizarAtaque(getLado(outroLado),outroLado,fila);
                    if(localizar == -1){
                        break;
                    }
                    ultimoGuerreiroAtacou = guerreiroAtacando;
                    filasAtacadas = guerreiroAtacando.atacar(arena, fila, localizar , true);
                    if(verificarMorteGuerreiro(guerreiroAtacando)){
                        
                        vetorGuerreiros = guerreiroAtacando.morrer(arena, fila);
                        ultimoGuerreiroMorto = getLista(ladoQueAtacaPrimeiro,fila).remove();
                        if(vetorGuerreiros != null){
                            for(i=0;i<vetorGuerreiros.length;i++){
                                guerreirosParaAdicionar.add(vetorGuerreiros[i]);
                            }
                        }
                        
                    }
                    for(Guerreiro g : guerreirosParaAdicionar){
                        if(g != null)getLista(ladoQueAtacaPrimeiro,fila).add(g);
                    }
                    guerreirosParaAdicionar.removeAll(guerreirosParaAdicionar);
                    

                    
                    for(i = 0;i<filasAtacadas.length;i++){
                        if(filasAtacadas[i]==0){
                            break;
                        }
                        LinkedList<Guerreiro> lista = getLista(outroLado,filasAtacadas[i]);
                        Iterator<Guerreiro> it = lista.iterator();

                        while (it.hasNext()) {
                            Guerreiro g = it.next();
                            if (verificarMorteGuerreiro(g)) {
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
            
            for(fila = 1;fila<=getFilas(outroLado).size();fila++ ){
                if(!getLista(outroLado,fila).isEmpty()){
                    guerreiroAtacando = getLista(outroLado,fila).getFirst();
                    int localizar = localizarAtaque(getLado(ladoQueAtacaPrimeiro),ladoQueAtacaPrimeiro,fila);
                    if(localizar == -1){
                        break;
                    }
                    ultimoGuerreiroAtacou = guerreiroAtacando;
                    
                    filasAtacadas = guerreiroAtacando.atacar(arena, fila, localizar , false);
                    if(verificarMorteGuerreiro(guerreiroAtacando)){
                        vetorGuerreiros = guerreiroAtacando.morrer(arena,fila);
                        ultimoGuerreiroMorto = getLista(outroLado,fila).removeFirst(); 
                        if(vetorGuerreiros != null){
                            for(i=0;i<vetorGuerreiros.length;i++){
                                guerreirosParaAdicionar.add(vetorGuerreiros[i]);
                            }
                        }
                    }
                    
                    for(Guerreiro g : guerreirosParaAdicionar){
                        if(g != null)getLista(outroLado,fila).add(g);
                    }
                    guerreirosParaAdicionar.removeAll(guerreirosParaAdicionar);
                    
                    for(i = 0;i<filasAtacadas.length;i++){
                        if(filasAtacadas[i]==0){
                            break;
                        }
                        LinkedList<Guerreiro> lista = getLista(ladoQueAtacaPrimeiro,filasAtacadas[i]);
                        Iterator<Guerreiro> it = lista.iterator();
                        
                        while (it.hasNext()) {
                            Guerreiro g = it.next();
                            if (verificarMorteGuerreiro(g)) {
                                vetorGuerreiros = g.morrer(arena, filasAtacadas[i]);
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
                            if(g != null) lista.add(g);
                        }
                        guerreirosParaAdicionar.removeAll(guerreirosParaAdicionar);
                        
                        
                        
                    }
                    
                    
                    
                    
                }
                
            }
            
            
            
            
            System.out.println("=====================================");
            System.out.println(ladoQueAtacaPrimeiro);
     
            levarGuerreirosParaFinalDaFila();
            listarFilas();
            resetarConfiguracaoArena();
            
            
            
            
        }
    }
   
   private static void resetarConfiguracaoArena(){
       getLado(1).setFlagFilaDoGuerreiroAlvo(-1);
       getLado(2).setFlagFilaDoGuerreiroAlvo(-1);
   }
    
    
 
    public static int localizarAtaque(Lado ladoAtacado,int lado,int filaAtacando){
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
        }else{// No caso do forcarAtaque for lista vazia, percorre as outras lista para achar algum guerreiro alvo
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
            filaDoGuerreiroAtacado = -1;
            
        }
        
        return filaDoGuerreiroAtacado; // atenção retorna -1 se não houver guerreiros para atacar, ou seja acabou a partida
    }
    

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
    

    public static void listarFilas(){
        int lado,fila;
         
        for(lado = 1;lado<=2;lado++){
            Iterator it1 = getFilas(lado).iterator();
            System.out.println("LADO " + String.valueOf(lado) + ":");
            fila = 1;
            while(it1.hasNext()){
                System.out.println(" Fila " + String.valueOf(fila) + ":");
                Iterator it2 = getLista(lado,fila).iterator();
                
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
    
    
    public static void lerArquivo() {
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
       public static int randomizarTurno(){
          int num = (int)(Math.random()*100);//gera um número entre 0 e 99
          if(num % 2 == 0){ // se o numero for par retorna 2, para o segundo lado começar atacando
              return 2;
          }else{ // se for impar retorna 1, e o lado que ataca é o primeiro
              return 1;
          }
          
       } 
       
       public static Lado getLado(int lado){
           if(lado == 1){
               return arena.getLado1();
           }else{
               return arena.getLado2();
           }
       }
       
       public static LinkedList<Fila> getFilas(int lado){
        return getLado(lado).getFilas();
        }
    
       public static LinkedList<Guerreiro> getLista(int lado,int fila){
        return getFilas(lado).get(fila-1).getLista();
       }
    
       public static Guerreiro getGuerreiro(int lado,int fila,int posicao){
        return getLista(lado,fila).get(posicao);
       }
   
     public static boolean verificarMorteGuerreiro(Guerreiro g){
        if(g.getEnergia()<=0){
            return true;
        } else{
            return false;
        }
         
    }
    
    public static boolean verificarVitoria(){
       LinkedList<Fila> lado = getFilas(1);
       ladoVencedor = getLado(2);
       ladoPerdedor = getLado(1);
       boolean temGuerreiro = false;
       int fila;
       for(fila = 1;fila<=lado.size();fila++){
           LinkedList<Guerreiro> lista = getLista(1,fila);
           if (!lista.isEmpty()){
               temGuerreiro = true;
               ladoVencedor = getLado(1);
               ladoPerdedor = getLado(2);
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
        
        System.out.println("\n" + ladoVencedor.getNome() + " venceram" );
        return true;
    }
    
    public static void levarGuerreirosParaFinalDaFila(){
        int lado;
        int fila;
        for(lado = 1;lado<=2;lado++){
            for(fila = 1;fila<= getFilas(lado).size();fila++){
                LinkedList<Guerreiro> lista = getLista(lado,fila);
                if(!lista.isEmpty()){
                    Guerreiro aux = lista.removeFirst();
                    lista.addLast(aux);  
                }
                
            }
        }
    }
    
   
    
    
    
    
}
