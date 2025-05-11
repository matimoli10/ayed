/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;

/**
 *
 * @author PC
 */
public class compuesto {
    private int vueltas;
    private double comp;

    public compuesto(int vueltas, int comp) {
        this.vueltas = vueltas;
        this.comp = comp;
    }

    public int getVueltas() {
        return vueltas;
    }

    public void setVueltas(int vueltas) {
        this.vueltas = vueltas;
    }

    public double getComp() {
        return comp;
    }

    public void setComp(int comp) {
        this.comp = comp;
    }
    
}
