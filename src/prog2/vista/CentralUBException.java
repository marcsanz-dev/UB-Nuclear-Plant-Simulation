/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.vista;

/**
 *
 * @author joelm
 * 
 * La classe CentralUBException hereda de la classe Exception,
 * aquesta classe conté el seu constructor per tal de 
 * llançar les excepcions necessitades en el moment correcte.
 * 
 */
public class CentralUBException extends Exception{
    public CentralUBException(String message){
        super(message);
    }
}
