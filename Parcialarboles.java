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
import java.util.*;
import practica3.GeneralTree;   
import practica1.Queue;
public class Parcialarboles {
    
    public static boolean esDeSeleccion (GeneralTree<Integer> arbol){
        boolean res = false;
        if(arbol != null && !arbol.isEmpty()){
            res = recorroarbol(arbol);
            //res = recorroarbol2(arbol,arbol.getData());
        }
        return res;
    }
   /* esta es una de las formas de hacerlo pero es la mas ineficiente 
    
    
    private static boolean recorroarbol2(GeneralTree<Integer> arbol, int valor){
        boolean res = false;
        if(arbol.hasChildren()){
            Iterator <GeneralTree<Integer>> it = arbol.getChildren().iterator();
            while(res != true && it.hasNext()){
                if(it.next().getData() > valor){
                    res = true;
                }
                else {
                    GeneralTree<Integer> hijo = it.next();
                    res = recorroarbol2(hijo,valor);
                }
            }
        }
        return res;
    }*/
    
    public static boolean recorroarbol(GeneralTree<Integer> arbol){
        Queue<GeneralTree<Integer>> cola = new Queue <>(); //declaro la cola
        boolean res = true;
        cola.enqueue(arbol);// encolo el primer nodo del arbol
        if(res != false && !cola.isEmpty()){ // verifico que res no sea falso y que la cola no este vacia 
            GeneralTree<Integer> act = cola.dequeue();// guardo en act, el valor que saque de la cola 
            if(act.hasChildren()){// veo si act tiene hijos 
                Iterator <GeneralTree<Integer>> it = act.getChildren().iterator();// pongo los hijos en un iterator
                while(res != false && it.hasNext()){// evaluo las condiciones 
                    if(it.next().getData() < act.getData()){//entra si el hijo es menor que el padre
                        res = false;
                    }
                    else{//si no es menor que el padre se encola a la cola 
                        cola.enqueue(it.next());
                    }
                }
          /*    if(res == false){//entra si salio del while por la condicion de que el hijo sea menor que el padre 
                    for(int i = 0; i < cola.size()-1 ;i++){//vacio la cola 
                        cola.dequeue();
                    }  preguntar si estaria bien vaciar la cola cuando no se cumpla o seria alpedo 
                }*/
            }
        }
        return res; 
    }
    
    public static List<Integer> resolver(GeneralTree<Integer> arbol){
        List<Integer> lista = new LinkedList<>(null);
        if(arbol.getData() == 1){
            lista.add(arbol.getData());
        }
        if(arbol.hasChildren()){
            List<Integer> lista2 = new LinkedList<>();
            recorremos(lista,arbol,lista2,0,0,0);
        }
        return lista;
    }
    
    public static void recorremos(List<Integer> lista, GeneralTree<Integer> arbol, List<Integer> lista2, int nivelact, int suma,int max){
        if(arbol.getData() == 1){
                lista2.add(arbol.getData());
                suma += nivelact;//no es necesario evaluar de esta forma ya que siempre va a ser 1 el arbol.getdata() ( nivelact + arbol.getData() );
            }
        if(arbol.isLeaf()){
            if(suma > max){
                lista.removeAll(lista);// se puede hacer con clear el baciar la lista 
                lista.addAll(lista2);
            }    
        }
        else {
            for (GeneralTree<Integer> hijo: arbol.getChildren()){
                recorremos(lista,hijo,lista2,nivelact+1,suma,max);
                // si hago el if de abajo aca dentro cambiando el arbol.getData(), con hijos.getData()estaria borrando en el padre al hijo 
            }
        }
        if(arbol.getData() == 1){//se borra a si mismo
            lista2.remove(lista2.size()-1);
        }
    }
    
    public static boolean escreciente(GeneralTree<Integer> arbol){
        boolean res = true;
        if(!arbol.isEmpty()){
            res = recorroarbolito(arbol);
        }
        else{
            res = false;
        }
        return res;
    }
    
    public static boolean recorroarbolito(GeneralTree<Integer> arbol){
        boolean res = true;
        int cantact = 0;
        int cantpadre = 1;
        Queue<GeneralTree<Integer>> cola = new Queue <>();
        cola.enqueue(arbol);
        cola.enqueue(null);
        while(res != false && !cola.isEmpty()){  
            GeneralTree<Integer> act = cola.dequeue();
            if(act != null){
                for(GeneralTree<Integer> hijo: act.getChildren()){
                    cola.enqueue(hijo);
                    cantact++;
                }
            }
            else{
                if(!cola.isEmpty()){
                    if(cantact != cantpadre + 1){
                        res = false;
                        
                    }
                    else{
                        cantpadre = cantact;
                        cantact = 0;
                        cola.enqueue(null);
                    }
                }
            }
        }
        return res;
    }
}
