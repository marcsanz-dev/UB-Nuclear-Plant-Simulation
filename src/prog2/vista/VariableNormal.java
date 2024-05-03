/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.vista;

import java.util.Random;

/**
 *
 * @author dortiz
 * 
 * La classe VariableUniforme conté el seu 
 * constructor i un mètode propi.
 */
public class VariableNormal {
    private Random random;
    private float mean;
    private float standardDeviation;
    
    
    /**
     * Inicialitza els atributs de la classe VariableNormal
     * @param mean Objecte de tipus float
     * @param standardDeviation Objecte de tipus float
     * @param seed Objecte de tipus long
     */
    public VariableNormal(float mean, float standardDeviation, long seed) {
        this.mean = mean;
        this.standardDeviation = standardDeviation;
        this.random = new Random(seed);
    }
    
    
    /**
     * Retorna un valor en l'interval 1-100
     * @return float
     */
    public float seguentValor() {
        return (float) mean + standardDeviation * (float) random.nextGaussian();
    }

}
