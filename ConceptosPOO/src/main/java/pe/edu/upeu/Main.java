package pe.edu.upeu;

import pe.edu.upeu.modelo.Persona;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Persona persona =new Persona();
        persona.setNombre("Jose");
        persona.setEdad(36);
        System.out.println(persona.getNombre()+"\t"+persona.getEdad());
    }
}