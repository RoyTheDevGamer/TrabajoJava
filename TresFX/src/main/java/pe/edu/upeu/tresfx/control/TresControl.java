package pe.edu.upeu.tresfx.control;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.stereotype.Component;
import pe.edu.upeu.tresfx.modelo.TresTO;

@Component
public class TresControl {
    @FXML
    TableView<TresTO> Historial;

    @FXML
    TableColumn<TresTO, String> cJugador1, cJugador2, cGanador, cEstado;
    @FXML
    TableColumn<TresTO, Integer> cPartido, cPuntaje;

    private ObservableList<TresTO> HistorialList = FXCollections.observableArrayList();
    int puntajeJugador1 = 0;
    int puntajeJugador2 = 0;
    int ContadorDePartidas = 1;

    @FXML
    Button Iniciar, Anular;

    @FXML
    TextField Jugador1, Jugador2;

    @FXML
    Label CuadroTurno, CuadroPuntaje1, CuadroPuntaje2;
    Button[][] tablero;

    @FXML
    Button btn00, btn01, btn02, btn10, btn11, btn12, btn20, btn21, btn22;

    boolean turno = true;
    boolean juegoTerminado = true;
    TresTO partidaActual; //Para guardar las partidas

    @FXML
    public void initialize() {
        System.out.println("Hola");
        tablero = new Button[][]{
                {btn00, btn01, btn02},
                {btn10, btn11, btn12},
                {btn20, btn21, btn22}
        };
        Turnos();

        for (Button[] row : tablero) {
            for (Button btn : row) {
                btn.setOnAction(this::accionButon);
                btn.setDisable(true); //Blokea el tablero
            }
        }
        Iniciar.setOnAction(this::onIniciar);
        Anular.setOnAction(this::onAnular);
        CuadroTurno.setText("Dale en Iniciar para jugar"); //texto informativo en field CuadroTurno o info

        cPartido.setCellValueFactory(new PropertyValueFactory<>("partidas"));
        cJugador1.setCellValueFactory(new PropertyValueFactory<>("jugador1"));
        cJugador2.setCellValueFactory(new PropertyValueFactory<>("jugador2"));
        cGanador.setCellValueFactory(new PropertyValueFactory<>("ganador"));
        cPuntaje.setCellValueFactory(new PropertyValueFactory<>("puntaje"));
        cEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        Historial.setItems(HistorialList);
    }

    @FXML
    void accionButon(ActionEvent e) {
        Button b = (Button) e.getSource();
        if (b.getText().isEmpty()) { //no jugar dos veces en el mismo cuadro
            b.setText(turno ? "X" : "O");
            if (Ganadas()) {
                CuadroTurno.setText("¡Ganó " + (turno ? Jugador1.getText() : Jugador2.getText()) + "!");
                juegoTerminado = true;
                EstadoTabla(false);
                ActualizarGanadas(); //renovar puntajes
                ActualizarPartidaActual(turno ? Jugador1.getText() : Jugador2.getText(), (turno ? puntajeJugador1 : puntajeJugador2), "Terminado");
            } else if (Empate()) {
                CuadroTurno.setText("Empate");
                juegoTerminado = true;
                EstadoTabla(false);
                ActualizarPartidaActual("Empate", 0, "Terminado");
            } else {
                turno = !turno;
                Turnos();
            }
        }
    }

    void Turnos() {
        String jugadorActual = turno ? Jugador1.getText() : Jugador2.getText();
        CuadroTurno.setText("Turno de: " + (jugadorActual.isEmpty() ? (turno ? "Jugador 1" : "Jugador 2") : jugadorActual));
    }

    @FXML
    void onIniciar(ActionEvent event) {
        if (partidaActual != null && partidaActual.getEstado().equals("Jugando")) {
            //ua partida por fila ,
            CuadroTurno.setText("No puedes iniciar una nueva partida mientras una esté en curso.");
            return;
        }

        //una nuesva fila de historial
        partidaActual = new TresTO(ContadorDePartidas++, Jugador1.getText(), Jugador2.getText(), "", 0, "Jugando");
        HistorialList.add(partidaActual);

        juegoTerminado = false;
        turno = true;
        Turnos();
        ReiniciarTabla();
        EstadoTabla(true); //tabla desblokeado
        CuadroTurno.setText("Comenzamos");
        Puntajes(); //actualizar o mostrar los puntos
    }

    @FXML
    void onAnular(ActionEvent event) {
        EstadoTabla(false); //blokear el tablero
        CuadroTurno.setText("Se anuló el juego"); //texto en info
        if (partidaActual != null && partidaActual.getEstado().equals("Jugando")) {
            ActualizarPartidaActual("Empate", 0, "Anulado");
        }
    }

    void ReiniciarTabla() {
        for (Button[] row : tablero) {
            for (Button btn : row) {
                btn.setText("");
            }
        }
    }

    void EstadoTabla(boolean habilitado) {
        for (Button[] row : tablero) {
            for (Button btn : row) {
                btn.setDisable(!habilitado);
            }
        }
    }

    boolean Ganadas() {
        //verificar filas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0].getText().equals(tablero[i][1].getText()) &&
                    tablero[i][1].getText().equals(tablero[i][2].getText()) &&
                    !tablero[i][0].getText().isEmpty()) {
                return true;
            }
        }

        //verificar columnas
        for (int i = 0; i < 3; i++) {
            if (tablero[0][i].getText().equals(tablero[1][i].getText()) &&
                    tablero[1][i].getText().equals(tablero[2][i].getText()) &&
                    !tablero[0][i].getText().isEmpty()) {
                return true;
            }
        }

        //verificar diagonales
        if (tablero[0][0].getText().equals(tablero[1][1].getText()) &&
                tablero[1][1].getText().equals(tablero[2][2].getText()) &&
                !tablero[0][0].getText().isEmpty()) {
            return true;
        }
        if (tablero[0][2].getText().equals(tablero[1][1].getText()) &&
                tablero[1][1].getText().equals(tablero[2][0].getText()) &&
                !tablero[0][2].getText().isEmpty()) {
            return true;
        }

        return false;
    }

    boolean Empate() {
        //si todos los cuadros estan llenos es empate
        for (Button[] row : tablero) {
            for (Button btn : row) {
                if (btn.getText().isEmpty()) {
                    return false; //si ay espacio no es empate
                }
            }
        }
        return !Ganadas(); //si no hay ganador, es empate
    }

    void ActualizarPartidaActual(String ganador, int puntaje, String estado) {
        if (partidaActual != null) {
            //actualizar fila o historial de la misma partida
            partidaActual.setGanador(ganador);
            partidaActual.setPuntaje(puntaje);
            partidaActual.setEstado(estado);
            //actualizar manulmente o por seguridad
            Historial.refresh();
            Puntajes();
        }
    }

    void ActualizarGanadas() {
        if (turno) {
            puntajeJugador1++;
        } else {
            puntajeJugador2++;
        }
        Puntajes();
    }

    void Puntajes() {
        //imprimir los puntajes actualizados
        System.out.println("Actualizando puntajes:");
        System.out.println("Puntaje Jugador 1: " + puntajeJugador1);
        System.out.println("Puntaje Jugador 2: " + puntajeJugador2);
        CuadroPuntaje1.setText("Puntaje de " + Jugador1.getText() + ": " + puntajeJugador1);
        CuadroPuntaje2.setText("Puntaje de " + Jugador2.getText() + ": " + puntajeJugador2);
    }
}
