package pe.edu.upeu.claseinterna;

public class ClasePrincipal {
    public static void main(String[] args) {
        ClaseExterna ce = new ClaseExterna();
        ce.suma(8,2);
        ClaseExterna.ClaseInterna ci=ce.new ClaseInterna();
        ci.resta(6,2);

        ClaseExterna ce2=ce;
        int a=45;
    }
}
