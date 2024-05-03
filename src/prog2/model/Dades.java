 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import prog2.vista.CentralUBException;

/**
 *
 * @author dortiz
 * 
 * La classe Dades implementa la interficie 
 * InDades, conté els diferents mètodes que 
 * que conté la interficie, però, ara ja 
 * estan implementats.
 * 
 */
public class Dades implements InDades, Serializable{
    public final static long  VAR_UNIF_SEED = 123;
    public final static float GUANYS_INICIALS = 0;
    public final static float PREU_UNITAT_POTENCIA = 1;
    public final static float PENALITZACIO_EXCES_POTENCIA = 200;

    // Afegir atributs:
    private VariableUniforme variableUniforme;
    private int insercioBarres, dia;
    private Reactor reactor;
    private SistemaRefrigeracio sistemaRefrigeracio;
    private GeneradorVapor generadorVapor;
    private Turbina turbina;
    private Bitacola bitacola;
    private float guanysAcumulats;
    
    
    /**
     * 
     */
    public Dades(){
        // Inicialitza Atributs
        this.variableUniforme = new VariableUniforme(VAR_UNIF_SEED);
        this.insercioBarres = 100;
        this.reactor = new Reactor();
        this.sistemaRefrigeracio = new SistemaRefrigeracio();
        this.generadorVapor = new GeneradorVapor();
        this.generadorVapor.activa();
        this.turbina = new Turbina();
        this.turbina.activa();
        this.bitacola = new Bitacola();
        this.dia = 1;
        this.guanysAcumulats = GUANYS_INICIALS;
        
        // Afegeix bombes refrigerants
        BombaRefrigerant b0 = new BombaRefrigerant(variableUniforme, 0);
        BombaRefrigerant b1 = new BombaRefrigerant(variableUniforme, 1);
        BombaRefrigerant b2 = new BombaRefrigerant(variableUniforme, 2);
        BombaRefrigerant b3 = new BombaRefrigerant(variableUniforme, 3);
        
        this.sistemaRefrigeracio.afegirBomba(b0);
        this.sistemaRefrigeracio.afegirBomba(b1);
        this.sistemaRefrigeracio.afegirBomba(b2);
        this.sistemaRefrigeracio.afegirBomba(b3);
    }
    
    /**
     * Actualitza l'economia de la central. Genera una pàgina econòmica a 
     * partir de la demanda de potencia actual. Aquesta pàgina econòmica inclou 
     * beneficis, penalització per excès de potència, costos operatius y 
     * guanys acumulats.
     * @param demandaPotencia Demanda de potència actual.
     */
    private PaginaEconomica actualitzaEconomia(float demandaPotencia){
        float beneficis, penalitzacio = 0, cost_op, guanys_acu;
        float potencia = this.calculaPotencia();
        if(potencia > demandaPotencia){
            beneficis = demandaPotencia;
            penalitzacio = 200;
        }
        else{
            beneficis = potencia;
        }
        cost_op = reactor.getCostOperatiu() + sistemaRefrigeracio.getCostOperatiu() + generadorVapor.getCostOperatiu() + turbina.getCostOperatiu();
        guanys_acu = beneficis - penalitzacio - cost_op + guanysAcumulats;
        
        return new PaginaEconomica(dia, beneficis, penalitzacio, cost_op, guanys_acu);
        
    }

        

    
    /**
     * Actualitza l'estat de la central. El mètodo ha de establir la nova
     * temperatura del reactor i revisar els components de la central. Si
     * es troben incidències, s'han de registrar en la pàgina d'incidències
     * que es proporciona com a paràmetre d'entrada.
     * @param paginaIncidencies Pàgina d'incidències.
     */
    private void actualitzaEstatCentral(PaginaIncidencies paginaIncidencies) {
        float temp = reactor.calculaOutput(insercioBarres) - sistemaRefrigeracio.calculaOutput(reactor.calculaOutput(insercioBarres));
        if(temp < 30 )temp = 30;
        reactor.setTemp(temp);
        reactor.revisa(paginaIncidencies);
        sistemaRefrigeracio.revisa(paginaIncidencies);
        generadorVapor.revisa(paginaIncidencies);
        turbina.revisa(paginaIncidencies);
        
    }
    
    public Bitacola finalitzaDia(float demandaPotencia) {
        // Actualitza economia
        PaginaEconomica paginaEconomica = actualitzaEconomia(demandaPotencia);
        
        // Genera pàgina d'estat
        PaginaEstat paginaEstat = mostraEstat(demandaPotencia);

        // Actualitza estat central i registra incidencies
        PaginaIncidencies paginaIncidencies = new PaginaIncidencies(dia);
        actualitzaEstatCentral(paginaIncidencies);
        

        // Incrementa dia
        dia += 1;
        
        // Guarda pàgines de bitacola
        bitacola.afegeixPagina(paginaEconomica);
        bitacola.afegeixPagina(paginaEstat);
        bitacola.afegeixPagina(paginaIncidencies);
        
        // Retorna pàgines
        Bitacola bitacolaDia = new Bitacola();
        bitacolaDia.afegeixPagina(paginaEconomica);
        bitacolaDia.afegeixPagina(paginaEstat);
        bitacolaDia.afegeixPagina(paginaIncidencies);
        return bitacolaDia;
    }
    
    
    /**
     * Retorna el grau d'inserció de les barres de control en percentatge.
     * @return float
     */
    @Override
    public float getInsercioBarres() {
        return insercioBarres;
    }

    @Override
    public void setInsercioBarres(float insercioBarres) throws CentralUBException {
        this.insercioBarres = (int)insercioBarres;
    }

    @Override
    public void activaReactor() throws CentralUBException {
        reactor.activa();
    }

    @Override
    public void desactivaReactor() {
        reactor.desactiva();
    }

    @Override
    public Reactor mostraReactor() {
        return reactor;
    }

    @Override
    public void activaBomba(int id) throws CentralUBException {
        ArrayList<BombaRefrigerant> bombes = sistemaRefrigeracio.getBombes();
        Iterator<BombaRefrigerant> it = bombes.iterator();
        while(it.hasNext()){
            BombaRefrigerant ac_bomba = it.next();
            if(ac_bomba.getId() == id){
            ac_bomba.activa();
            return;
            }
        }
    }

    @Override
    public void desactivaBomba(int id) {
        ArrayList<BombaRefrigerant> bombes = sistemaRefrigeracio.getBombes();
        Iterator<BombaRefrigerant> it = bombes.iterator();
        while(it.hasNext()){
            BombaRefrigerant ac_bomba = it.next();
            if(ac_bomba.getId() == id){
            ac_bomba.desactiva();
            return;
            }
        }
    }

    @Override
    public SistemaRefrigeracio mostraSistemaRefrigeracio(){
        return sistemaRefrigeracio;
    }

    @Override
    public float calculaPotencia() {
        return  turbina.calculaOutput(
                generadorVapor.calculaOutput(
                sistemaRefrigeracio.calculaOutput(
                reactor.calculaOutput(insercioBarres))));
    }

    @Override
    public PaginaEstat mostraEstat(float demandaPotencia) {
        
        float calculaPotencia = calculaPotencia(), 
            out_reactor = reactor.calculaOutput(insercioBarres), 
            out_sistemaRefrigeracio = sistemaRefrigeracio.calculaOutput(out_reactor),
            out_generadorVapor = generadorVapor.calculaOutput(out_sistemaRefrigeracio),
            out_turbina = calculaPotencia,
            porcentaje = calculaPotencia/demandaPotencia*100;
        
        //Si la potencia realizada supera la demandada diremos que esta se ha 
        //cumplido al 100% a pesar de que quizas se ha cumplido mas todavia
        
        if(porcentaje > 100) porcentaje = 100;
        
        return new PaginaEstat(dia,
                demandaPotencia, 
                insercioBarres, 
                out_reactor, 
                out_sistemaRefrigeracio, 
                out_generadorVapor, 
                out_turbina, 
                porcentaje);
        
    }

    @Override
    public Bitacola mostraBitacola() {
        return bitacola;
    }
    
    @Override
    public List<PaginaIncidencies> mostraIncidencies() {
        return bitacola.getIncidencies();
    }
}
