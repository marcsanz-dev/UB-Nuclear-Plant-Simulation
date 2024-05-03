/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

import java.io.Serializable;
import prog2.vista.CentralUBException;

/**
 *
 * @author Marc Sanz
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
    /**
     * Modifica la temperatura del reactor
     * @param temp_ Objecte de tipus float
     */
    public void setTemp(float temp_){
        temp = temp_;
    }
    /**
     * Retorna la temperatura del reactor
     * @return float
     */
    public float getTemp(){
        return temp;
    }
    
    /**
     * Retorna un String amb tota la informació del reactor.
     * @return String
     */
    @Override
    public String toString() {
        return "Reactor{" + "temp=" + temp + ", active=" + active + '}';
    }
    
    /**
     * Activa el component. El mètode llançarà
     * una excepció si la temperatur és major que 1000 graus.
     */
    @Override
    public void activa() throws CentralUBException {
        if(temp > 1000) throw new CentralUBException("No es pot activar el reactor perque la seva temperatura supera els 1000 graus");
        else active = true;
    }

    /**
     * Desactiva el component.
     */
    @Override
    public void desactiva() {
        active = false;
    }

    /**
     * Revisa el component. Com a resultat de la revisió, podria podria sorgir 
     * una incidència que s'ha de registrar dins d'una pàgina d'incidències.
     * @param p Objecte de tipus PaginaIncidencies.
     */
    @Override
    public void revisa(PaginaIncidencies p) {
        if(temp > 1000){
            this.desactiva();
            p.afegeixIncidencia("El reactor ha superat la temperatura màxima i s'ha desactivat");
        }
    }

    /**
     * Obté el cost operatiu del component. El cost operatiu depèn de si el 
     * component està activat. Si no està activat el cost és zero.
     * Si està activat, tindrà un cost que es pot consultar a la Taula 1 de 
     * l'enunciat de la pràctica.
     * @return float
     */
    @Override
    public float getCostOperatiu() {
        if(active)return 30;
        return 0;
    }

    /**
     * Calcula l'output del component donat l'input. La manera de calcular
     * l'output està descrita a la Figura 2 de l'enunciat de la pràctica.
     * @param input Input que rep el component.
     * @return float
     */
    @Override
    public float calculaOutput(float input) {
        if(!active)return temp;
        else return temp + (100 - input) * 10;
    }
    
}
