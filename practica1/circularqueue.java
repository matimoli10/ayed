/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

/**
 *
 * @author PC
 */
public class circularqueue <T> extends Queue<T> {
    public T shift(){
       if(!super.isEmpty()){
           T dato = super.dequeue();
           super.enqueue(dato);
           return dato;
       }
       else 
           return null;
    }
}
