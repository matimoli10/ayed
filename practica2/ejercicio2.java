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
public class ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BinaryTree<Integer> raiz = new BinaryTree<Integer>(20);
        BinaryTree<Integer> hijoizquierdo = new BinaryTree<Integer>(10);
        BinaryTree<Integer> hijoderecho = new BinaryTree<Integer>(30);
        BinaryTree<Integer> relleno =  new BinaryTree<Integer>(25);   
        
        hijoizquierdo.addLeftChild(new BinaryTree<Integer>(5));
        hijoizquierdo.addRightChild(new BinaryTree<Integer>(15));
        hijoderecho.addLeftChild(relleno);
        hijoderecho.addRightChild(new BinaryTree<Integer>(40));
        relleno.addRightChild(new BinaryTree<Integer>(23));
        
        raiz.addLeftChild(hijoizquierdo);
        raiz.addRightChild(hijoderecho);
        
        System.out.println("arbol inorden");
        raiz.printInOrden();
        System.out.println("------------------------");
        System.out.println("cantidad de hojas del arbol es : "+ raiz.contarHojas());
        System.out.println("--------------------------  ");
        System.out.println("el arbol en espejo quedaria: ");
        BinaryTree<Integer> arbolespejo = raiz.espejo();
        arbolespejo.printInOrden();
        System.out.println("------------------------");
        System.out.println("arbol por niveles ");
        raiz.printLevelTraversal();
        System.out.println("----------------");
        System.out.println("arbol entre niveles");
        raiz.entreNiveles(0, 3);
    }
    
}
