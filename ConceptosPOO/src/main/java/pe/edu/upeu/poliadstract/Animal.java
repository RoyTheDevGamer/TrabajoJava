package pe.edu.upeu.poliadstract;

public abstract class Animal {
    public abstract void emitirsonido();
    public void dormir(){
        System.out.println("Ya quiero dormir...no molestes!!");
    }

    public void comer(String comida, String tipo){
        switch (tipo){
            case "liquido":
                System.out.println("Tomando mi aguita!!");
                break;
            case "fruta":
                System.out.println("Esta rica esta" + comida + "...!!");
                break;
            default:
                System.out.println("NO me gusta esta(e) "+ tipo);
        }
    }
}
