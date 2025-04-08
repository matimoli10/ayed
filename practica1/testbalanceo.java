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
public class testbalanceo {
    public static boolean esbalanceado(String s){
        Stack<Character> pila = new Stack<>();
        
        for (char c: s.toCharArray()){
            if( c == '(' || c == '[' || c == '{'){
                 pila.push(c);
            }
            else {
                 if(c == ')' || c == ']' || c == '}'){
                     if(pila.isEmpty()){
                          return false;
                     }
                 }
                 char top = pila.pop();
                 if((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{') ){
                     return false;
                 }
            }
        }
        return pila.isEmpty(); 
    }
}
