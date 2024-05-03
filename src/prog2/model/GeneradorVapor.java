/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

import java.io.Serializable;

/**
 *
 * @author Usuario
 * 
 * La classe GeneradorVapor implementa la interficie 
 * InCompnent, conté els diferents mètodes que 
 * s'implementen al generador de vapor de la central i 
 * els diferents atributs que el defineixen.
 * 
 */
public class GeneradorVapor implements InComponent, Serializable{
    
    private boolean active;

    @Override
    public void activa() {
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
        if(active)return 25;
        else return 0;
    }

    @Override
    public float calculaOutput(float input) {
        float n = (float) (input * 0.8);
        if(!active)return 30;
        else return n;
    }
    
}
