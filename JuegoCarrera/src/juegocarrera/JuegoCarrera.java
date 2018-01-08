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
public class JuegoCarrera {

    public static void main(String[] args) {
        Scanner leer = new Scanner (System.in);
        System.out.println("BIENVENIDO AL GRAN PRIX DE PROGRAMACIÓN!!!");
        System.out.println("(No, no es ver quién programa más rápido) \nEs una carrera de coches...");
        Carrera carrera = new Carrera();
        
        carrera.jugar();
    }
    
}
