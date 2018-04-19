package bill;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import model.Comanda;


/**
 * Created by George on 5/11/2017.
 * Clasa factura implementeaza o metoda ce imi va genera o factura
 */
public class Factura {
    /**
     * Pentru a genera o factura.txt
     *@param comanda comanda efectuata de un user
     */
    public static void metoda(Comanda comanda) throws Exception {

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("Factura cu nr." + comanda.getIdcomanda() + ".txt"));
            bw.write("S-a efectuat "+" comanda " + comanda.getIdcomanda() + " "+" a clientului " + comanda.getIdclient() + " care a comandat produsul "
                    + comanda.getIdprodus() + " cu cantitatea "+comanda.getCantitate());

        } catch (IOException e) {
        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException e) {
            }
        }

    }
}


