package model;

/**
 * Created by George on 5/10/2017.
 */
public class Produs {
    private int idprodus;
    private String nume;
    private int idproducator;
    private int stoc;

    public Produs(int idprodus, String nume, int idproducator,int stoc) {
        this.idprodus = idprodus;
        this.nume = nume;
        this.idproducator = idproducator;
        this.stoc=stoc;
    }
    public Produs() {
        //this.idprodus = 1;
        //this.nume = "";
        //this.idproducator = 2;
    }

    public int getIdprodus() {
        return idprodus;
    }

    public void setIdprodus(int idprodus) {
        this.idprodus = idprodus;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getIdproducator() {
        return idproducator;
    }

    public void setIdproducator(int idproducator) {
        this.idproducator = idproducator;
    }

    public int getStoc() {
        return stoc;
    }

    public void setStoc(int stoc) {
        this.stoc = stoc;
    }
}
