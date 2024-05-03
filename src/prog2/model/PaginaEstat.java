/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;
/**
 *
 * @author Usuario
 * 
 * La classe PaginaEstat hereda de PaginaBitacola, 
 * conté el seu propi constructor i el seu toString.
 * 
 */
public class PaginaEstat extends PaginaBitacola{
    
    private float demanda_pot, inser_barres, out_reactor, out_refri, out_vapor, out_turbina, demanda_pot_satis;
    
    
    /**
     * Inicialitza els atributs de la classe PaginaEstat
     * @param dia_ Objecte de tipus int
     * @param demanda_pot Objecte de tipus float
     * @param inser_barres Objecte de tipus float
     * @param out_reactor Objecte de tipus float
     * @param out_refri Objecte de tipus float
     * @param out_vapor Objecte de tipus float
     * @param out_turbina Objecte de tipus float
     * @param demanda_pot_satis Objecte de tipus float
     */
    public PaginaEstat(int dia_,float demanda_pot,float inser_barres,float out_reactor,
            float out_refri,float out_vapor,float out_turbina,float demanda_pot_satis){
        super(dia_);
        this.demanda_pot = demanda_pot;
        this.inser_barres = inser_barres;
        this.out_reactor = out_reactor;
        this.out_refri = out_refri;
        this.out_vapor = out_vapor;
        this.out_turbina = out_turbina;
        this.demanda_pot_satis = demanda_pot_satis;
    }
    
    
    /**
     * Retorna un String amb la informacio de la pagina economica
     * @return String
     */
    public String toString(){
        return"# Pàgina Estat\n" +
"- Dia: " + super.getDia() + "\n" +
"- Demanda de potencia: " + demanda_pot + "\n" +
"- Inserció Barres: " + inser_barres + " %\n" +
"- Output Reactor: " + out_reactor + " Graus\n" +
"- Output Sistema de Refrigeració: " + out_refri + " Graus\n" +
"- Output Generador de Vapor: " + out_vapor + " Graus\n" +
"- Output Turbina: " + out_turbina + " Unitats de Potència\n" +
"- Demanda de Potència Satisfeta: " + demanda_pot_satis + " %";
    }
    
}
