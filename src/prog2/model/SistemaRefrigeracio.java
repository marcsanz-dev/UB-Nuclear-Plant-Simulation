/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

import java.util.ArrayList;
import java.util.Iterator;
import prog2.vista.CentralUBException;


/**
 *
 * @author Usuario
 */
public class SistemaRefrigeracio implements InComponent{
    
    ArrayList<BombaRefrigerant> bombes;
    boolean active;
    
    public void afegirBomba(BombaRefrigerant bomba){
        bombes.add(bomba);
    }
    
    @Override
    public void activa() throws CentralUBException{
        Iterator<BombaRefrigerant> it = bombes.iterator();
        while(it.hasNext()){
            BombaRefrigerant ac_bomba = it.next();
            if(!ac_bomba.getForaDeServei())
            ac_bomba.activa();
            else throw new CentralUBException("La bomba no es pot activar perque es troba fora de servei");
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
    
}
