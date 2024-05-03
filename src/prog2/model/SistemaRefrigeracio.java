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
    
    public SistemaRefrigeracio(){
        bombes = new ArrayList<BombaRefrigerant>();
    }
    
    public ArrayList<BombaRefrigerant> getBombes(){
        return bombes;
    }
    
    public void afegirBomba(BombaRefrigerant bomba){
        bombes.add(bomba);
    }
    
    @Override
    public void activa() throws CentralUBException{
        Iterator<BombaRefrigerant> it = bombes.iterator();
        while(it.hasNext()){
            BombaRefrigerant ac_bomba = it.next();
            ac_bomba.activa();
        }
    }

    @Override
    public void desactiva() {
        Iterator<BombaRefrigerant> it = bombes.iterator();
        while(it.hasNext()){
            BombaRefrigerant ac_bomba = it.next();
            ac_bomba.desactiva();
        }
    }

    @Override
    public void revisa(PaginaIncidencies p) {
        Iterator<BombaRefrigerant> it = bombes.iterator();
        while(it.hasNext()){
            BombaRefrigerant ac_bomba = it.next();
            ac_bomba.revisa(p);
        }
    }

    @Override
    public float getCostOperatiu() {
        return 125 * bombes.size();
    }

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
