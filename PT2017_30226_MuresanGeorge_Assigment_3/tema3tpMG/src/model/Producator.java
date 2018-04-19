package model;

/**
 * Created by George on 5/10/2017.
 */
public class Producator {
    private int idproducator;
    private String nume;
    private String tara;

    public Producator(int idproducator, String nume, String tara) {
        this.idproducator = idproducator;
        this.nume = nume;
        this.tara = tara;
    }
    public Producator() {
        this.idproducator = idproducator;
        this.nume = nume;
        this.tara = tara;
    }

    public int getIdproducator() {
        return idproducator;
    }

    public void setIdproducator(int idproducator) {
        this.idproducator = idproducator;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getTara() {
        return tara;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }
}
