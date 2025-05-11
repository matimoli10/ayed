//parcial primera fecha 15/6/2024 tema 1 
package practica3;

import java.util.*;
import practica3.GeneralTree;

public class parcial {
    private GeneralTree<Integer> arbol;
    
    public List<Integer> camino(int num){
        List<Integer> lista = new LinkedList <>();
        List<Integer> listaaux = new LinkedList<>();
        if(arbol != null && !arbol.isEmpty()){
            recorroarbol(arbol,lista,listaaux,num);
        }
        return lista;
    }
    
    private void recorroarbol(GeneralTree<Integer>arbol, List <Integer> lista, List<Integer> listaaux, int num){
        boolean cumple = true;
        listaaux.add(arbol.getData());
        if(arbol.hasChildren()){
            Iterator <GeneralTree<Integer>> it = arbol.getChildren().iterator();
            while((cumple) && (lista == null) && (it.hasNext())){
                if(it.next().getChildren().size() >= num){
                    recorroarbol(it.next(),lista,listaaux,num);
                }
                else{
                    cumple = false;
                }
            }
            listaaux.remove(listaaux.size() - 1);
        }
        else {
            lista.addAll(listaaux);
        }
    }
}
