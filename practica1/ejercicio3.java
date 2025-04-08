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
public class ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void imprimirestudiantes(estudiante [] arreglo_estudiantes) {
        for(int i=0; i < arreglo_estudiantes.length; i++ ){
            System.out.println("el estudiante: ");
            System.out.println(arreglo_estudiantes[i].tusdatos());
        }
    }
    
    public static void imprimirprofesores(profesor []array_profesores) {
        for(int i =0; i < array_profesores.length;i++){
            System.out.println("el profesor: ");
            System.out.println(array_profesores[i].tusdatos());
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        estudiante e1 = new estudiante("matias","molineri",1,"@","136 e 32 y 33");
        estudiante e2 = new estudiante("martin","mechoni",1,"@","4 e 71 y 72");
        estudiante[] arreglo_estudiantes = new estudiante[2];
        arreglo_estudiantes[0] = e1;
        arreglo_estudiantes[1] = e2;
        profesor p1 = new profesor("c","c","@","catedra","facultad de informatica");
        profesor p2 = new profesor("d","d","@","catedra","facultad de informatica");
        profesor p3 = new profesor("e","e","@","catedra","facultad de informatica");
        profesor[] array_profesores = new profesor[3];
        array_profesores[0] = p1;
        array_profesores[1] = p2;
        array_profesores[2] = p3;
        imprimirestudiantes(arreglo_estudiantes);
        imprimirprofesores(array_profesores);
    }
    
}
