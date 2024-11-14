
package guerreiros;

import trabalhopoo.Arena;


public abstract class Guerreiro {
    private int energia;
    private int peso;
    private int idade;
    private String nome;

    public Guerreiro(int energia, int peso, int idade, String nome) {
        this.energia = energia;
        this.peso = peso;
        this.idade = idade;
        this.nome = nome;
    }
 
    public abstract void atacar(Arena arena,int lado,int fila);
    public abstract void sofrerAtaque(Guerreiro g,int dano);
    
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
    
    
    
}
