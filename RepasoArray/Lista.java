package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Lista {
    public static void main(String[] args) {
        Scanner mani =new Scanner(System.in);
        System.out.println("Diga su nombre por favor");
        String name = mani.nextLine();
        String opc;
        do {
            List<Persona> user=new ArrayList<>();
            user.add(new Persona("Sofia Marques","", 'F'));
            user.add(new Persona("Lucas Fernandez","", 'M'));
            user.add(new Persona("Camila Romero","", 'F'));
            user.add(new Persona("Mateo Delgado","", 'M'));
            user.add(new Persona("Isabel Cruz","", 'F'));
            user.add(new Persona("Clauida Morena","", 'F'));
            user.add(new Persona("Andres Castillo","", 'M'));
            user.add(new Persona("Javier Ortega","", 'M'));
            user.add(new Persona("Samuel Vargas","", 'M'));
            user.add(new Persona("Valeria Molina","", 'F'));
            for (Persona U:user){
                System.out.println("-"+U.nombre+" esta presente?  P/F/T");
                U.fechaReg=new Date();
                U.setEstadoAsis(mani.nextLine());
            }
            System.out.println("Desea guardar o llamar de nuevo Guardad/");
            opc= mani.nextLine();

        }while (!opc.equals("Guardar"));
        System.out.println("Registro guardado exitozamente el dia de" +
                "\nAsistencia tomada por" +name);
    }
}
