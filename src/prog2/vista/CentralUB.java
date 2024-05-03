/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.vista;
import prog2.adaptador.Adaptador;

import java.util.Scanner;

/**
 *
 * @author dortiz
 * 
 * La classe CentralUB conté el seu propi constructor 
 * i els mètodes per tal de poder imprimir el menú 
 * principal del nostre programa.
 * 
 */
public class CentralUB {
    public final static float DEMANDA_MAX = 1600;
    public final static float DEMANDA_MIN = 200;
    public final static float VAR_NORM_MEAN = 1000;
    public final static float VAR_NORM_STD = 600;
    public final static long VAR_NORM_SEED = 123;
    
    /** Generador aleatori de la demanda de potència **/
    private VariableNormal variableNormal;
    
    /** Demanda de potència del dia actual **/
    private float demandaPotencia;
    
    private Adaptador adaptador = new Adaptador();
    
    /* Constructor*/
    public CentralUB() {
        variableNormal = new VariableNormal(VAR_NORM_MEAN, VAR_NORM_STD, VAR_NORM_SEED);
        demandaPotencia = generaDemandaPotencia();
        
        // Afegir codi adicional si fos necessari:

    }
    
    public void gestioCentralUB() {
        // Mostrar missatge inicial
        System.out.println("Benvingut a la planta PWR de la UB \n");
        System.out.println("La demanda de potència elèctrica avui es de " + demandaPotencia + " unitats \n");

        // Completar
        enum OpcionsMenu {OPCIO1,OPCIO2,OPCIO3,OPCIO4,OPCIO5,OPCIO6,OPCIO7,
        OPCIO8,OPCIO9,OPCIO10};
        
        
        String[] opciones = {"Gestió Barres de Control", "Gestió Reactor", 
            "Gestió Sistema Refrigeració", "Mostrar Estat Central", 
            "Mostrar Bitàcola", "Mostrar Incidències", "Finalitzar Dia", 
            "Guardar Dades", "Carrega Dades", "Sortir"};
        
        try{
            Menu<OpcionsMenu> menu = new Menu<OpcionsMenu>("menu principal", OpcionsMenu.values());
            menu.setDescripcions(opciones);
            Scanner sc = new Scanner(System.in);
            OpcionsMenu opcio = null;
            String ruta;
            do{
                menu.mostrarMenu();
                opcio = menu.getOpcio(sc);
                switch(opcio){
                    case OPCIO1:
                        submenu1();
                        break;
                        
                    case OPCIO2:
                        submenu2();
                        break;
                        
                    case OPCIO3:
                        submenu3();
                        break;
                        
                    case OPCIO4:
                        System.out.println(adaptador.opcio4(demandaPotencia));
                        break;
                        
                    case OPCIO5:
                        System.out.println(adaptador.opcio5());
                        break;
                        
                    case OPCIO6:
                        System.out.println(adaptador.opcio6());
                        break;
                        
                    case OPCIO7:
                        finalitzaDia();
                        break;
                        
                    case OPCIO8:
                        System.out.println("Quina es la ruta del fitxer a on vols guardar les dades? \n");
                        ruta = sc.next();
                        adaptador.guardaDades(ruta);
                        break;
                        
                    case OPCIO9:
                        System.out.println("Quina es la ruta del fitxer d'on vols carregar les dades? \n");
                        ruta = sc.next();
                        adaptador.carregaDades(ruta);
                        break;
                        
                    case OPCIO10:
                        System.out.println("Adeu moltes gràcies!!! \n");
                        break;
                }

            }while(opcio!=OpcionsMenu.OPCIO10);}
        catch(CentralUBException e){
            System.err.println(e);
        }
        
    }
    
    private void submenu1(){
        enum OpcionsSubMenu1{OPCIO1, OPCIO2,OPCIO3};
        String[] opciones1 = {"Obtenir Inserció Barres", 
            "Establir Inserció Barres", "Sortir"};
        try{
            Menu<OpcionsSubMenu1> menu = new Menu<OpcionsSubMenu1>("gestió barres de control", OpcionsSubMenu1.values());
            menu.setDescripcions(opciones1);
            Scanner sc = new Scanner(System.in);
            OpcionsSubMenu1 opcio = null;
            float barres = 0;
            do{
                menu.mostrarMenu();
                opcio = menu.getOpcio(sc);
                switch(opcio){
                    case OPCIO1:
                        System.out.println(adaptador.opcio1_1());
                        break;
                        
                    case OPCIO2:
                        System.out.println("Quin porcentatge de barres vols inserir? \n");
                        barres = sc.nextFloat();
                        adaptador.opcio1_2(barres);
                        break;
                        
                    case OPCIO3:
                        System.out.println("Tornem al menú principal \n");
                        break;
                }

            }while(opcio!=OpcionsSubMenu1.OPCIO3);}
        catch(CentralUBException e){
            System.err.println(e);
        }
    }
    
    private void submenu2(){
        enum OpcionsSubMenu2{OPCIO1, OPCIO2,OPCIO3,OPCIO4};
        String[] opciones2 = {"Activar Reactor", "Desactivar Reactor", 
                "Mostrar Estat", "Sortir"};
        try{
            Menu<OpcionsSubMenu2> menu = new Menu<OpcionsSubMenu2>("gestió reactor", OpcionsSubMenu2.values());
            menu.setDescripcions(opciones2);
            Scanner sc = new Scanner(System.in);
            OpcionsSubMenu2 opcio = null;
            do{
                menu.mostrarMenu();
                opcio = menu.getOpcio(sc);
                switch(opcio){
                    case OPCIO1:
                        adaptador.opcio2_1();
                        break;
                        
                    case OPCIO2:
                        adaptador.opcio2_2();
                        break;
                        
                    case OPCIO3:
                        System.out.println(adaptador.opcio2_3());
                        break;
                        
                    case OPCIO4:
                        System.out.println("Tornem al menú principal \n");
                        break;
                }

            }while(opcio!=OpcionsSubMenu2.OPCIO4);}
        catch(CentralUBException e){
            System.err.println(e);
        }
    }
    
    private void submenu3(){
        enum OpcionsSubMenu3{OPCIO1, OPCIO2,OPCIO3,OPCIO4};
        String[] opciones3 = {"Activar Bomba", "Desactivar Bomba", 
            "Mostrar Estat", "Sortir"};
        try{
            Menu<OpcionsSubMenu3> menu = new Menu<OpcionsSubMenu3>("gestió sistema de refrigeració", OpcionsSubMenu3.values());
            menu.setDescripcions(opciones3);
            Scanner sc = new Scanner(System.in);
            OpcionsSubMenu3 opcio = null;
            int id;
            do{
                menu.mostrarMenu();
                opcio = menu.getOpcio(sc);
                switch(opcio){
                    case OPCIO1:
                        System.out.println("Quin és l'ID de la bomba que vols activar? \n");
                        id = sc.nextInt();
                        adaptador.opcio3_1(id);
                        break;
                        
                    case OPCIO2:
                        System.out.println("Quin és l'ID de la bomba que vols desactivar? \n");
                        id = sc.nextInt();
                        adaptador.opcio3_2(id);
                        break;
                        
                    case OPCIO3:
                        System.out.println(adaptador.opcio3_3());
                        break;
                        
                    case OPCIO4:
                        System.out.println("Tornem al menú principal \n");
                        break;
                }

            }while(opcio!=OpcionsSubMenu3.OPCIO4);}
        catch(CentralUBException e){
            System.err.println(e);
        }
    }
    
    private float generaDemandaPotencia(){
        float valor = Math.round(variableNormal.seguentValor());
        if (valor > DEMANDA_MAX)
            return DEMANDA_MAX;
        else
            if (valor < DEMANDA_MIN)
                return DEMANDA_MIN;
            else
                return valor;
    }
    
    private void finalitzaDia() {
        // Finalitzar dia i imprimir informacio de la central
        String info = new String();
        info = adaptador.finalitzaDia(demandaPotencia);
        System.out.println(info);
        System.out.println("Dia finalitzat\n");
        
        // Generar i mostrar nova demanda de potencia
        demandaPotencia = generaDemandaPotencia();
        System.out.println("La demanda de potència elèctrica avui es de " + demandaPotencia + " unitats");
    }
}
