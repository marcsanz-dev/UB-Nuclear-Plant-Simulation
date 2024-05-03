/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import prog2.vista.CentralUBException;


/**
 *
 * @author Usuario
 * 
 * La classe SistemaRefrigeracio implementa la interficie 
 * InCompnent, conté els diferents mètodes que 
 * s'implementen al sistema de refrigeració de la central i 
 * els diferents atributs que el defineixen.
 * 
 * 
 */
public class SistemaRefrigeracio implements InComponent, Serializable{
    
    private ArrayList<BombaRefrigerant> bombes;
    private boolean active;
    /**
     * Inicialitza l'array de bombes refrigerants 
     * del sistema de refrigeració
     */
    public SistemaRefrigeracio(){
        bombes = new ArrayList<BombaRefrigerant>();
    }
    /**
     * Retorna l'array de bombes refrigerants que té 
     * el sistema de refrigeració
     * @return ArrayList<BombaRefrigerant>
     */
    public ArrayList<BombaRefrigerant> getBombes(){
        return bombes;
    }
    /**
     * Afegeix la bomba donada per parametre a 
     * l'array de bombes del sistema de refrigeracio
     * @param bomba 
     */
    public void afegirBomba(BombaRefrigerant bomba){
        bombes.add(bomba);
    }
    
    /**
     * Activa el component. El mètode llançarà
     * una excepció si alguna bomba es troba
     * fora de servei.
     */
    @Override
    public void activa() throws CentralUBException{
        Iterator<BombaRefrigerant> it = bombes.iterator();
        while(it.hasNext()){
            BombaRefrigerant ac_bomba = it.next();
            ac_bomba.activa();
        }
    }

    /**
     * Desactiva el component.
     */
    @Override
    public void desactiva() {
        Iterator<BombaRefrigerant> it = bombes.iterator();
        while(it.hasNext()){
            BombaRefrigerant ac_bomba = it.next();
            ac_bomba.desactiva();
        }
    }

    /**
     * Revisa el component. Com a resultat de la revisió, podria podria sorgir 
     * una incidència que s'ha de registrar dins d'una pàgina d'incidències.
     * @param p Objecte de tipus PaginaIncidencies.
     */
    @Override
    public void revisa(PaginaIncidencies p) {
        Iterator<BombaRefrigerant> it = bombes.iterator();
        while(it.hasNext()){
            BombaRefrigerant ac_bomba = it.next();
            ac_bomba.revisa(p);
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
        return 125 * bombes.size();
    }

    /**
     * Calcula l'output del component donat l'input. La manera de calcular
     * l'output està descrita a la Figura 2 de l'enunciat de la pràctica.
     * @param input Input que rep el component.
     * @return float
     */
    @Override
    public float calculaOutput(float input) {
        int n = 0;
        Iterator<BombaRefrigerant> it = bombes.iterator();
        while(it.hasNext()){
            BombaRefrigerant ac_bomba = it.next();
            if(ac_bomba.getActivat()){
                n++;
            }
        }
        return Math.min(input,250*n);
    }
    /**
     * Retorna un String amb tota la informació de totes
     * les bombes refrigerants que té el sistema de 
     * refrigeració.
     * @return String
     */
    public String toString(){
        String str = "";
        Iterator<BombaRefrigerant> it = bombes.iterator();
        while(it.hasNext()){
            BombaRefrigerant ac_bomba = it.next();
            str += ac_bomba.toString();
        }
        return str;
    }
    
}
