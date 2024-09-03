package pe.edu.upeu.encapsulamiento;

public class Loro implements Animal{
    @Override
    public void emitirsonido() {
        System.out.println("Hola Manito .....Aprende pue!!");
        System.out.println("Shhh....");
    }

    @Override
    public void comer() {
        System.out.println("Comiendo ...mi comida!!!");
    }

    @Override
    public void dormir() {
        System.out.println("Zzzz..zzz..zz");
    }
}
