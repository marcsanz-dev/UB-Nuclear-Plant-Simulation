/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.vista;

/**
 *
 * @author Joel Moreno
 * 
 * La classe CentralUBException hereda de la classe Exception,
 * aquesta classe conté el seu constructor per tal de 
 * llançar les excepcions necessitades en el moment correcte.
 * 
 */
public class CentralUBException extends Exception{
    /**
     * Declara com a missatge d'error l'introduit 
     * com a parametre.
     * @param message 
     */
    public CentralUBException(String message){
        super(message);
    }
}
