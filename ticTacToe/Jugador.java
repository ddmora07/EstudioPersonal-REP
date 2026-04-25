package ticTacToe;

public class Jugador {

    private char color;
    private Console console;

    public Jugador(char c) {
        this.color = color;
        console = new Console();
    }

    public char color() {
        return this.color;
    }

    private void presentate(String accion) {
        console.writeln("Eres " + color + " y vas a " + accion);
    }

    public void ponerFicha(Tablero tablero) {
        Coordenada coordenada = new Coordenada();
        do {
            presentate("Poner ficha");
            coordenada.pedir();
        } while (!coordenada.esValida() || tablero.estaOcupado(coordenada));
        tablero.ponerFicha(coordenada, color);
    }

    public void celebrar() {
        console.writeln("Los " + color + " somos unos cracks !!!!");
    }

    public void moverFicha(Tablero tablero) {
        Coordenada coordenada = new Coordenada();
        do {
            presentate("Mover ficha");
            ;
            coordenada.pedir();
        } while (!coordenada.esValida() || tablero.estaVacio(coordenada)
                || !tablero.verificarColorFicha(coordenada, color));
        tablero.sacarFicha(coordenada);
        this.ponerFicha(tablero);
    }

}
