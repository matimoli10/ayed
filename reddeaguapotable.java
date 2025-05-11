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
import practica3.GeneralTree;
public class reddeaguapotable {
    private GeneralTree<Character> arbol;

    public reddeaguapotable(GeneralTree<Character> arbol) {
        this.arbol = arbol;
    }
    
    public double minimoCaudal(double caudal){
        double minimo = caudal;
        if(this.arbol != null){
            minimo = recorroarbol(arbol,caudal);
        }
        return minimo;
    }
    
    public double recorroarbol(GeneralTree<Character> arbol, double caudal){
        if(arbol.isLeaf()){
            return caudal;
        }
        else{
            double caudaldiv = (caudal/ arbol.getChildren().size());
            double min = 9999;
            for (GeneralTree<Character> hijo: arbol.getChildren()){
                double caudalhijo = recorroarbol(hijo,caudaldiv);
                if(caudalhijo < min){
                    min = caudalhijo;
                }
            }
            return min;
        }
    }
}
