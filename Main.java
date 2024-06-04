
import java.util.Scanner;

public class Main {
    public String fDatosDelCliente(){
        Scanner auron = new Scanner(System.in);
        String correo,contra,opc,contrare,nombre,apellido,dni;
        System.out.println("Bienvenido a SEHS OnlineShop");
        System.out.println("¿Aun no tienes cuenta?");
        System.out.println("Si/No");
        opc =auron.next();
        if (opc.equals("Si")){
            System.out.println("Ingrese su Correo Electronico");
            correo=auron.nextLine();
            System.out.println("Ingrese su Contraseña");
            contra= auron.nextLine();
        }
        else if(opc.equals("No")){
            System.out.println("Ingrese su Correo Electronico");
            correo=auron.nextLine();
            System.out.println("Ingrese su Contraseña");
            contra= auron.nextLine();
            System.out.println("Repita la contraseña");
            contrare= auron.nextLine();
            System.out.println("Ingrese sus Nombres");
            nombre= auron.nextLine();
            System.out.println("Ingrese sus Apellidos");
            apellido= auron.nextLine();
            System.out.println("Ingrese su Documento de indentidad");
            dni= auron.nextLine();

        }
        else {
            System.out.println("Dato no valido");
        }


        return null;
    }
}
