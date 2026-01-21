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
import prog2.model.BombaRefrigerant;
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
    private Dades dades;

    public Adaptador() {
        dades = new Dades();
    }
    /**
     * Retorna un String que diu el porcentatge 
     * de barres que s'han inserit.
     * @return String
     */
    public String opcio1_1(){
        return "S'ha inserit un " + dades.getInsercioBarres() + " % de les barres";
    }
    /**
     * Declara la quantitat de barres que 
     * té el nostre objecte dades amb el parametre 
     * passat.
     * @param barres
     * @throws CentralUBException 
     */
    public void opcio1_2(float barres)throws CentralUBException{
        dades.setInsercioBarres(barres);
    }
    /**
     * Activa el reactor.
     * @throws CentralUBException 
     */
    public void opcio2_1()throws CentralUBException{
        dades.activaReactor();
    }
    /**
     * Desactiva el reactor.
     * @throws CentralUBException 
     */
    public void opcio2_2()throws CentralUBException{
        dades.desactivaReactor();
    }
    /**
     * Retorna un String amb tota la informació 
     * del reactor.
     * @return String
     */
    public String opcio2_3(){
        return dades.mostraReactor().toString();
    }
    /**
     * Activa la bomba que té l'id passat per parametre.
     * @param id
     * @throws CentralUBException 
     */
    public void opcio3_1(int id)throws CentralUBException{
        dades.activaBomba(id);
    }
    /**
     * Desactiva la bomba que té l'id passat per parametre.
     * @param id
     * @throws CentralUBException 
     */
    public void opcio3_2(int id)throws CentralUBException{
        dades.desactivaBomba(id);
    }
    /**
     * Retorna un String amb tota la informació
     * del sistema de refrigeració.
     * @return String
     */
    public String opcio3_3(){
        return dades.mostraSistemaRefrigeracio().toString();
    }
    /**
     * Retorna un String amb tota la informació de
     * l'estat de la central segons una demanda de 
     * potencia passada per paràmetre.
     * @param demandaPotencia
     * @return String
     */
    public String opcio4(float demandaPotencia){
        return dades.mostraEstat(demandaPotencia).toString();
    }
    /**
     * Retorna un String amb tota la informació de 
     * totes les pagines del dia al que ens trobem.
     * @return String
     */
    public String opcio5(){
        return dades.mostraBitacola().toString();
    }
    /**
     * Retorna un String amb la informació de totes les 
     * pàgines d'incidéncies.
     * @return String
     */
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
    /**
     * Actualitza tots els valors conforme s'acabat el dia
     * i et retorna un Stirng amb la informació resumen 
     * d'aquell dia.
     * @param demandaPotencia
     * @return String
     */
    public String finalitzaDia(float demandaPotencia){
        return dades.finalitzaDia(demandaPotencia).toString();
    }
    /**
     * Guarda les dades de la central a l'arxiu passat per 
     * paràmetre.
     * @param camiDesti
     * @throws CentralUBException 
     */
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
    /**
     * Recupera les dades de la Central d'una arxiu passat per
     * paràmetre.
     * @param camiOrigen
     * @throws CentralUBException 
     */
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
            throw new CentralUBException("No se ha podido abrir bien el archivo");
        }
        dades = model;
    }
    
    public String getDia(){
        return dades.getDia();
    }
    
    public String getGuanys(){
        return dades.getGuanys();
    }
    
    public ArrayList<String> getBombesString(){
        ArrayList<BombaRefrigerant> bombes = dades.mostraSistemaRefrigeracio().getBombes();
        Iterator<BombaRefrigerant> it = bombes.iterator();
        ArrayList<String> str = new ArrayList<String>();
        while(it.hasNext()){
            str.add(it.next().toString());
        }
        return str;
    }
    
    public boolean getEstatID(int id) throws CentralUBException{
        ArrayList<BombaRefrigerant> bombes = dades.mostraSistemaRefrigeracio().getBombes();
        Iterator<BombaRefrigerant> it = bombes.iterator();
        while(it.hasNext()){
            BombaRefrigerant bomba = it.next();
            if(bomba.getId() == id){
                return bomba.getActivat();
            }
        }
        throw new CentralUBException("No hi ha cap bomba amb l'ID: " + id);
       
    }
    
    public void setEstatID(int id, boolean active) throws CentralUBException{
        ArrayList<BombaRefrigerant> bombes = dades.mostraSistemaRefrigeracio().getBombes();
        Iterator<BombaRefrigerant> it = bombes.iterator();
        while(it.hasNext()){
            BombaRefrigerant bomba = it.next();
            if(bomba.getId() == id){
                if(active)bomba.activa();
                else bomba.desactiva();
                return;
            }
        }
        throw new CentralUBException("No hi ha cap bomba amb l'ID: " + id);
       
    }
    
    public boolean getActivitatReactor(){
        return dades.getActivitatReactor();
    }
    
    public float getBarres(){
        return dades.getInsercioBarres();
    }
}
