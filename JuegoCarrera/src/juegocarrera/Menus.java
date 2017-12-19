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

        int opcion = 0;
        while (opcion<1 || opcion>3){
            Scanner leer1 = new Scanner(System.in);
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
        
        int opcion2 = 0;
        while (opcion2<1 || opcion2>4){
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
                opcion2 = leer.nextInt();
            }catch(Exception e){

            } 
        }
        return opcion2;
    }
    
    public static int MenuCarrera(){
        
        int opcion3 = 0;
        while (opcion3<1 || opcion3>4){
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
                opcion3 = leer.nextInt();
            }catch(Exception e){

            } 
        }
        return opcion3;
    }
    
}
