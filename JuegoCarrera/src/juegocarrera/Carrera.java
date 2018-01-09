/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegocarrera;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Alex Recacha
 */
public class Carrera {

    private String circuito;
    private Coche vCoches[];
    private Coche vGanadores[];
    private int distanciaCarrera = 0;

    public Carrera() {
        this.vCoches = new Coche[5];
        this.vGanadores = new Coche[3];
    }

    public Carrera(String circuito, int distanciaCarrera) {
        
        this.circuito = circuito;
        this.distanciaCarrera = distanciaCarrera;
    }

    @Override
    public String toString() {
        return "Circuito: " + circuito + " Distancia: " + distanciaCarrera + " metros";
    }
    
    public void empezarCarrera(){
        
    }
    
    public void jugar(){
        
        Scanner leer = new Scanner(System.in);
        Scanner leer1 = new Scanner(System.in);
        boolean terminado = true;
        boolean volver = true;
        boolean parar = true;
        
        while(terminado){
            Scanner sc = new Scanner(System.in);
            volver=true;
            parar=true;
            switch(Menus.MenuPrincipal()){
                
                case 1: while(volver){
                            
                            switch(Menus.MenuConfiguración()){
                                case 1: System.out.println("Dime el nombre del circuito");
                                        this.circuito = leer.nextLine();
                                        break;
                                case 2: System.out.println("Dime la distancia de la carrera");
                                        this.distanciaCarrera = leer1.nextInt();
                                        break;
                                case 3: añadirCoche();
                                        break;
                                case 4: volver = false;
                                        break;  
                            }
                        }
                        break;
                case 2: if (comprobarConfiguracion()) {
                            for (Coche c:vCoches) {
                                if (c!=null) {
                                    c.arrancar();
                                }
                            }
                            
                            while(parar){                                
                                Scanner sc1 = new Scanner(System.in);
                                switch(Menus.MenuCarrera()){
                                    case 1: vCoches[0].acelerar();
                                            movimientoBots();
                                            mostrar();
                                            System.out.println("Pulsa enter para continuar...");
                                            sc1.nextLine();
                                            break;
                                    case 2: vCoches[0].frenar();
                                            movimientoBots();
                                            mostrar();
                                            System.out.println("Pulsa enter para continuar...");
                                            sc1.nextLine();
                                            break;
                                    case 3: vCoches[0].rearrancar();
                                            movimientoBots();
                                            mostrar();
                                            System.out.println("Pulsa enter para continuar...");
                                            sc1.nextLine();
                                            break;
                                    case 4: parar = false;
                                            break;  
                                }
                                if (comprobarTerminado()) {
                                    moverBotsHastaTerminar();
                                    
                                    mostrarGanadores();
                                    for (int i = 0; i < vCoches.length; i++) {
                                        vCoches[i] = null;
                                    }
                                    System.out.println("Carrera finalizada, siguiente circuito!");
                                    parar = false;
                                }
                            }
                        }else{
                            System.out.println("Configuración inválida");
                        }
                        System.out.println("Pulsa enter para continuar...");
                        sc.nextLine();
                        break;
                case 3: terminado = false;
                        System.out.println("Pulsa enter para continuar...");
                        sc.nextLine();                    
                        break;
                default: break;
            }
        }
    }
    private void añadirCoche(){
        Scanner leer = new Scanner(System.in);
        String piloto;
        int dorsal;
        System.out.println("Dime el nombre del piloto");
        piloto = leer.nextLine();
        System.out.println("Dime el dorsal de " + piloto);
        dorsal = leer.nextInt();
        if (comprobarDorsal(dorsal)) {
            vCoches[0] = new Coche (piloto, dorsal, this.distanciaCarrera);
        }else{
            System.out.println("Dorsal no válido");
        }
        //Creo los bots
        for (int i = 1; i < vCoches.length; i++) {
            vCoches[i] = new Coche ("bot "+i, i+100, this.distanciaCarrera);
        }
        for (int i = 0; i < vCoches.length; i++) {
            if (comprobarDorsal(dorsal)) {
                vCoches[i] = new Coche ("bot "+i, i++, this.distanciaCarrera);
            }
        }
    }
    
    private boolean comprobarDorsal(int dorsal){
        for (int i = 0; i < vCoches.length; i++){
            if (vCoches[i]!= null && vCoches[i].getDorsal() == dorsal) {
                return false;
            }
        }
        return true;
    }
    
    private boolean comprobarConfiguracion(){
        
        if (vCoches[0] != null && vCoches[0].getDistancia() != 0 && this.circuito != null) {
            return true;
        }else{
            return false;
        }
    }
    
    private void mostrar(){
        
        for (Coche c:vCoches) {
            System.out.println(c.toString());
        }
    }
    
    private void mostrarGanadores(){
        for (Coche c:vGanadores) {
            if (c!=null) {
                System.out.println(c.toString());
            }
        }
    }
    private void movimientoBots(){
        Random r = new Random();
        
        for (int i = 1; i < vCoches.length; i++) {
            if (vCoches[i].getEstado().equalsIgnoreCase("Accidentado") && !vCoches[0].getEstado().equalsIgnoreCase("Terminado")) {
                vCoches[i].setEstado("Marcha");
            }else{
                int opcion = r.nextInt(3);
                if (opcion == 0 || opcion==1) {
                    vCoches[i].acelerar();
                }else if (opcion == 2){
                    vCoches[i].frenar();
                }
            }
        }
        
    }
    
    private boolean comprobarTerminado(){
        introducirGanadores();
        for (int i=0; i<vCoches.length; i++) {
            
            if (vCoches[0].getEstado().equalsIgnoreCase("Terminado")) {
                return true;
            }
        }
        return false;
    }
    
    private void introducirGanadores(){
        
        boolean repetido = false;

            for (int i = 0; i < vCoches.length; i++) {
                if (vCoches[i].getEstado().equalsIgnoreCase("Terminado")) {
                    for (int j = 0; j < vGanadores.length; j++) {
                        if (vGanadores[j] != null && vGanadores[j].getDorsal() == vCoches[i].getDorsal()) {
                            repetido = true;
                            break;
                        }
                    }
                    if (!repetido)
                        for (int j=0; j<vGanadores.length;j++){
                            if (vGanadores[j] == null){
                               vGanadores[j] = vCoches[i];
                               break;
                            }
                        }
                }
            }
    }
    
    private void moverBotsHastaTerminar(){
        int contador=1;

        while (contador!=vCoches.length){
            contador = 1;
            movimientoBots();
            
            for (int i=1; i<vCoches.length; i++) {
                if (!vCoches[i].getEstado().equalsIgnoreCase("Marcha")) {
                    contador++;
                }
            }
        }
    }
}
