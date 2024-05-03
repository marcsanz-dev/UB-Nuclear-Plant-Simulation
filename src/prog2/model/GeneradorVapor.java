/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

import java.io.Serializable;

/**
 *
 * @author Joel Moreno
 * 
 * La classe GeneradorVapor implementa la interficie 
 * InCompnent, conté els diferents mètodes que 
 * s'implementen al generador de vapor de la central i 
 * els diferents atributs que el defineixen.
 * 
 */
public class GeneradorVapor implements InComponent, Serializable{
    
    private boolean active;

    /**
     * Activa el component.
     */
    @Override
    public void activa() {
        active = true;
    }

    /**
     * Desactiva el component.
     */
    @Override
    public void desactiva() {
        active = false;
    }

    /**
     * Revisa el component.
     * @param p Objecte de tipus PaginaIncidencies.
     */
    @Override
    public void revisa(PaginaIncidencies p) {}

    /**
     * Obté el cost operatiu del component. El cost operatiu depèn de si el 
     * component està activat. Si no està activat el cost és zero.
     * Si està activat, tindrà un cost que es pot consultar a la Taula 1 de 
     * l'enunciat de la pràctica.
     * @return float
     */
    @Override
    public float getCostOperatiu() {
        if(active)return 25;
        else return 0;
    }

    /**
     * Calcula l'output del component donat l'input. La manera de calcular
     * l'output està descrita a la Figura 2 de l'enunciat de la pràctica.
     * @param input Input que rep el component.
     * @return float
     */
    @Override
    public float calculaOutput(float input) {
        float n = (float) (input * 0.8);
        if(!active)return 30;
        else return n;
    }
    
}
