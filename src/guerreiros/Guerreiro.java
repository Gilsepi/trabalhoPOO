
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
 
    public abstract int[] atacar(Arena arena,int filaAtacando,int fila,boolean primeiroLadoAtacando); 
    
    public void sofrerDano(int dano){
        this.setEnergia(this.getEnergia() - dano);
    }
    
    public void verificarVeneno(){
        if(this.getEnvenenado()!= 0){
            this.sofrerDano(this.getEnvenenado());
        }
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

    public void morrer(Arena arena, int fila){
       this.setEnergia(0);
    }
    
    
}
