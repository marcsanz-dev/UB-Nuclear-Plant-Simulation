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
    
    public PaginaEconomica(int dia_,float beneficis_, float penalitzacio_, float cost_op_, float guanys_acu_){
        super(dia_);
        beneficis = beneficis_;
        penalitzacio = penalitzacio_;
        cost_op = cost_op_;
        guanys_acu = guanys_acu_;
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
