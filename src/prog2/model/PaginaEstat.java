/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

/**
 *
 * @author Usuario
 */
public class PaginaEstat extends PaginaBitacola{
    
    float demanda_pot, inser_barres, out_reactor, out_refri, out_vapor, out_turbina, demanda_pot_satis;
    
    public PaginaEstat(){
        super();
    }
    
    public String toString(){
        return"# Pàgina Estat\n" +
"- Dia: " + dia + "\n" +
"- Demanda de potencia: " + demanda_pot + "\n" +
"- Inserció Barres: " + inser_barres + " %\n" +
"- Output Reactor: " + out_reactor + " Graus\n" +
"- Output Sistema de Refrigeració: " + out_refri + " Graus\n" +
"- Output Generador de Vapor: " + out_vapor + " Graus\n" +
"- Output Turbina: " + out_turbina + " Unitats de Potència\n" +
"- Demanda de Potència Satisfeta: " + demanda_pot_satis + " %";
    }
    
}
