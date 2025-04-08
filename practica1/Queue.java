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
import java.util.*;
public class Queue<T> extends sequence{
    protected  List<T> data;
    
    public Queue() {
       this.data = new ArrayList <T>();
    }
    
    public void enqueue (T dato){
        data.add(dato);
    }
    public T dequeue(){
          return this.data.remove(0);
    }
    public T head(){
       return data.get(0);
    }
    public boolean isEmpty(){
       return data.size()== 0;
    }
    
    public int size(){
        return data.size();
    }
    public String toString(){
        int pos =0 ;
        String acumular = "";
        while( pos < data.size()){
            acumular = acumular + data.get(pos)+" ";
            pos++;
        }         
        return acumular;
    }
}
