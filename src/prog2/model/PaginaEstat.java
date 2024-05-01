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
    
    private float demanda_pot, inser_barres, out_reactor, out_refri, out_vapor, out_turbina, demanda_pot_satis;
    
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
