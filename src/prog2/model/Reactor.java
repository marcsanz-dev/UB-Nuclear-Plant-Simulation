/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

/**
 *
 * @author Usuario
 */
public class Reactor implements InComponent{
    
    float temp;
    boolean active;
    
    public void setTemp(float temp_){
        temp = temp_;
    }
    
    public float getTemp(){
        return temp;
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
    public void revisa(PaginaIncidencies p) {
        hazlo
    }

    @Override
    public float getCostOperatiu() {
        if(active)return 30;
        return 0;
    }

    @Override
    public float calculaOutput(float input) {
        if(!active)return temp;
        else return temp + (100 - input) * 10;
    }
    
}
