package sample;

import dao.ComandaDao;
import dao.ProdusDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Comanda;
import model.Produs;

import java.sql.SQLException;

public class ControllerComandaView
{

    private ComandaDao comandaDao;
    private ObservableList<Comanda> model;


    @FXML
    private TableView<Comanda> comandaView = new TableView<>();
    @FXML
    private TableColumn<Comanda,Integer> idCol=new TableColumn<>();
    @FXML
    private TableColumn<Comanda,Integer> idProdusCol=new TableColumn<>();
    @FXML
    private TableColumn<Comanda,Integer> idClientCol=new TableColumn<>();
    @FXML
    private TableColumn<Comanda,Integer> cantitateCol=new TableColumn<>();

    @FXML
    TextField idText = new TextField();
    @FXML
    TextField idProdusText = new TextField();
    @FXML
    TextField idClientText = new TextField();
    @FXML
    TextField cantitateText = new TextField();



    public void setServices() throws SQLException {
        this.comandaDao = new ComandaDao();
        this.model= FXCollections.observableArrayList(comandaDao.selectAll());
        comandaView.setItems(model);


    }
    @FXML
    public void initialize(){
        idCol.setCellValueFactory(new PropertyValueFactory<Comanda, Integer>("idcomanda"));
        idProdusCol.setCellValueFactory(new PropertyValueFactory<Comanda, Integer>("idprodus"));
        idClientCol.setCellValueFactory(new PropertyValueFactory<Comanda, Integer>("idclient"));
        cantitateCol.setCellValueFactory(new PropertyValueFactory<Comanda, Integer>("cantitate"));


    }
    public void handleAdd() throws SQLException {
        if(idText.getText().equals("")){
            AlertBox.display("Error","ID-ul produsului nu poate fi null!");
            return;
        }
        String s = idText.getText();
        for(int i = 0;i<s.length();i++){
            if(!"0123456789".contains(s.substring(i,i+1))){
                AlertBox.display("Error","ID-ul produsului trebuie sa fie format doar din cifre!");
                return;
          }
        }


        if(idProdusText.getText().equals("")){
            AlertBox.display("Error","ID-ul produsului nu poate fi null!");
            return;
        }
        String s1 = idProdusText.getText();
        for(int i = 0;i<s1.length();i++){
            if(!"0123456789".contains(s1.substring(i,i+1))){
                AlertBox.display("Error","ID-ul produsului trebuie sa fie format doar din cifre!");
                return;
            }
        }



        if(idClientText.getText().equals("")){
            AlertBox.display("Error","ID-ul clientului nu poate fi null!");
            return;
        }
        String s2 = idClientText.getText();
        for(int i = 0;i<s2.length();i++){
            if(!"0123456789".contains(s2.substring(i,i+1))){
                AlertBox.display("Error","ID-ul clientului trebuie sa fie format doar din cifre!");
                return;
            }
        }




        if(cantitateText.getText().equals("")){
            AlertBox.display("Error","ID-ul cantitatea nu poate fi null!");
            return;
        }
        String s3 = cantitateText.getText();
        for(int i = 0;i<s3.length();i++){
            if(!"0123456789".contains(s3.substring(i,i+1))){
                AlertBox.display("Error","Cantitatea trebuie sa fie format doar din cifre!");
                return;
            }
        }


        Comanda c = new Comanda(Integer.parseInt(idText.getText()),Integer.parseInt(idProdusText.getText()),Integer.parseInt(idClientText.getText()),Integer.parseInt(cantitateText.getText()));
        comandaDao.insert(c);
        this.model= FXCollections.observableArrayList(comandaDao.selectAll());
        comandaView.setItems(model);
    }
    public void handleUpdate() throws SQLException {
        if(idText.getText().equals("")){
            AlertBox.display("Error","ID-ul produsului nu poate fi null!");
            return;
        }
        String s = idText.getText();
        for(int i = 0;i<s.length();i++){
            if(!"0123456789".contains(s.substring(i,i+1))){
                AlertBox.display("Error","ID-ul produsului trebuie sa fie format doar din cifre!");
                return;
            }
        }


        if(idProdusText.getText().equals("")){
            AlertBox.display("Error","ID-ul produsului nu poate fi null!");
            return;
        }
        String s1 = idProdusText.getText();
        for(int i = 0;i<s1.length();i++){
            if(!"0123456789".contains(s1.substring(i,i+1))){
                AlertBox.display("Error","ID-ul produsului trebuie sa fie format doar din cifre!");
                return;
            }
        }



        if(idClientText.getText().equals("")){
            AlertBox.display("Error","ID-ul clientului nu poate fi null!");
            return;
        }
        String s2 = idClientText.getText();
        for(int i = 0;i<s2.length();i++){
            if(!"0123456789".contains(s2.substring(i,i+1))){
                AlertBox.display("Error","ID-ul clientului trebuie sa fie format doar din cifre!");
                return;
            }
        }




        if(cantitateText.getText().equals("")){
            AlertBox.display("Error","ID-ul cantitatea nu poate fi null!");
            return;
        }
        String s3 = cantitateText.getText();
        for(int i = 0;i<s3.length();i++){
            if(!"0123456789".contains(s3.substring(i,i+1))){
                AlertBox.display("Error","Cantitatea trebuie sa fie format doar din cifre!");
                return;
            }
        }
        Comanda c = new Comanda(Integer.parseInt(idText.getText()),Integer.parseInt(idProdusText.getText()),Integer.parseInt(idClientText.getText()),Integer.parseInt(cantitateText.getText()));
        comandaDao.update(c,c.getIdcomanda());
        this.model= FXCollections.observableArrayList(comandaDao.selectAll());
        comandaView.setItems(model);
    }


    public void handleDelete() throws SQLException {
        Comanda p = comandaView.getSelectionModel().getSelectedItem();
        if(p == null){
            AlertBox.display("Error","Selectati un produs din tabel pentru a fi sters");
            return;
        }

            comandaDao.delete(p.getIdcomanda());
        this.model= FXCollections.observableArrayList(comandaDao.selectAll());
        comandaView.setItems(model);

    }

}
