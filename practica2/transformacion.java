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
public class transformacion {
    private BinaryTree<Integer> a;

    public transformacion(BinaryTree<Integer> a) {
        this.a = a;
    }
    
    public BinaryTree<Integer> suma(){
        if(!a.isEmpty() && a.getData() != null){
            suma(a);
            return a;
        }
        else{
            System.out.println("no se modifico el arbol ");
            return null;    
        }
    }
    
    private int suma(BinaryTree<Integer> a) {
        int sumai = 0;
        int sumad = 0;
        int act = 0;
        if(a.hasLeftChild()){
            sumai = suma(a.getLeftChild());
        }
        if(a.hasRightChild()){
            sumad = suma(a.getRightChild());           
        }
        act = a.getData();
        a.setData(sumai + sumad);
        return act + sumai + sumad;
    }
    
    public static void main(String[] args) {
        BinaryTree<Integer> raiz = new BinaryTree<Integer>(1);
        BinaryTree<Integer> hi = new BinaryTree<Integer>(2);
        BinaryTree<Integer> hd = new BinaryTree<Integer>(3);
        BinaryTree<Integer> relleno = new BinaryTree<Integer>(5);
        
        hi.addRightChild(new BinaryTree<Integer>(4));
        relleno.addLeftChild(new BinaryTree<Integer>(7));
        relleno.addRightChild(new BinaryTree<Integer>(8));
        hd.addLeftChild(relleno);
        hd.addRightChild(new BinaryTree<Integer>(6));
        
        raiz.addLeftChild(hi);
        raiz.addRightChild(hd);
        
        raiz.printLevelTraversal();
        
        System.out.println("----------------------------");
        transformacion tran = new transformacion(raiz);
        
        tran.suma();
        raiz.printLevelTraversal();
    }
}
   