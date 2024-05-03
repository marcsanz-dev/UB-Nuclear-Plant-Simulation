/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Joel Moreno
 * 
 * La classe Bitacola implementa la interficie InBitacola,
 * crea un ArrayList de Pagines Bitacoles on es 
 * guardarà tota la informació que passi en la Central dia a dia.
 * 
 */
public class Bitacola implements InBitacola, Serializable{
    
    private ArrayList<PaginaBitacola> pagines;
    
    public Bitacola(){
        pagines = new ArrayList<PaginaBitacola>();
    }
    
    /**
     * Afegeix una pagina a la bitàcola.
     * @param p Objecte de tipus PaginaBitacola
     */
    @Override
    public void afegeixPagina(PaginaBitacola p) {
        pagines.add(p);
    }
    
    
    /**
     * Obté una llista amb totes les pàgines d'incidències contingudes dins 
     * de la bitàcola
     * @return List
     */
    @Override
    public List<PaginaIncidencies> getIncidencies() {
        ArrayList<PaginaIncidencies> incidencies = new ArrayList<PaginaIncidencies>();
        Iterator<PaginaBitacola> it = pagines.iterator();
        while(it.hasNext()){
            PaginaBitacola pag_ac = it.next();
            if(pag_ac instanceof PaginaIncidencies){
                incidencies.add((PaginaIncidencies)pag_ac);
            }
        }
        return incidencies;
    }
    
    /**
     * Retorna un String amb tota la informació de totes les pàgines que te la 
     * bitacola
     * @return String
    */
    public String toString(){
        String str = "";
        Iterator<PaginaBitacola> it = pagines.iterator();
        while(it.hasNext()){
            PaginaBitacola pag_ac = it.next();
            str += pag_ac.toString() + "\n";
        }
        return str;
    }
    
}
