package model;

/**
 * Created by George on 5/10/2017.
 */
public class Comanda {
    private int idcomanda;
    private int idprodus;
    private int idclient;
    private int cantitate;

    public Comanda(int idcomanda, int idprodus, int idclient,int cantitate) {
        this.idcomanda = idcomanda;
        this.idprodus = idprodus;
        this.idclient = idclient;
        this.cantitate=cantitate;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public Comanda() {
        this.idcomanda = idcomanda;
        this.idprodus = idprodus;
        this.idclient = idclient;

    }


    public int getIdcomanda() {
        return idcomanda;
    }

    public void setIdcomanda(int idcomanda) {
        this.idcomanda = idcomanda;
    }

    public int getIdprodus() {
        return idprodus;
    }

    public void setIdprodus(int idprodus) {
        this.idprodus = idprodus;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }
}
