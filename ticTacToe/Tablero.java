package ticTacToe;

public class Tablero {
    private char[][] casillas;
    final private int DIMENSION = 3;
    final private char VACIO = '_';
    private Console console;

    public Tablero() {
        casillas = new char[DIMENSION][DIMENSION];
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                casillas[i][j] = VACIO;
            }

        }
        console = new Console();

    }

    public void mostrar() {
        for (int fila = 0; fila < DIMENSION; fila++) {
            for (int columna = 0; columna < DIMENSION; columna++) {
                console.write(" " + casillas[fila][columna]);
            }
            console.writeln();
        }
    }

    public boolean estaOcupado(Coordenada coordenada) {
        int fila = coordenada.getFila();
        int columna = coordenada.getColumna();
        char contenido = casillas[fila][columna];
        if (contenido != VACIO) {
            return true;
        } else {
            return false;
        }

    }

    public boolean estaCompleto(Jugador jugador) {
        int contador = 0;
        for (int fila = 0; fila < DIMENSION; fila++) {
            for (int columna = 0; columna < DIMENSION; columna++) {
                if (casillas[fila][columna] == jugador.color()) {
                    contador++;
                }
            }
        }
        return contador == 3;
    }

    public boolean hayTresEnRaya() {
        return this.hayTresEnRaya('x') || this.hayTresEnRaya('o');
    }

    private boolean hayTresEnRaya(char color) {
        int[] filas = new int[3];
        int[] columnas = new int[3];
        int diagonal = 0;
        int secundaria = 0;

        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (casillas[i][j] == color) {
                    filas[i]++;
                    columnas[j]++;
                    if (i == j) {
                        diagonal++;
                    }
                    if (i + j == 2) {
                        secundaria++;
                    }
                    if (filas[i] == DIMENSION || columnas[j] == DIMENSION ||
                            diagonal == DIMENSION || secundaria == DIMENSION) {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    public void ponerFicha(Coordenada coordenada, char color) {
        int fila = coordenada.getFila();
        int columna = coordenada.getColumna();
        casillas[fila][columna] = color;
    }

    public boolean estaVacio(Coordenada coordenada) {
        return !this.estaOcupado(coordenada);
    }

    public boolean verificarColorFicha(Coordenada coordenada, char color) {
        int fila = coordenada.getFila();
        int columna = coordenada.getColumna();
        return casillas[fila][columna] == color;
    }

    public void sacarFicha(Coordenada coordenada) {
        int fila = coordenada.getFila();
        int columna = coordenada.getColumna();
        casillas[fila][columna] = VACIO;
    }
}
