/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

import java.io.Serializable;
import prog2.vista.CentralUBException;

/**
 *
 * @author Usuario
 * 
 * La classe Reactor implementa la interficie InCompnent, 
 * conté els diferents mètodes que 
 * s'implementen al reactor de la central i 
 * els diferents atributs que el defineixen.
 * 
 */
public class Reactor implements InComponent, Serializable{
    
    private float temp;
    private boolean active;
    
    public void setTemp(float temp_){
        temp = temp_;
    }
    
    public float getTemp(){
        return temp;
    }

    @Override
    public String toString() {
        return "Reactor{" + "temp=" + temp + ", active=" + active + '}';
    }
    
    @Override
    public void activa() throws CentralUBException {
        if(temp > 1000) throw new CentralUBException("No es pot activar el reactor perque la seva temperatura supera els 1000 graus");
        else active = true;
    }

    @Override
    public void desactiva() {
        active = false;
    }

    @Override
    public void revisa(PaginaIncidencies p) {
        if(temp > 1000){
            this.desactiva();
            p.afegeixIncidencia("El reactor ha superat la temperatura màxima i s'ha desactivat");
        }
    }

    @Override
    public float getCostOperatiu() {
        if(active)return 30;
        return 0;
    }

    @Override
    public float calculaOutput(float input) {
        if(!active)return temp;
        else return temp + (100 - input) * 10;
    }
    
}
