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
    private int distanciaCarrera = 0;

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
        Scanner leer1 = new Scanner(System.in);
        boolean terminado = true;
        boolean volver = true;
        boolean parar = true;
        
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
                case 2: if (comprobarConfiguracion()) {
                            vCoches[0].arrancar();
                            while(parar){                                
                                this.toString();
                                switch(Menus.MenuCarrera()){
                                    case 1: vCoches[0].acelerar();
                                            mostrar();
                                            break;
                                    case 2: vCoches[0].frenar();
                                            mostrar();
                                            break;
                                    case 3: vCoches[0].rearrancar();
                                            mostrar();
                                            break;
                                    case 4: parar = false;
                                            break;  
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
        
        if (vCoches[0] != null && distanciaCarrera != 0 && circuito != null) {
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
    
    private void movimientoBots(){
        Random r = new Random();
        
        for (int i = 1; i < vCoches.length; i++) {
            if (r.nextInt(2) == 0) {
                vCoches[i].acelerar();
            }else if (r.nextInt(2)==1){
                vCoches[i].frenar();
            }
            
            
        }
        
    }
}
