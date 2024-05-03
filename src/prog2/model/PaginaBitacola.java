/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Usuario
 * 
 * La classe PaginaBitacola contés els mètodes contructor,
 * consultor i modificador del seu únic atribut.
 * 
 */
public class PaginaBitacola implements Serializable{
    private int dia;
    
    public PaginaBitacola(int dia_){
        dia = dia_;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia_) {
        dia = dia_;
    }
    
    
    
}
