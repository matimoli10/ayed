// parcial recuperatorio 7/12/2024 tema 1
package practica3;


import java.util.*;
import practica3.GeneralTree;

public class parcial_estrategia {
    
    public List<compuesto> mejorestrategia(GeneralTree<compuesto> arbol){
        List<compuesto> lista = new LinkedList<>();
        List <compuesto> listaaux = new LinkedList<>();
        int min = 9999;
        int cant = 0;
        if(!arbol.isEmpty()){
            recorroarbol(arbol,lista,listaaux,min,cant);
            /*for(GeneralTree<compuesto> hijo: arbol.getChildren()){
                min = recorroarbol(hijo,lista,listaaux,min,cant);
               
            }*/
        }
        return lista;
    }
   /* private int recorroarbol(GeneralTree<compuesto> arb, List<compuesto> lista, List<compuesto> listaaux,int min,int cant){
        cant += arbol.getData().getVueltas() * arbol.getData().getComp();
        if(arb.hasChildren()){
            for (GeneralTree<compuesto> hijo: arb.getChildren()){
                listaaux.add(hijo.getData());
                cant += 10;
                min = recorroarbol(hijo,lista,listaaux,min,cant);
            }
        }
         else {
            listaaux.add(arbol.getData());
            if(min > cant){
                lista.clear();
                lista.addAll(listaaux);
                min = cant;
                listaaux.clear();
            }
        }
        return min;
    }*/
    private void recorroarbol(GeneralTree<compuesto> arbol, List<compuesto> lista,List<compuesto> listaaux,int min,int cant){
        cant += arbol.getData().getVueltas() * arbol.getData().getComp();
        if(arbol.hasChildren()){
            for(GeneralTree<compuesto> hijo: arbol.getChildren()){
                listaaux.add(hijo.getData());
                cant += 10;
                recorroarbol(arbol,lista,listaaux,min,cant);
            }
        }
        else {
            listaaux.add(arbol.getData());
            if(min > cant){
                lista.clear();
                lista.addAll(listaaux);
                min = cant;
            }
        }
    }
}
