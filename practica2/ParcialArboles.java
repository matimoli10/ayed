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
public class ParcialArboles {
    private BinaryTree<Integer> a;

    public ParcialArboles(BinaryTree<Integer> a) {
        this.a = a;
    }
    
    private int recorrersubarbol(BinaryTree<Integer> subarbol){
        int canthijos = 0;
        if(subarbol.hasLeftChild()){
            canthijos += recorrersubarbol(subarbol.getLeftChild());
        }
        if(subarbol.hasRightChild()){
            canthijos += recorrersubarbol(subarbol.getRightChild());
        }
        if((subarbol.hasLeftChild()&& !subarbol.hasRightChild()) || (!subarbol.hasLeftChild() && subarbol.hasRightChild())){
            canthijos++;
        }
        return canthijos;
    }
    
    private boolean evaluo (BinaryTree<Integer> subarbol){
        int izq = 0;
        int der = 0;
        if(subarbol.hasLeftChild()){
            izq = recorrersubarbol(subarbol.getLeftChild());
        }
        else {
            izq = -1;
        }
        if(subarbol.hasRightChild()){
            der = recorrersubarbol(subarbol.getRightChild());
        }
        else{
            der = -1;
        }
        if(izq > der){
            return true;
        }
        else {
            return false;
        }
    }
    
    private BinaryTree<Integer> buscarenarbol (int num, BinaryTree<Integer> a){
        if(a.getData() == num){
            return a;
        }
        BinaryTree<Integer> arbolnuevo = null;
        if(a.hasLeftChild()){
            arbolnuevo = buscarenarbol(num,a.getLeftChild());
        }
        if(a.hasRightChild() && arbolnuevo == null){
            arbolnuevo = buscarenarbol(num,a.getRightChild());
        }
        return arbolnuevo;
    }
    
    public boolean isLeftTree(int num){
        boolean cumple = false;
        if(a != null){
            BinaryTree<Integer> subarbol = buscarenarbol(num,a);
            if(subarbol != null){
                cumple = evaluo(subarbol);
            }
        }
    return cumple;
    }
    public boolean comparararboles(BinaryTree<Integer> arbol1,BinaryTree<Integer> arbol2){
        boolean cumple = true;
        if(arbol1.hasLeftChild() && arbol2.hasLeftChild()){
            cumple = cumple && comparararboles(arbol1.getLeftChild(),arbol2.getLeftChild());   
        }
        else{  
            if(arbol1.hasLeftChild() && !arbol2.hasLeftChild()){// si arbol 1 tiene un HI y arbol 2 no tiene HI quiere decir que arbol 1
                cumple = cumple && false;//no es prefijo de arbol 2, ya que el arbol 1 tendria datos que no estan en el arbol 2 
            }
        }
        if(arbol1.hasRightChild() && arbol2.hasRightChild()){
            cumple = cumple && comparararboles(arbol1.getRightChild(),arbol2.getRightChild());
        }
        else{
            if(arbol1.hasRightChild() && !arbol2.hasRightChild()){
                cumple = cumple && false;
            }
        }
        if(arbol1.getData() == arbol2.getData()){
            cumple = cumple && true;
        }
        else {
            cumple = cumple && false;
        }
        return cumple;
    }
    
    public boolean esprefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2){
        boolean cumple = false;
        if(arbol1 != null && arbol2 != null){
            cumple = comparararboles(arbol1,arbol2);
        }
        return cumple;
    }
    
    public static void main(String[] args) {
        
        //           2
        //         /   \
        //        7    -5
        //       / \   / 
        //      23 6  19
        //     /  / \   \
        //   -3  55 11   4
        //              /
        //             18
        
        BinaryTree<Integer> raiz =  new BinaryTree<>(2);
        BinaryTree<Integer> hi = new BinaryTree<>(7);
        BinaryTree<Integer> hd = new BinaryTree<>(-5);
        BinaryTree<Integer> hii = new BinaryTree<>(23);
        BinaryTree<Integer> hid = new BinaryTree<>(6);
        BinaryTree<Integer> hdi = new BinaryTree<>(19);
        BinaryTree<Integer> hdid = new BinaryTree<>(4);
        
        hii.addLeftChild(new BinaryTree<Integer>(-3));
        hid.addLeftChild(new BinaryTree<Integer>(55));
        hid.addRightChild(new BinaryTree<Integer>(11));
        hi.addLeftChild(hii);
        hi.addRightChild(hid);
        
        hdid.addLeftChild(new BinaryTree<Integer>(18));
        hdi.addRightChild(hdid);
        hd.addLeftChild(hdi);
        
        raiz.addLeftChild(hi);
        raiz.addRightChild(hd);
        
        //BinaryTree<Integer> vacio = null; // sirve para probar si le mandamos un arbol en null que devuelva false 
        
        ParcialArboles arbol = new ParcialArboles(raiz);
        int num = 7;
        System.out.println("el numero a buscar es: "+ num);
        System.out.println(arbol.isLeftTree(num));
        
        // punto 9 comparamos con el arbol del punto 8 con menos valores
        
        //           2
        //         /   \
        //        7    -5
        //         \   / 
        //         6  19
        
        BinaryTree<Integer> raiz2 = new BinaryTree<>(2);
        BinaryTree<Integer> hi2 = new BinaryTree<>(7);
        BinaryTree<Integer> hd2 = new BinaryTree<>(-5);
        BinaryTree<Integer> hid2 = new BinaryTree<>(6);
        BinaryTree<Integer> hdi2 = new BinaryTree<>(19);
        
        hi2.addRightChild(hid2);
        hd2.addLeftChild(hdi2);
        raiz2.addLeftChild(hi2);
        raiz2.addRightChild(hd2);
        
        System.out.println(arbol.esprefijo(raiz2,raiz));
    }
}
