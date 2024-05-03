/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.adaptador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import prog2.model.Dades;
import prog2.model.PaginaIncidencies;
import prog2.vista.CentralUBException;

/**
 *
 * @author Usuario
 * 
 * Aquesta classe fa de connexió entre el paquet model i el paquet vista,
 * conté i implementa els mètodes de les diferents opcions que es poden 
 * escollir des del mètode gestioCentralUB.
 * 
 */
public class Adaptador implements Serializable{
    private Dades dades = new Dades();
    
    public String opcio1_1(){
        return "S'ha inserit un " + dades.getInsercioBarres() + " % de les barres";
    }
    
    public void opcio1_2(float barres)throws CentralUBException{
        dades.setInsercioBarres(barres);
    }
    
    public void opcio2_1()throws CentralUBException{
        dades.activaReactor();
    }
    
    public void opcio2_2()throws CentralUBException{
        dades.desactivaReactor();
    }
    
    public String opcio2_3(){
        return dades.mostraReactor().toString();
    }
    
    public void opcio3_1(int id)throws CentralUBException{
        dades.activaBomba(id);
    }
    
    public void opcio3_2(int id)throws CentralUBException{
        dades.desactivaBomba(id);
    }
    
    public String opcio3_3(){
        return dades.mostraSistemaRefrigeracio().toString();
    }
    
    public String opcio4(float demandaPotencia){
        return dades.mostraEstat(demandaPotencia).toString();
    }
    
    public String opcio5(){
        return dades.mostraBitacola().toString();
    }
    
    public String opcio6(){
        String str = "";
        List<PaginaIncidencies> incidencies = dades.mostraIncidencies();
        Iterator<PaginaIncidencies> it = incidencies.iterator();
        while(it.hasNext()){
            PaginaIncidencies pag_ac = it.next();
            str += pag_ac.toString() + "\n" + "\n";
        }
        return str;
    }
    
    public String finalitzaDia(float demandaPotencia){
        return dades.finalitzaDia(demandaPotencia).toString();
    }
    
    public void guardaDades(String camiDesti) throws CentralUBException{
        File fitxer = new File(camiDesti);
                
        try{
            FileOutputStream fout = new FileOutputStream(fitxer);
            ObjectOutputStream oos = new ObjectOutputStream(fout);

            oos.writeObject(dades);
            
            oos.close();
            fout.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void carregaDades(String camiOrigen)throws CentralUBException{
        File fitxer = new File(camiOrigen);
        Dades model = null;
        
        try{
                
            FileInputStream fin = new FileInputStream(fitxer);
            ObjectInputStream ois = new ObjectInputStream(fin);

            model = (Dades)ois.readObject();
            fin.close();
            ois.close();
        
        }
        catch(Exception e){
            System.out.println(e);
        }
        dades = model;
    }
}
