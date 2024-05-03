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
 * La classe BombaRefrigerant implementa la interficie 
 * InBombaRefrigerant, conté els diferents mètodes que 
 * s'implementen a les Bombes refrigerants de la central i 
 * els diferents atributs que les defineixen.
 * 
 */
public class BombaRefrigerant implements InBombaRefrigerant, Serializable{
    
    private int id;
    private boolean active, fora_serv;
    private VariableUniforme var_uni;
    
    /**
     *Inicialitza els atributs de bomba refrigerant
     * @param var_uni Objecte de tipus VariableUniforme
     * @param id_ Objecte de tipus int
    */
    public BombaRefrigerant(VariableUniforme var_uni_, int id_){
        id = id_;
        var_uni = var_uni_;
    }
    
    /**
     * Retorna l'identificador numèric de la bomba refrigerant.
     * @return int
     */
    @Override
    public int getId() {
        return id;
    }
    
    /**
     * Activa la bomba refrigerant. El mètode llançarà una excepció si la bomba 
     * està fora de servei i en aquest cas la bomba no es podrà activar.
     */
    @Override
    public void activa()throws CentralUBException{
        if(!getForaDeServei())active = true;
        else throw new CentralUBException("La bomba no es pot activar perque es troba fora de servei");
    }

    /**
     * Desactiva la bomba refrigerant.
     */
    @Override
    public void desactiva() {
        active = false;
    }

    /**
     * Retorna true si la bomba refrigerant està activada.
     * @return boolean
     */
    @Override
    public boolean getActivat() {
        return active;
    }

    /**
     * Revisa la bomba refrigerant. Es farà servir l'objecte de tipus 
     * VariableUniforme per determinar si la bomba es queda fora de servei. En 
     * cas afirmatiu, s'haurà de registrar la situació dins d'una pàgina 
     * d'incidències.
     * @param p Objecte de tipus PaginaIncidencies per a registrar si la bomba 
     * es queda fora de servei.
     */
    public void revisa(PaginaIncidencies p) {
        boolean prob = var_uni.seguentValor() > 20;
        fora_serv = !prob;
        active = prob;
        if(!prob)p.afegeixIncidencia("La bomba " + id + " ha quedat fora de servei.");
    }

    /**
     * Retorna true si la bomba refrigerant està fora de servei.
     * @return boolean
     */
    @Override
    public boolean getForaDeServei() {
        return fora_serv;
    }
    /**
     * Retorna una cadena amb tota la informació de la bomba refrigerant.
     * @return String 
     */
    public String toString(){
        return "Id=" + id + ", Activat=" + active + ", Fora de servei=" + fora_serv + "\n";
    }
    
}
