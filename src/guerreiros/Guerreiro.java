
package guerreiros;

import trabalhopoo.Arena;


public abstract class Guerreiro {
    private int energia;
    private int peso;
    private int idade;
    private String nome;
    private int envenenado;
    private int danoDeAtaque;

    

    public Guerreiro(int energia, int peso, int idade, String nome, int danoDeAtaque) {
        this.energia = energia;
        this.peso = peso;
        this.idade = idade;
        this.nome = nome;
        this.danoDeAtaque = danoDeAtaque;
        this.envenenado = 0; 
    }
 
    //O método atacar retorna um vetor de inteiros que representam os indices das filas atacadas
    public abstract int[] atacar(Arena arena,int filaAtacando,int fila,boolean primeiroLadoAtacando); 
    
    
    public void sofrerDano(int dano){
        this.setEnergia(this.getEnergia() - dano);
    }
    
    public void verificarVeneno(){ // função chamada em atacar() de todos os guerreiros, para ele tomar o dano do veneno caso esteja envenenado
        if(this.getEnvenenado()!= 0){
            this.sofrerDano(this.getEnvenenado());
        }
    }
    
    //O método morrer retorna um vetor de Guerreiros, pois alguns guerreiros quando morrem instânciam outros guerreiros
    public Guerreiro[] morrer(){
       this.setEnergia(0);
       return null;
    }
    
    public void receberCura(int cura){
        this.setEnergia(this.getEnergia() + cura);
    }
    
    public int getDanoDeAtaque() {
        return danoDeAtaque;
    }
    public int getEnvenenado() {
        return envenenado;
    }
    
    public int getEnergia() {
        return energia;
    }

    public int getPeso() {
        return peso;
    }

    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setDanoDeAtaque(int danoDeAtaque) {
        this.danoDeAtaque = danoDeAtaque;
    }

    public void setEnvenenado(int envenenado) {
        this.envenenado = envenenado;
    }
    
    @Override
    public String toString(){
        return this.getClass().getSimpleName() + " " + this.getNome() + " de " + String.valueOf(this.getIdade()) + " anos e " + String.valueOf(this.getPeso()) + " kilos";
    }
    
    
    
}
