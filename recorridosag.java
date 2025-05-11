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

public class recorridosag {
    public List<Integer> numerosimparesMayoresQuePreOrden(GeneralTree<Integer> a, Integer n){
        List<Integer> lista = new LinkedList<>();
        if(!a.isEmpty()){
            preorden(a,n,lista);
        } 
        return lista;
    }
    
    private void preorden(GeneralTree<Integer> a, Integer n, List<Integer> lista ){
        if(a.getData() % 2 != 0 && a.getData() > n){
            lista.add(a.getData());
        }
        if(a.hasChildren()){
           /* Iterator<GeneralTree<Integer>> it = a.getChildren().iterator();
            while(it.hasNext()){
                GeneralTree<Integer> hijo = it.next();
                preorden(hijo,n,lista);
            }
            asi seria con un iterator 
            */ 
            List <GeneralTree<Integer>> hijos = a.getChildren();
            for(GeneralTree<Integer> hijo : hijos){
                preorden(hijo,n,lista);
            }
            //como hacen lo mismo podes usar cualquiera de las opciones
        }
    }
    
    public List<Integer> numerosimparesMayoresQueInOrden(GeneralTree<Integer> a, Integer n){
        List<Integer> lista = new LinkedList <>();
        if(!a.isEmpty()){
           inorden(a,n,lista);
        }
        return lista;
    }
    
    private void inorden(GeneralTree<Integer> a, Integer n, List<Integer> lista){
        if(a.hasChildren()){
            List<GeneralTree<Integer>> hijos = a.getChildren();//genero una lista con todos los nodos
            int mitad = hijos.size() / 2;// asigno a mitad, la mitad de nodos de la lista;
            
            Iterator <GeneralTree<Integer>> it = a.getChildren().iterator();// genero el iterator
            int corta = 0;// la uso para comparar con mitad 
            
            while(it.hasNext() && corta < mitad){//mientras se den las condiciones entra
                inorden(it.next(),n,lista);
                corta++;
            }
            // si salio es por que esta lo mas a la derecha posible 
            if(a.getData() % 2 != 0 && a.getData() > n){//evaluo condicion de guardar en la lista 
                lista.add(a.getData());
            }
            while(it.hasNext()){  //este while se usa para que cuando vuelve al nodo inicial lea sus otras ramas
               inorden(it.next(),n,lista);
            }
        }
    }
    public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a,Integer n){
        List<Integer> lista = new LinkedList<>();
        if(!a.isEmpty()){
            postorden(a,n,lista);
        }
        return lista;
    }
    
    private void postorden(GeneralTree<Integer> a,Integer n, List<Integer> lista){
        if(a.hasChildren()){
            List<GeneralTree<Integer>> hijos = a.getChildren();
            for(GeneralTree<Integer> hijo: hijos){
                postorden(a,n,lista);
            }            
        }
        if(a.getData() % 2 != 0 && a.getData() > n){
            lista.add(a.getData());
        }
    }
    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a, Integer n){
        List<Integer> lista = new LinkedList<>();
        if(!a.isEmpty()){
            porniveles(a,n,lista);
        }
        return lista;
    }
    private void porniveles(GeneralTree<Integer> a, Integer n, List<Integer> lista){
        Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
        GeneralTree<Integer> actual;
        
        cola.enqueue(a);
        while(!cola.isEmpty()){
            actual = cola.dequeue();
            if(actual.getData() / 2 != 0 && actual.getData() > n){
                lista.add(actual.getData());
            }
            if(!actual.hasChildren()){
                List<GeneralTree<Integer>> hijos = actual.getChildren();
                for (GeneralTree<Integer> hijo: hijos){
                    cola.enqueue(hijo);
                }
            }
        }
    }
}
