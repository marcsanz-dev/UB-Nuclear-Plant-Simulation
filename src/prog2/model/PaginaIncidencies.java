/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Usuario
 * 
 * La classe PaginaIncidencies hereda de PaginaBitacola, 
 * conté el seu propi constructor, el mètode per afegir 
 * incidencies i el seu toString.
 * 
 */
public class PaginaIncidencies extends PaginaBitacola{
    private ArrayList<String> incidencies;
    
    
    /**
     * Inicialitza el ArrayList d'incidencies de la Pagina d'Incidencies
     * @param dia Objecte de tipus int
     */
    public PaginaIncidencies(int dia){
        super(dia);
        incidencies = new ArrayList<String>();
    }
    
    
    /**
     * Afegeix l'incidencia que rep com a paraetre a la llista d'incidencies
     * @param descIncidencia Objecte de tipus String
     */
    public void afegeixIncidencia(String descIncidencia){
        incidencies.add(descIncidencia);
    }
    
    
    /**
     * Retorna un String amb la informacio de la pagina d'incidencies
     * @return String
     */
    public String toString(){
        String str = "# Pàgina Incidències\n" +
"- Dia: " + super.getDia() + "\n";
        Iterator<String> it = incidencies.iterator();
        while(it.hasNext()){
            String str_ac = it.next();
            str += "- Descripció Incidència: " + str_ac + "\n";
        }
        return str;
    }
}
