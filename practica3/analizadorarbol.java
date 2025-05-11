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
import practica1.Queue;

public class analizadorarbol {
    public double devolverMaximoPromedio (GeneralTree<AreaEmpresa> a){
        Queue <GeneralTree<AreaEmpresa>> cola = new Queue<>();
        cola.enqueue(a);
        cola.enqueue(null);
        int suma = 0;
        double max = -1;
        int cant = 0;
        double prom = 0;
        while(!cola.isEmpty()){
            GeneralTree<AreaEmpresa> act = cola.dequeue();
            if(act != null){
                if(max == -1){//para evaluar la raiz
                    max = act.getData().gettiempo();
                    System.out.println(max);
                }
                for(GeneralTree<AreaEmpresa> hijo : act.getChildren()){
                    cola.enqueue(hijo);
                    System.out.println("encole a: "+ hijo.getData().getidentificacion());
                    cant++;
                    suma = suma + hijo.getData().gettiempo();
                }
            }
            else{
                if(!cola.isEmpty()){
                    System.out.println(suma);
                    System.out.println(cant);
                    prom = suma / cant;
                    System.out.println(prom);
                    cant = 0;
                    suma = 0;
                    if(prom > max){
                        max = prom;
                    }
                    cola.enqueue(null);
                }
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        
        List<GeneralTree<AreaEmpresa>> lista2 = new LinkedList<>();
        lista2.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("a",4)));
        lista2.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("b",7)));
        lista2.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("c",5)));
        GeneralTree<AreaEmpresa> hr1 = new GeneralTree <AreaEmpresa>(new AreaEmpresa("j",13),lista2);//engancho la lista con los hijos al padre
        
        List <GeneralTree<AreaEmpresa>> lista3 = new LinkedList<>();
        lista3.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("d",6)));
        lista3.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("e",10)));
        lista3.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("f",18)));
        GeneralTree<AreaEmpresa> hr2 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("k",25),lista3);
        
        List <GeneralTree<AreaEmpresa>> lista4 = new LinkedList<GeneralTree<AreaEmpresa>>();//pongo el tipo cuando creo la lista para que se vea como se hace ahun que no es necesario
        lista4.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("g",9)));
        lista4.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("h",12)));
        lista4.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("i",19)));
        GeneralTree<AreaEmpresa> hr3 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("l",10),lista4); 
        
        List<GeneralTree<AreaEmpresa>> lista = new LinkedList<>();
        lista.add(hr1);
        lista.add(hr2);
        lista.add(hr3);
        GeneralTree<AreaEmpresa> raiz = new GeneralTree <>(new AreaEmpresa("m",14),lista);
        
        analizadorarbol a = new analizadorarbol();
        System.out.println("el mayor promedio es "+ a.devolverMaximoPromedio(raiz));
    }
}
