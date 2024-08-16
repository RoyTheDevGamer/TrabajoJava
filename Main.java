package org.example;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!\n");
        int nomVec1 [] ={1,2,3,4,5,6,7,8,9,10};
        Persona nomVec2 [] ={new Persona("Juan","",'M'), new Persona("Pablito","",'M')};
        System.out.println("Registro de asistencia");
        Scanner leer = new Scanner(System.in);
        for (int dato:nomVec1){
            System.out.println(dato);
        }
        for (Persona dato:nomVec2){
            System.out.print("Esta presente? "+ dato.getNombre()+": ");
            dato.fechaReg=new Date();
            dato.setEstadoAsis(leer.nextLine());
        }

        System.out.println("Mostrar la asistencia");
        for (Persona dato:nomVec2){
            System.out.println(dato.getNombre()+ " - "+dato.getEstadoAsis()+ " - "+dato.getGenero()+ " - " +dato.fechaReg);
        }
        }
    }