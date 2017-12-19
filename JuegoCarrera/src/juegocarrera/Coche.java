/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegocarrera;

import java.util.Random;

/**
 *
 * @author Alex Recacha
 */
public class Coche {

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }
    
    private String piloto;
    private int dorsal;
    private String estado;
    private int potencia;
    private int velocidad;
    private int kmRecorridos;
    private final int distancia;
    
    public Coche(String piloto, int dorsal, int distancia) {
        this.piloto = piloto;
        this.dorsal = dorsal;
        this.distancia = distancia;
        this.estado = "parado";
        this.potencia = 50;
        this.velocidad = 0;
        this.kmRecorridos = 0;
    }

    @Override
    public String toString() {
        return "Piloto: " + piloto + " Dorsal: " + dorsal + "\n" +
               "Distancia Recorrida: " + getDistancia() + "\n" +
               "Estado: " + getEstado() + "\n" +
               "Velocidad: " + velocidad + " km/h \n" +
               "Km Recorridos: " + kmRecorridos + "\n--------------";
    }
    
    public void arrancar(){
        if (!estado.equalsIgnoreCase("Marcha")) {
            setEstado("Marcha");
            velocidad = 0;
            System.out.println("Arrancado!");
        }else{
            System.out.println("Ya estás en marcha");
        }
    }
    
    public void acelerar(){
        Random r = new Random();
        
        if (getEstado().equalsIgnoreCase("Marcha")){
            velocidad += r.nextInt(potencia)+1;
            if (velocidad > 200) {
                setEstado("Accidentado");
                velocidad = 0;
                System.out.println("Te has pasado de acelerar, has accidentado");
            }else{
                kmRecorridos += velocidad;
            }
            if (kmRecorridos > getDistancia()) {
                setEstado("Terminado");
                System.out.println("Has finalizado la carrera");
            }
        }else{
            System.out.println("El coche no está en marcha");
        }
    }
    
    public void frenar(){
        Random r = new Random();
        if (getEstado().equalsIgnoreCase("Marcha")) {
            velocidad -= r.nextInt(potencia)+1;
            if (velocidad < 0) {
                velocidad = 0;
            }
            kmRecorridos += velocidad;
            if (kmRecorridos > getDistancia()) {
                setEstado("Terminado");
                System.out.println("Has finalizado la carrera");
            }
        }else{
            System.out.println("El coche no está en marcha");
        }
        
    }
    
    public void rearrancar(){
        if (getEstado().equalsIgnoreCase("Accidentado")) {
            setEstado("Marcha");
            velocidad = 0;
        }else{
            System.out.println("No puedes rearrancar si no estás accidentado");
        }
    }

    /**
     * @return the dorsal
     */
    public int getDorsal() {
        return dorsal;
    }

    /**
     * @return the distancia
     */
    public int getDistancia() {
        return distancia;
    }
    
    
}
