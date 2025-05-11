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
import practica3.GeneralTree;
import java.util.*;
public class camino {
    GeneralTree<Integer> arbol;

    public camino(GeneralTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    public List<Integer> caminoAHojaMasLejana(){
        List<Integer> listaact = new LinkedList<>();
        List<Integer> listamax = new LinkedList<>();
        if(arbol.isEmpty()){
             return listamax = null;
        }
        else{
            recorroarbol(this.arbol,listaact,listamax);
        }
        return listamax; 
    }
    public void recorroarbol(GeneralTree<Integer> arbol, List<Integer> listaact, List<Integer> listamax){
        listaact.add(arbol.getData());
        if(arbol.isLeaf()){
            if(listaact.size() > listamax.size()){
                    listamax.removeAll(listamax);
                    listamax.addAll(listaact);
            }
        }
        else{
            for(GeneralTree<Integer> hijo: arbol.getChildren()){ //preguntar si es correcto llamar a los hijos sin evaluar si tiene hijos
                recorroarbol(hijo,listaact,listamax);                                 
            }
        }
        listaact.remove(listaact.size()-1);
    }
    
    
    public static void main(String[] args) {
	List <GeneralTree<Integer>> lista1 = new LinkedList<>();
        lista1.add(new GeneralTree<Integer>(1));
        
        GeneralTree<Integer> hr12 = new GeneralTree<Integer>((6),lista1);
        
        List <GeneralTree<Integer>> lista_hr1 = new LinkedList<>();
        lista_hr1.add(new GeneralTree<Integer>(10));
        lista_hr1.add(hr12);
        GeneralTree<Integer> hr1 = new GeneralTree<Integer>((17),lista_hr1);
        
        
        List <GeneralTree<Integer>> lista2 =  new LinkedList<>();
        lista2.add(new GeneralTree<Integer>(8));
        GeneralTree<Integer> hr2 = new GeneralTree<Integer>((9),lista2);
        
        
        List <GeneralTree<Integer>> lista3 = new LinkedList<>();
        lista3.add(new GeneralTree<Integer>(16));
        lista3.add(new GeneralTree<Integer>(7));
        GeneralTree<Integer> hr31 = new GeneralTree<>((14),lista3);
        List <GeneralTree<Integer>> lista_hr3 = new LinkedList<>();
        lista_hr3.add(hr31);
        lista_hr3.add(new GeneralTree<Integer>(18));
        GeneralTree<Integer> hr3 = new GeneralTree<>((15),lista_hr3);
        
        
        List <GeneralTree<Integer>> lista_hr = new LinkedList<>();
        lista_hr.add(hr1);
        lista_hr.add(hr2);
        lista_hr.add(hr3);
        GeneralTree<Integer> Arbol = new GeneralTree<Integer>((12),lista_hr);
                
        camino cam = new camino(Arbol);// no especifico el tipo ni nada a la hora de crearlo ya que el main se encuentra en esta clase 
        System.out.println("el camino a la hija mas lejana es: "+ cam.caminoAHojaMasLejana()); // preguntar por que funciona asi y no tnes que recorrer la lista 
	}
}
