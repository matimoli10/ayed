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
import practica1.Queue;
public class GeneralTree<T> {
    private T data;
    private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

    public GeneralTree() {
		
    }
    public GeneralTree(T data) {
	this.data = data; 
    }

    public GeneralTree(T data, List<GeneralTree<T>> children) {
	this.data = data;
	this.children = children;
    }	
    public T getData() {
	return data;
    }

    public void setData(T data) {
	this.data = data;
    }

    public List<GeneralTree<T>> getChildren() {
    	return this.children;
    }
	
    public void setChildren(List<GeneralTree<T>> children) {
        if (children != null){
       	    this.children = children;
        }
    }
	
    public void addChild(GeneralTree<T> child) {
	this.getChildren().add(child);
    }

    public boolean isLeaf() {
       	return !this.hasChildren();
    }
	
    public boolean hasChildren() {
        return !this.children.isEmpty();
    }
	
    public boolean isEmpty() {
        return this.data == null && !this.hasChildren();
    }

    public void removeChild(GeneralTree<T> child) {
	if (this.hasChildren()){
            children.remove(child);
        }
    }
	
    public int altura() {	 
        if(this.isLeaf()){
	    return 0;
        }
        else {
            int max = 0;
            int suma = 0;
            List<GeneralTree<T>> hijos = this.getChildren();
            for(GeneralTree<T> ar_hijo: hijos){
                suma = ar_hijo.altura() + 1;
                max = Math.max(max, suma);
            }
            return max;
        }
    }
	
    public int nivel(T dato){ 
        Queue<GeneralTree<T>> cola = new Queue <GeneralTree<T>>();
        cola.enqueue(this);
        cola.enqueue(null);
        int nivel = 0;
        boolean encontre = true;
        while(!cola.isEmpty()){
            GeneralTree<T> actual = cola.dequeue();
            if(actual.getData() != null){
                if(actual.getData() != dato){
                    encontre = false;
                }
                else {
                    Iterator <GeneralTree<T>> it = this.getChildren().iterator();
                    while(it.hasNext() && !actual.getData().equals(dato)){
                        cola.enqueue(this);
                    }    
                }
            }
            else{
                nivel++;
                cola.enqueue(null);
            }
        }
        if(encontre = true){
            return nivel;
        }
        else {
            return 0;
        }
    }

    public int ancho(){
        Queue<GeneralTree<T>> cola = new Queue<>();
        cola.enqueue(this);
        cola.enqueue(null);
        int cant = 0;
        int max = 0;
        while (!cola.isEmpty()){
            GeneralTree<T> actual = cola.dequeue();
            
            if(actual.getData() != null){
                cant++;
                for(GeneralTree<T> aux: actual.getChildren()){
                    cola.enqueue(aux);
                }
            }
            else{
                if(cant > max){
                    max = cant;
                }
                cant = 0;
                if(!cola.isEmpty()){   
                    cola.enqueue(null);
                }
            }
        }
        return max;
    }
    public boolean esAncestro(T a, T b){
        GeneralTree<T> subarbol = nodo(this,a);
        boolean result = false;
        if(subarbol != null && !subarbol.isEmpty()){//preguntar que difencia abria de usar esa condicion o (subarbol != null)
            subarbol = nodo(subarbol,b);
            if(subarbol != null){
                result = true;
            }
        }
        return result;
    }
    public GeneralTree<T> nodo(GeneralTree<T> arbol, T a){
        GeneralTree<T> subarbol = null;
        if(arbol.getData().equals(a)){//preguntar si la condicion puede ser asi (arbol.getData() == a) y en caso de que no se pueda preguntar por que 
            return subarbol = arbol;
        }
        else {
            if(arbol.hasChildren()){// si tiene hijos entra
                List <GeneralTree<T>> hijos = arbol.getChildren();// pone los hijos de arbol en la lista hijos
                for(GeneralTree<T> hijo: hijos){// hace un for each de los hijos  //preguntar si convienen hacerlo con un iterator ya que tendrias que cortar cuando encuentre el nodo 
                    subarbol = nodo(hijo,a);// llamado recursivo mandando el hijo
                }
            }
        }
        return subarbol;
    }
}
