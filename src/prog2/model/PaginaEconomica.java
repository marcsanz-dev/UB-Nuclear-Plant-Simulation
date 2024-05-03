/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

/**
 *
 * @author Joel Moreno
 * 
 * La classe PaginaEconomica hereda de PaginaBitacola, 
 * conté el seu propi constructor i el seu toString.
 * 
 */
public class PaginaEconomica extends PaginaBitacola{
    private float beneficis, penalitzacio, cost_op, guanys_acu;
    
    
    /**
     * Inicialitza els atributs de la classe PaginaEconomica
     * @param dia_ Objecte de tipus int
     * @param beneficis_ Objecte de tipus float
     * @param penalitzacio_ Objecte de tipus float
     * @param cost_op_ Objecte de tipus float
     * @param guanys_acu_ Objecte de tipus float
     */
    public PaginaEconomica(int dia_,float beneficis_, float penalitzacio_, float cost_op_, float guanys_acu_){
        super(dia_);
        beneficis = beneficis_;
        penalitzacio = penalitzacio_;
        cost_op = cost_op_;
        guanys_acu = guanys_acu_;
    }
    
    
    /**
     * Retorna un String amb la informacio de la pagina economica
     * @return String
     */
    public String toString(){
        return "# Pàgina Econòmica\n" +
"- Dia: " + super.getDia() +"\n" +
"- Beneficis: " + beneficis + " Unitats Econòmiques\n" +
"- Penalització Excés Producció: " + penalitzacio + " Unitats Econòmiques\n" +
"- Cost Operatiu: " + cost_op + " Unitats Econòmiques\n" +
"- Guanys acumulats: " + guanys_acu + " Unitats Econòmiques";
    }
}
