package pe.edu.upeu.calcfx.control;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;

@Component
public class CalcControl {
    @FXML
    TextField txtResultado;
    @FXML
    public void accionButton(ActionEvent event){
        Button button=(Button) event.getSource();
        switch (button.getId()){
            case "btn7","btn8","btn9","btn4","btn5","btn6","btn1","btn2","btn3","btn0":{
                escribirNumeros(button.getText());
            }break;
            case "btnSum","btnRes","btnDiv","btnMul", "btnPot":{
                operador(button.getText());
            }break;
            case "btnRai","btnPi","btn1So":{
                operarespecial(button.getText());
            }break;
            case "btnIgu":
                calcularResultado();
                break;
            case "btnC":
                txtResultado.clear();
                break;
        }
    }
    public void escribirNumeros(String valor){txtResultado.appendText(valor);}
    public void operador(String valor){txtResultado.appendText(" "+valor+" ");}
    public void operarespecial(String valor){txtResultado.appendText(valor+" ");}

    public void calcularResultado(){
        //sale esto en la consola ,help, pero la calculadora funciona
        // Caused by: java.lang.NumberFormatException: empty String
        //	at java.base/jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:1842)
        //	at java.base/jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //	at java.base/java.lang.Double.parseDouble(Double.java:651)
        //	at pe.edu.upeu.calcfx.control.CalcControl.calcularResultado(CalcControl.java:53)
        //	at pe.edu.upeu.calcfx.control.CalcControl.accionButton(CalcControl.java:28)
        //	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:104)
        //	... 53 more
        String[] valores=txtResultado.getText().split(" ");
        String texto =txtResultado.getText().trim();
        if (texto.startsWith("√")){
            double val = Double.parseDouble(texto.substring(1).trim());
            txtResultado.setText(String.valueOf(Math.sqrt(val)));
        }else if (texto.startsWith("1/")){
            double val = Double.parseDouble(texto.substring(2).trim());
            txtResultado.setText(String.valueOf(1/val));
        }else if (texto.startsWith("π")){
            txtResultado.setText(String.valueOf(3.1415926535897932384626433832795));
        }


        double val1=Double.parseDouble(String.valueOf(valores[0]));
        double val2=Double.parseDouble(String.valueOf(valores[2]));
        switch (valores[1]){
            case "+":{txtResultado.setText(String.valueOf(val1+val2));}break;
            case "-":{txtResultado.setText(String.valueOf(val1-val2));}break;
            case "/":{txtResultado.setText(String.valueOf(val1/val2));}break;
            case "*":{txtResultado.setText(String.valueOf(val1*val2));}break;
            case "^":{txtResultado.setText(String.valueOf(Math.pow(val1, val2)));}break;


        }
    }
}
