/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.vista;

/**
 *
 * @author Marc Sanz
 * 
 * La classe IniciadorCentralUB conté main del 
 * nostre programa, per tal de inicialitzar el programa.
 * 
 */
public class IniciadorCentralUB {
    
    
    /**
     * Mètode que té com a funció iniciar l'execució del programa.
     * @param args Objecte de tipus Array d'Strings
     */
    public static void main(String[] args) {
        
        CentralUB central = new CentralUB();
     
        // Inicialitzem l'execució de la vista
        central.gestioCentralUB();
    }
    
}
