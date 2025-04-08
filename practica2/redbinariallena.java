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
public class redbinariallena {
    private BinaryTree<Integer> a;

    public redbinariallena(BinaryTree<Integer> a) {
        this.a = a;
    }
    
    private int retardoenvio(BinaryTree<Integer> a){
        int left = 0;
        int right = 0;
        if(a.isEmpty()){
            return 0;
        }
        else if(a.isLeaf()){
            return a.getData();
        }
        else{
           if(a.hasLeftChild()){
              left = retardoenvio(a.getLeftChild());
           }
           if(a.hasRightChild()){
              right = retardoenvio(a.getRightChild());
           }
           if(left > right){
              return a.getData() + left;
           }
           else {
              return a.getData() + right;
           }
        }  
    }
    public int retardoEnvio(){
          return retardoenvio(a);
    }
    public static void main(String[] args) {
        BinaryTree<Integer> raiz = new BinaryTree<>(5);
        BinaryTree<Integer> hi = new BinaryTree<>(3);
        BinaryTree<Integer> hd = new BinaryTree<>(7);
        
        hi.addLeftChild(new BinaryTree<Integer>(2));
        hi.addRightChild(new BinaryTree<Integer>(4));
        hd.addLeftChild(new BinaryTree<Integer>(6));
        hd.addRightChild(new BinaryTree<Integer>(8));
        
        raiz.addLeftChild(hi);
        raiz.addRightChild(hd);
        
        redbinariallena red = new redbinariallena(raiz);
        System.out.println("el mayor retardo posible es: " + red.retardoEnvio());
    }
}
