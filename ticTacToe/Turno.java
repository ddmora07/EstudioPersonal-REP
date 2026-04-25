package ticTacToe;

public class Turno {
    private int valor;

    public Turno() {
        valor = (int) (Math.random() * 2);
    }

    public int toca() {
        return valor;
    }

    public void cambiar() {
        valor = this.noLeToca();
    }

    public int noLeToca() {
        return (valor + 1) % 2;
    }

}
