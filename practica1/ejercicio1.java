/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

/**
 *
 * @author PC
 */
public class ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static boolean esmenor(int a,int b) {
        return a <= b;
    }

    public static void metodouno(int a, int b) {
        if(esmenor(a,b)){
            System.out.println("numeros entre el "+a+" y el "+b);
            for (int i = a; i <= b; i++){
                System.out.println("numero: "+i);
          }
        }
    }
    public static void metododos(int a, int b) {
        System.out.println("numeros entre el "+a+" y el "+b);
        if(esmenor(a,b)){
            int i = a;
            while(i <= b){
                System.out.println("numero: "+i);
                i++;
            }
        }
    }
    public static void metodotres(int a,int b) {
        if(esmenor(a,b)){
            System.out.println("numero: "+a);
            metodotres(a+1,b);    
        }
    }
    
    public static void main (String[] args) {
        int a,b;
        // TODO code application logic here
        a = 2;
        b = 8;
        metodouno(1,5);
        metododos(3,7);
        System.out.println("numeros entre el "+a+" y el "+b);
        metodotres(a,b);
    }
    
}
