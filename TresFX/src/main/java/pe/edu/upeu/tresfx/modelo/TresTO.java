package pe.edu.upeu.tresfx.modelo;

public class TresTO {
    int Partidas;
    String Jugador1;
    String Jugador2;
    String Ganador;
    int Puntaje;
    String Estado;

    public TresTO(int partidas, String jugador1, String jugador2, String ganador, int puntaje, String estado) {
        Partidas = partidas;
        Jugador1 = jugador1;
        Jugador2 = jugador2;
        Ganador = ganador;
        Puntaje = puntaje;
        Estado = estado;
    }

    public int getPartidas() {
        return Partidas;
    }

    public void setPartidas(int partidas) {
        Partidas = partidas;
    }

    public String getJugador1() {
        return Jugador1;
    }

    public void setJugador1(String jugador1) {
        Jugador1 = jugador1;
    }

    public String getJugador2() {
        return Jugador2;
    }

    public void setJugador2(String jugador2) {
        Jugador2 = jugador2;
    }

    public String getGanador() {
        return Ganador;
    }

    public void setGanador(String ganador) {
        Ganador = ganador;
    }

    public int getPuntaje() {
        return Puntaje;
    }

    public void setPuntaje(int puntaje) {
        Puntaje = puntaje;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
