/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegocarrera;

import java.awt.BorderLayout;
import java.util.Scanner;

/**
 *
 * @author Alex Recacha
 */
public class Menus {
    
    public static int MenuPrincipal(){
        Scanner leer1 = new Scanner(System.in);
        
        int opcion = 0;
        while (opcion<1 || opcion>3){
            
            System.out.println("");
            System.out.println("----Menú Principal----");
            System.out.println("1- Configurar Carrera.");
            System.out.println("2- Empezar Carrera.");
            System.out.println("3- Salir.");
            System.out.println("----------------------");
            System.out.println("Seleccione una opción");
            try{
                opcion = leer1.nextInt();
            }catch(Exception e){

            } 
        }
        return opcion;
    }
    
    public static int MenuConfiguración(){
        
        int opcion = 0;
        while (opcion<1 || opcion>4){
            Scanner leer = new Scanner(System.in);
            System.out.println("");
            System.out.println("----Menú Configuración----");
            System.out.println("1- Definir nombre carrera.");
            System.out.println("2- Definir distancia de la carrera.");
            System.out.println("3- Añadir coche a la carrera.");
            System.out.println("4- Volver.");
            System.out.println("----------------------");
            System.out.println("Seleccione una opción");
            try{
                opcion = leer.nextInt();
            }catch(Exception e){

            } 
        }
        return opcion;
    }
    
    public static int MenuCarrera(){
        
        int opcion = 0;
        while (opcion<1 || opcion>4){
            Scanner leer = new Scanner(System.in);
            System.out.println("");
            System.out.println("---Menú Carrera---");
            System.out.println("1- Acelerar.");
            System.out.println("2- Frenar.");
            System.out.println("3- Rearrancar.");
            System.out.println("4- Parar carrera.");
            System.out.println("------------------");
            System.out.println("Seleccione una opción");
            try{
                opcion = leer.nextInt();
            }catch(Exception e){

            } 
        }
        return opcion;
    }
    
}
