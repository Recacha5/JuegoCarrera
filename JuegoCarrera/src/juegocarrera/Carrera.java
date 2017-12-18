/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegocarrera;

import java.util.Scanner;

/**
 *
 * @author Alex Recacha
 */
public class Carrera {

    private String circuito;
    private Coche vCoches[];
    private int distanciaCarrera;

    public Carrera() {
        this.vCoches = new Coche[5];
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
        Scanner sc = new Scanner(System.in);
        Scanner leer = new Scanner(System.in);
        boolean terminado = true;
        boolean volver = true;
        
        while(terminado){
            switch(Menus.MenuPrincipal()){
                
                case 1: while(volver){
                            switch(Menus.MenuConfiguración()){
                                case 1: System.out.println("Dime el nombre del circuito");
                                        this.circuito = leer.nextLine();
                                        break;
                                case 2: System.out.println("Dime la distancia de la carrera");
                                        this.distanciaCarrera = leer.nextInt();
                                        break;
                                case 3: añadirCoche();
                                        System.out.println("Pulsa enter para continuar...");
                                        sc.nextLine();
                                        break;
                                case 4: 
                                        System.out.println("Pulsa enter para continuar...");
                                        leer.nextLine(); 
                                        volver = false;
                                        break;  
                            }
                        }
                        break;
                case 2: 
                        System.out.println("Pulsa enter para continuar...");
                        sc.nextLine();
                        break;
                case 3: terminado = false;
                        System.out.println("Pulsa enter para continuar...");
                        sc.nextLine();                    
                        break;        
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
        vCoches[0] = new Coche (piloto, dorsal, this.distanciaCarrera);
        
        
        
        for (int i = 1; i < vCoches.length; i++) {
            for (int j = 1; i < vCoches.length; i++) {
                if (vCoches[j].getDorsal() == dorsal) {
                    System.out.println("Dorsal ya escogido");
                }
            }
        }
        for (int i = 1; i < vCoches.length; i++) {
            if (vCoches[i]!= null) {
                vCoches[i] = new Coche (piloto, i, this.distanciaCarrera);
            }
        }
        
        
    }
}
