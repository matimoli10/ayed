/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.Scanner;
public class ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static int[] multiplos(int n){
        int[] arreglo = new int[n]; 
        for (int i = 0; i<n; i++){
            arreglo[i] = n*(i+1);
        }
        return arreglo;
    }
    public static void imprimir(int[]arreglo_n, int n) {
        for(int i=0;i<n;i++){
            System.out.println("en la posicion "+(i+1)+" esta en numero: "+arreglo_n[i]);
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("ingrese el valor qeu le quiere poner a n");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();   
        while(n!=0){
            int [] arreglo_n = multiplos(n);
            imprimir(arreglo_n,n);
            System.out.println("ingrese el siguiente numero, si es 0 finaliza");
            n = s.nextInt();
        }
    }
    
}
