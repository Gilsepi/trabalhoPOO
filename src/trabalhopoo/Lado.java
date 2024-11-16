/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo;

import java.util.LinkedList;

/**
 *
 * @author Gilsepi e Matheus Pereira
 */
public class Lado {
    private final LinkedList<Fila> fila;
    private int flagFilaDoGuerreiroAlvo = -1;
    private final String nome;

    public Lado(LinkedList<Fila> fila,String nome) {
        this.fila = fila;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public LinkedList<Fila> getFilas() {
        return fila;
    }

    public void setFlagFilaDoGuerreiroAlvo(int flagGuerreiroAlvo) {
        this.flagFilaDoGuerreiroAlvo = flagGuerreiroAlvo;
    }

    public int getFlagFilaDoGuerreiroAlvo() {
        return flagFilaDoGuerreiroAlvo;
    }
    
    
}
