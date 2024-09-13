package pe.edu.upeu.tresfx.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;





@Component
public class TresControl {
    @FXML
    TextField Jugador1, Jugador2;

    @FXML
    Label CuadroTurno;
    Button[][] tablero;

    @FXML
    Button btn00, btn01, btn02, btn10, btn11, btn12, btn20, btn21, btn22;

    boolean turno=true;
    @FXML
    public void initialize() {
        System.out.println("Hola");
        tablero=new Button[][]{
                {btn00,btn01,btn02},
                {btn10,btn11,btn12},
                {btn20,btn21,btn22}
        };
        Turnos();
    }

    @FXML
    void accionButon(ActionEvent e){
        Button b=(Button)e.getSource();
        b.setText(turno?"X":"O");
        turno=!turno;
        Turnos();
    }

    void Turnos() {
        String jugadorActual = turno ? Jugador1.getText() : Jugador2.getText();
        CuadroTurno.setText("Es el turno de: " + (jugadorActual.isEmpty() ? (turno ? "Jugador 1" : "Jugador 2") : jugadorActual));
    }


}
