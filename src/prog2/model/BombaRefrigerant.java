/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

/**
 *
 * @author Usuario
 */
public class BombaRefrigerant implements InBombaRefrigerant{
    
    int id;
    boolean active, fora_serv;
    VariableUniforme var_uni;
    
    public BombaRefrigerant(VariableUniforme var_uni_, int id_){
        id = id_;
        var_uni = var_uni_;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void activa() throws Object {
        active = true;
    }

    @Override
    public void desactiva() {
        active = false;
    }

    @Override
    public boolean getActivat() {
        return active;
    }

    @Override
    public void revisa(Object p) {
        int n = var_uni.seguentValor();
        fora_serv = !(n > 20);
    }

    @Override
    public boolean getForaDeServei() {
        return fora_serv;
    }
    
    public String toString(){
        return "Id=" + id + ", Activat=" + active + ", Fora de servei=" + fora_serv;
    }
    
}
