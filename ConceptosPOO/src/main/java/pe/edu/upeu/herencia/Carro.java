package pe.edu.upeu.herencia;

public class Carro extends Vehiculo{
    String tipo;
    String color;
    private String modelo;

    public void mostrasCracteristicas(){
        marca="Toyota";
        modelo="Hilux";
        tipo="Automatico";
        color="Red";
    }
    public static void main(String[] args) {
        Carro carro = new Carro();
        carro.mostrasCracteristicas();
        System.out.println("Marca: "+carro.marca+"\nModelo: "+carro.modelo+"\nTipo: "+carro.tipo+"\nColor: "+carro.color);
        carro.emitirSonido();
    }
}
