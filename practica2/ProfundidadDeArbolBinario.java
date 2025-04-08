/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

/**
 *
 * @author PC
 */
import practica1.Queue;
import practica2.BinaryTree;
import java.util.*;

public class ProfundidadDeArbolBinario {
    private BinaryTree<Integer> a;

    public ProfundidadDeArbolBinario(BinaryTree<Integer> a) {
        this.a = a;
    }
    
    public int sumadeelementos(int p){
        if(a.isEmpty()){
           return 0;
        }
        else {
           BinaryTree<Integer> arbol = null;
           Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
           cola.enqueue(a);
           cola.enqueue(null);
           int suma = 0;
           int level = 0;
           while(!cola.isEmpty() && level <= p){
              arbol = cola.dequeue();
              if(arbol != null){
                  if(p == level){
                      suma += arbol.getData();
                  }
                  if(arbol.hasLeftChild()){
                      cola.enqueue(arbol.getLeftChild());
                  }
                  if(arbol.hasRightChild()){
                      cola.enqueue(arbol.getRightChild());
                  }
              }
              else if(!cola.isEmpty()){
                  System.out.println();
                  cola.enqueue(null);
                  level++;
              }
           }
           return suma;
        }
    }
    
    public static void main(String[] args) {
        BinaryTree<Integer> ab = new BinaryTree<Integer>(40);
		BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(25);
		BinaryTree<Integer> hijoDerecho = new BinaryTree<Integer>(78);
		BinaryTree<Integer> TreintaDos = new BinaryTree<Integer>(32);
		
		hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(10));
		hijoIzquierdo.addRightChild(TreintaDos);
		TreintaDos.addRightChild(new BinaryTree <Integer>(66));
		
		hijoDerecho.addLeftChild(new BinaryTree<Integer>(20));
		hijoDerecho.addRightChild(new BinaryTree<Integer>(50));
		
		ab.addLeftChild(hijoIzquierdo);
		ab.addRightChild(hijoDerecho);
		
		System.out.println("Por niveles");
		ab.printLevelTraversal();
		
		System.out.println("------------------------");
		
		ProfundidadDeArbolBinario profundidad = new ProfundidadDeArbolBinario(ab);
		System.out.print(profundidad.sumadeelementos(2));
    }
}
//revisar