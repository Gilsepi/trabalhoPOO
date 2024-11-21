/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo;



/**
 *
 * @author Gilsepi e Matheus Pereira
 */
public class Arena {
    private final  Lado lado1; 
    private final  Lado lado2;

    public Arena(Lado lado1,Lado lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    public Lado getLado1() {
        return lado1;
    }

    public Lado getLado2() {
        return lado2;
    }
}
