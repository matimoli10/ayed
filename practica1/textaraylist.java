/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

/*
a
b
c
f
g
h
i

 */
import java.util.*;
public class textaraylist {
    public static boolean capicua(List tal) {
        boolean es = true;
        if(!tal.isEmpty()){
            int l = 0;
            int ult = tal.size()-1;
            while ((l != ult)&&(es != false)){
                if(tal.get(l).equals(tal.get(ult))){
                    l++;
                    ult--;
                }
                else {  
                    es = false;
                }
            }
        }
        return es;
    }
    
    public static String valores() {
        return "10 20 30 20 10";
    }
    
     public static void calcularsucesionrecursiva(List<Integer> l,int n){
        l.add(n);
        if(n > 1){
            if(n % 2 == 0){
                calcularsucesionrecursiva(l,n/2);
            }
            else {
                calcularsucesionrecursiva(l,3*n+1);        
            }
        }
    }
     
    public static List<Integer> calcularsucesion(int n){
      List<Integer> l = new LinkedList<>();
      calcularsucesionrecursiva(l,n);
      return l;
    }
    
    public static void invertirarraylist(ArrayList<Integer> ar){
         invertirarraylistrecursivo(ar, 0 , ar.size()-1);
    }
    
    public static void invertirarraylistrecursivo(ArrayList<Integer> ar, int inicio, int fin){
        if(inicio < fin){
            int aux;
            aux = ar.get(inicio);
            ar.set(inicio, ar.get(fin));
            ar.set(fin, aux);
            invertirarraylistrecursivo(ar,inicio+1,fin-1);
        }
    }
    
    public static int sumaelementos(List <Integer> l){
       return sumaelementosrecursivo(l,0);
    }
    
    public static int sumaelementosrecursivo(List <Integer> l,int pos){
        if(pos < l.size()){
            int suma;
           suma = l.get(pos);
           return suma + sumaelementosrecursivo(l,pos+1);
        }
        return 0;
    }
    
    public static ArrayList<Integer> combinarordenado(ArrayList<Integer> lista1, ArrayList<Integer> lista2){
       ArrayList<Integer> lista3 = new ArrayList<>();
       int indice1 = 0;
       int indice2 = 0;
       while((indice1 < lista1.size()) && (indice2 < lista2.size())){
          if(lista1.get(indice1) < lista2.get(indice2)){
              lista3.add(lista1.get(indice1));
              indice1++;
              System.out.println("if");
          }
          else 
             lista3.add(lista2.get(indice2));
             indice2++;
             System.out.println("else");
       }
       return lista3;
    }
    
    public static void main(String[] args) {
        String arg = valores();
        String[] arreglo = arg.split(" ");
        
        List<Integer> tal = new ArrayList<>();
        
        for (int i =0; i < arreglo.length;i++){ // preguntar como se podria hacer para cargar los argumentos (args)
            tal.add(Integer.parseInt(arreglo[i]));
        }
        for (int i = 0; i < tal.size();i++){
            System.out.println(tal.get(i));
        }
        System.out.println("  ");
        
        List<Integer> tll = new LinkedList<>();
        
        for(int i =0; i < arreglo.length ;i++){
            tll.add(Integer.parseInt(arreglo[i]));
        }
        for(int i =0; i < tll.size(); i++){
            System.out.println(tll.get(i));
        }
        System.out.println(" ");
        
        for(Integer i: tll){  // for-each
            System.out.println(i);
        }
        System.out.println("la secuencia almacenada en la lista es capicua? "+capicua(tal));
        System.out.println("---------------");
        
        System.out.println("ingrese un numero n");
        Scanner c = new Scanner(System.in);
        int n = c.nextInt(); // lo paso a 
        System.out.println("--------------------");
        List<Integer> l = calcularsucesion(n);
        Iterator<Integer> it = l.iterator();
        System.out.println("los valores son: ");
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("----------------------------");
        ArrayList<Integer> ar = new ArrayList<>(); 
        it = l.iterator();
        while (it.hasNext()){
           ar.add(it.next());
        }
        invertirarraylist(ar);
        it = ar.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("-----------------------");
        System.out.println("suma elementos");
        System.out.println(sumaelementos(l));
        ArrayList<Integer> lista1 = new ArrayList<Integer>();
        lista1.add(2);
        lista1.add(4);
        lista1.add(6);
        ArrayList<Integer> lista2 = new ArrayList<Integer>();
        lista2.add(1);
        lista2.add(3);
        lista2.add(5);
        List <Integer> lista3 = new ArrayList<Integer>();
        lista3 = combinarordenado(lista1, lista2);
        System.out.println("asi quedo la lista ");
        it = lista3.iterator();
        while(it.hasNext()){
            System.out.println(it.next());// preguntar sobre lo que se guarda 
        }
    }
}
