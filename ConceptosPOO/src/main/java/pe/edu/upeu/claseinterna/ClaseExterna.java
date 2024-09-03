package pe.edu.upeu.claseinterna;

public class ClaseExterna {
    int resul;
    public void suma(int a,int b){
        int resultado = a + b;
        System.out.println(resultado);
    }
    public class ClaseInterna {
        public void resta (int a,int b){
            resul=a-b;
            System.out.println(resul);
        }
    }
}
