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
 */
public class BombaRefrigerant implements InBombaRefrigerant, Serializable{
    
    private int id;
    private boolean active, fora_serv;
    private VariableUniforme var_uni;
    
    public BombaRefrigerant(VariableUniforme var_uni_, int id_){
        id = id_;
        var_uni = var_uni_;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void activa()throws CentralUBException{
        if(!getForaDeServei())active = true;
        else throw new CentralUBException("La bomba no es pot activar perque es troba fora de servei");
    }

    @Override
    public void desactiva() {
        active = false;
    }

    @Override
    public boolean getActivat() {
        return active;
    }

    
    public void revisa(PaginaIncidencies p) {
        boolean prob = var_uni.seguentValor() > 20;
        fora_serv = !prob;
        active = prob;
        if(!prob)p.afegeixIncidencia("La bomba " + id + " ha quedat fora de servei.");
    }

    @Override
    public boolean getForaDeServei() {
        return fora_serv;
    }
    
    public String toString(){
        return "Id=" + id + ", Activat=" + active + ", Fora de servei=" + fora_serv + "\n";
    }
    
}
