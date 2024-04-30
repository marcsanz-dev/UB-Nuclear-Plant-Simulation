/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

/**
 *
 * @author Usuario
 */
public class PaginaEconomica extends PaginaBitacola{
    float beneficis, penalitzacio, cost_op, guanys_acu;
    
    public PaginaEconomica(){
        super();
    }
    
    public String toString(){
        return "# Pàgina Econòmica\n" +
"- Dia: " + dia +"\n" +
"- Beneficis: " + beneficis + " Unitats Econòmiques\n" +
"- Penalització Excés Producció: " + penalitzacio + " Unitats Econòmiques\n" +
"- Cost Operatiu: " + cost_op + " Unitats Econòmiques\n" +
"- Guanys acumulats: " + guanys_acu + " Unitats Econòmiques";
    }
}
