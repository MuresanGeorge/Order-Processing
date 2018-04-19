package sample;

import dao.ProducatorDao;
import dao.ProdusDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Producator;
import model.Produs;

import java.sql.SQLException;

public class ControllerProdusView
{

    private ProdusDao produsDao;
    private ObservableList<Produs> model;


    @FXML
    private TableView<Produs> produsView = new TableView<>();
    @FXML
    private TableColumn<Produs,Integer> idCol=new TableColumn<>();
    @FXML
    private TableColumn<Produs,String> numeCol=new TableColumn<>();
    @FXML
    private TableColumn<Produs,Integer> idProducatorCol=new TableColumn<>();
    @FXML
    private TableColumn<Produs,Integer> stocCol=new TableColumn<>();

    @FXML
    TextField idText = new TextField();
    @FXML
    TextField numeText = new TextField();
    @FXML
    TextField idProducatorText = new TextField();
    @FXML
    TextField stocText = new TextField();



    public void setServices() throws SQLException {
        this.produsDao = new ProdusDao();
        this.model= FXCollections.observableArrayList(produsDao.selectAll());
        produsView.setItems(model);


    }
    @FXML
    public void initialize(){
        idCol.setCellValueFactory(new PropertyValueFactory<Produs, Integer>("idprodus"));
        numeCol.setCellValueFactory(new PropertyValueFactory<Produs, String>("nume"));
        idProducatorCol.setCellValueFactory(new PropertyValueFactory<Produs, Integer>("idproducator"));
        stocCol.setCellValueFactory(new PropertyValueFactory<Produs, Integer>("stoc"));


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


        if(idProducatorText.getText().equals("")){
            AlertBox.display("Error","ID-ul producatorului nu poate fi null!");
            return;
        }
        String s1 = idProducatorText.getText();
        for(int i = 0;i<s1.length();i++){
            if(!"0123456789".contains(s1.substring(i,i+1))){
                AlertBox.display("Error","ID-ul producatorului trebuie sa fie format doar din cifre!");
                return;
            }
        }

        if(stocText.getText().equals("")){
            AlertBox.display("Error","ID-ul stocul nu poate fi null!");
            return;
        }
        String s2 = stocText.getText();
        for(int i = 0;i<s2.length();i++){
            if(!"0123456789".contains(s2.substring(i,i+1))){
                AlertBox.display("Error","Stocul  trebuie sa fie format doar din cifre!");
                return;
            }
        }

        Produs p = new Produs(Integer.parseInt(idText.getText()),numeText.getText(),Integer.parseInt(idProducatorText.getText()),Integer.parseInt(stocText.getText()));
        produsDao.insert(p);
        this.model= FXCollections.observableArrayList(produsDao.selectAll());
        produsView.setItems(model);
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


        if(idProducatorText.getText().equals("")){
            AlertBox.display("Error","ID-ul producatorului nu poate fi null!");
            return;
        }
        String s1 = idProducatorText.getText();
        for(int i = 0;i<s1.length();i++){
            if(!"0123456789".contains(s1.substring(i,i+1))){
                AlertBox.display("Error","ID-ul producatorului trebuie sa fie format doar din cifre!");
                return;
            }
        }

        if(stocText.getText().equals("")){
            AlertBox.display("Error","ID-ul stocul nu poate fi null!");
            return;
        }
        String s2 = stocText.getText();
        for(int i = 0;i<s2.length();i++){
            if(!"0123456789".contains(s2.substring(i,i+1))){
                AlertBox.display("Error","Stocul  trebuie sa fie format doar din cifre!");
                return;
            }
        }
        Produs p = new Produs(Integer.parseInt(idText.getText()),numeText.getText(),Integer.parseInt(idProducatorText.getText()),Integer.parseInt(stocText.getText()));
        produsDao.update(p,p.getIdprodus());
        this.model= FXCollections.observableArrayList(produsDao.selectAll());
        produsView.setItems(model);
    }


    public void handleDelete() throws SQLException {
        Produs p = produsView.getSelectionModel().getSelectedItem();
        if(p == null){
            AlertBox.display("Error","Selectati un produs din tabel pentru a fi sters");
            return;
        }

            produsDao.delete(p.getIdprodus());
        this.model= FXCollections.observableArrayList(produsDao.selectAll());
        produsView.setItems(model);

    }

}
