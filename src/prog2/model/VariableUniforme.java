/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author dortiz
 * 
 * La classe VariableUniforme conté el seu 
 * constructor i un mètode propi.
 * 
 */
public class VariableUniforme implements Serializable{
    private Random random;
    
    
    /**
     * Inicialitza l'atribut random
     * @param seed Objecte de tipus long
     */
    public VariableUniforme(long seed) {
        this.random = new Random(seed);
    }
    
    
    /**
     * Genera un valor random en l'interval 1-100
     * @return int
     */
    public int seguentValor() {
        return random.nextInt(100);
    }
}
