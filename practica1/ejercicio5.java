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
public class ejercicio5 {
    private int []arreglos;
    private datos d3;
    
    public static datos Metodo1(int arreglo[]) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int suma = 0;
        
        for(int i =0; i < arreglo.length; i++){
            if(max < arreglo[i]){
                max = arreglo[i];
            }
            if(min > arreglo[i]){
               min = arreglo[i];
            }
            suma = suma + arreglo[i];
        }
        double prom =  suma / arreglo.length;
       return new datos(max, min,prom);
    }
    
    public static void metodo2(datos d2) {
        int max = Integer.MIN_VALUE;
        int min =  Integer.MAX_VALUE;
        int suma = 0;
        int []arreglo = d2.getArreglo();
        
        for(int i = 0; i < arreglo.length; i++){
            if(max < arreglo[i]){
                max = arreglo[i];
            }
            if(min > arreglo[i]){
                min = arreglo[i];
            }
            suma += arreglo[i];
        }
        double prom = suma / arreglo.length;
        d2.setMin(min);
        d2.setMax(max);
        d2.setProm(prom);
    }
    
    public ejercicio5(int[] arreglos) {
        this.arreglos = arreglos;
    }
    
    public void metodo3() {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int suma = 0;
        
        for(int i = 0; i < this.arreglos.length; i++){
            if(max < arreglos[i]){
                max = arreglos[i];
            }
            if(min > arreglos[i]){
                min = arreglos[i];
            }
            suma += arreglos[i];
        }
        double prom = suma / this.arreglos.length;
        this.d3 = new datos(max,min,prom);
    }

    public datos getD3() {
        return d3;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int []arreglo = {1,2,3,4,5};
        
        datos d = Metodo1(arreglo);
        System.out.println(d.toString());
        
        datos d2 = new datos(arreglo);
        metodo2(d2);
        System.out.println(d2.toString());
        
        ejercicio5 ej =  new ejercicio5(arreglo);
        ej.metodo3();
        System.out.println(ej.getD3());
        
    }
    
}
