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

public class ejercicio7 {

    /*
      d 
      e 
    */
    public static void mostrarlistas (List le, List lc) {
        Iterator<estudiante> it = le.iterator();
        while (it.hasNext()) {
            estudiante e0 = it.next();
            System.out.println(e0.toString());
        }

        it = lc.iterator();
        while (it.hasNext()) {
            estudiante e0 = it.next();
            System.out.println(e0.toString());
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        List<estudiante> le = new LinkedList<>();

        estudiante e1 = new estudiante("matias", "molineri", 1, "@", "sin cargar");
        estudiante e2 = new estudiante("martin", "mechoni", 1, "@", "sin cargar");
        estudiante e3 = new estudiante("german", "rodriguez", 2, "@", "sin cargar");
        le.add(e1);
        le.add(e2);
        le.add(e3);
        List<estudiante> lc = new LinkedList<>(le);

        Iterator<estudiante> it = le.iterator();// con el <estudiantes> le agrego el tipo, no es necesario 
        //Iterator it = le.iterator();
        
        mostrarlistas(le,lc);
        /*while (it.hasNext()) {
            estudiante e0 = it.next();
            System.out.println(e0.toString());
        }

        it = lc.iterator();
        while (it.hasNext()) {
            estudiante e0 = it.next();
            System.out.println(e0.toString());
        */
        Scanner s = new Scanner(System.in);
        System.out.println("ingrese el apellido del estudiante a modificar");
        String buscar = s.nextLine();
        boolean encontro = false;
        it = lc.iterator();
        while (it.hasNext() && (encontro != true)) { // tambien se puede escribir como !encontro
            estudiante e0 = it.next();
            if (e0.getApellido().equals(buscar)) {
                encontro = true;
                System.out.println("ingrese la nueva comision de el estudiante con apellido " + buscar);
                int comision = s.nextInt();
                e0.setComision(comision);
                System.out.println("--------------------\n");
                System.out.println(e0.toString());
                System.out.println("---------------------");
            }
        }
        if (!encontro) {
            System.out.println("no se a encontrado a nadie con ese apellido");
        } else {
            System.out.println("asi qeuda la lista luego de la modificacion");
            it = lc.iterator();
            while (it.hasNext()) {
                estudiante e0 = it.next();
                System.out.println(e0.toString());
            }
        }
        System.out.println("------------------------");
        mostrarlistas(le, lc);
        System.out.println("------------------------");
        System.out.println("------------------------");
        /* si modificas una lista la otra se ve afectada por el cambio,ya que no copia datos en si,
        sino que copia el puntero,por eso si se modifica una la otra se ve afectada */
        
        //estudiante e4 = new estudiante("martin", "mechoni", 1, "@", "sin cargar");
        estudiante e4 = new estudiante("francisco","colombo",2,"@","sin cargar");
        
        encontro = false;
        it = lc.iterator();
        while(it.hasNext()&&(encontro != true)){
            estudiante e0 = it.next();
            System.out.println("proceso");
            if(e0.equalsEstudiantes(e4)){ 
                System.out.println("entro ");
                encontro = true;
            }
        }
        if(encontro == true){
            System.out.println("el estudiante ingresado ya existe en la lista ");
        }
        else {
            lc.add(e4);
        }
        mostrarlistas(le, lc);
    }
}
