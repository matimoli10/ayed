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
import practica2.BinaryTree;
import java.util.*;
public class contadorarbol {
     private BinaryTree<Integer> a;
     
    public contadorarbol(BinaryTree<Integer> a) {
        this.a = a;
    }
     
     public static boolean espar(int num){
          if(num % 2 == 0){
             return true;
          }
          else {
             return false;
          }
     }
     
     public void numerospares(List<Integer> l, BinaryTree<Integer> a){
        if(espar(a.getData())){
            l.add(a.getData());
        }
        if(a.hasLeftChild()){
            numerospares(l,a.getLeftChild());
        }        
        if(a.hasRightChild()){
            numerospares(l,a.getRightChild());
        }     
        
     }
     
     public void numerosparesinorden(List<Integer> l, BinaryTree<Integer> a ){
         if(a.hasLeftChild()){
             numerosparesinorden(l, a.getLeftChild());
         }
         if(espar(a.getData())){
             l.add(a.getData());
         }
         if(a.hasRightChild()){
             numerosparesinorden(l, a.getRightChild());
         }
     }
     
     public void numerosparespostorden(List<Integer> l,BinaryTree<Integer> a){
         if(a.hasLeftChild()){
             numerosparespostorden(l, a.getLeftChild()); 
         }
         if(a.hasRightChild()){
             numerosparespostorden(l, a.getRightChild());
         }
         if(espar(a.getData())){
             l.add(a.getData());
         }
     }
     
     public static void mostrarlistas(List<Integer> l3){
         Iterator<Integer> it = l3.iterator();
         while(it.hasNext()){
             System.out.println(it.next());
         }
     }
     
     public static void main(String[] args) {
        List<Integer> l = new LinkedList<Integer>();
        List<Integer> l1 = new LinkedList<Integer>();
        List<Integer> l2 = new LinkedList<Integer>();
        BinaryTree<Integer> raiz = new BinaryTree<Integer>(4);
        BinaryTree<Integer> hijoiz = new BinaryTree<Integer>(3);
        BinaryTree<Integer> hijod = new BinaryTree<Integer>(6);
        
        hijoiz.addLeftChild(new BinaryTree<Integer>(2));
        hijoiz.addRightChild(new BinaryTree<Integer>(5));
        
        raiz.addLeftChild(hijoiz);
        raiz.addRightChild(hijod);
        
         contadorarbol c = new contadorarbol(raiz);
         c.numerospares(l,raiz);
         System.out.println("imprimir lista con los pares: ");
         mostrarlistas(l);
         System.out.println("---------------------------");
         System.out.println("imprimir lista de los pares acomodada en inorden: ");
         c.numerosparesinorden(l1, raiz);
         mostrarlistas(l1);
         System.out.println("---------------------------");
         System.out.println("imprimir lista de los pares acomodada en postorden: ");
         c.numerosparespostorden(l2, raiz);
         mostrarlistas(l2);
    }
}
