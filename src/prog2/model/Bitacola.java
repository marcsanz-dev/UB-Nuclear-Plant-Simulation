/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Bitacola implements InBitacola{
    
    ArrayList<PaginaBitacola> pagines;
    
    String prueba;
    
    public Bitacola(){
        pagines = new ArrayList<PaginaBitacola>();
    }
    
    public String toString(){
        String str = "";
        Iterator<PaginaBitacola> it = pagines.iterator();
        while(it.hasNext()){
            PaginaBitacola pag_ac = it.next();
            str += pag_ac.toString() + "\n";
        }
        return str;
    }

    @Override
    public void afegeixPagina(PaginaBitacola p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<PaginaIncidencies> getIncidencies() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
