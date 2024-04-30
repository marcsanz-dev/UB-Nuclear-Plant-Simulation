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
 */
public class PaginaIncidencies extends PaginaBitacola{
    ArrayList<String> incidencies;
    
    public PaginaIncidencies(int dia){
        incidencies = new ArrayList<String>();
        super.setDia(dia);
        he puesto un setter en bitacola del dia pq no entiendo pq el constructor de pagina incidencies en dades tiene como parametro "dia"
    }
    
    public void afegeixIncidencia(String descIncidencia){
        incidencies.add(descIncidencia);
    }
    
    public String toString(){
        String str = "# Pàgina Incidències\n" +
"- Dia: " + dia + "\n";
        Iterator<String> it = incidencies.iterator();
        while(it.hasNext()){
            String str_ac = it.next();
            str += "- Descripció Incidència: " + str_ac + "\n";
        }
        return str;
    }
}
