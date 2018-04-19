package model;

/**
 * Created by George on 5/10/2017.
 * Clasa client se foloseste pentru stocarea informatiilor unui client
 */
public class Client {
    private Integer idclient;
    private String nume;
    private String adresa;
    private String email;
/**
 * Acesta e un constructor pt a initializa un obiect de tipul client
 * @param idclient idulclientului
 * @param nume numele clientului
 * @param adresa adresa clientului
 * @param email email-ul clientului
 */
    public Client(int idclient, String nume, String adresa, String email) {
        this.idclient = idclient;
        this.nume = nume;
        this.adresa = adresa;
        this.email = email;
    }
    public Client() {

    }
    public Integer getIdclient() {
        return idclient;
    }


    /**
     * Pentru a seta id-ul clientului
     * @param idclient noul id al clientului
     */
    public void setIdclient(Integer idclient) {
        this.idclient = idclient;
    }

    public String getNume() {
        return nume;
    }
    /**
     * Pentru a seta numele clientului
     * @param nume noul nume al clientului
     */
    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return adresa;
    }

    /**
     * Pentru a seta adresa clientului
     * @param adresa noua adresa a clientului
     */
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getEmail() {
        return email;
    }

    /**
     * Pentru a seta email-ul clientului
     * @param email noul email al clientului
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idclient=" + idclient +
                ", nume='" + nume + '\'' +
                ", adresa='" + adresa + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
