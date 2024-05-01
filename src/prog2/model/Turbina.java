/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

/**
 *
 * @author Usuario
 */
public class Turbina implements InComponent{
    
    private boolean active;

    @Override
    public void activa(){
        active = true;
    }

    @Override
    public void desactiva() {
        active = false;
    }

    @Override
    public void revisa(PaginaIncidencies p) {}

    @Override
    public float getCostOperatiu() {
        if(active)return 20;
        else return 0;
    }

    @Override
    public float calculaOutput(float input) {
        if(active && input >= 100) return input * 2;
        else return 0;
    }
    
}
