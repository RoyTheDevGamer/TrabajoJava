package pe.edu.upeu.enums;
enum gen{mas,fem}
public class Persona {
    enum EstadoCivil{CASADO,DIVORCIADO,VIUDO,SOL}
    private String nombre;
    private String ap;
    private int edad;
    private gen gen;
    private String dni;

    public static void main(String[] args) {
        System.out.println(pe.edu.upeu.enums.gen.mas);
        for (EstadoCivil estado : EstadoCivil.values()){
            System.out.println(estado);
        }
    }
}
