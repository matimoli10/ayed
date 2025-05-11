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
public class AreaEmpresa {
    private String identificacion ; 
    private int tiempo;
    
    public AreaEmpresa(String identificacion, int tiempo) {
        this.identificacion = identificacion;
        this.tiempo = tiempo;
    }
    
    public String getidentificacion(){
        return identificacion;
    }
    
    public void setidentificacion(String idem){
        this.identificacion = idem;
    }

    public int gettiempo(){
        return tiempo;
    }
    
    public void settiempo(int tiempo){
        this.tiempo = tiempo;
    }

    public AreaEmpresa() {
    }
    
    
}
