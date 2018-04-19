package sample;

import dao.ClientDao;
import dao.ProducatorDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Client;
import model.Producator;

import java.sql.SQLException;

public class ControllerProducatorView
{

    private ProducatorDao producatorDao;
    private ObservableList<Producator> model;


    @FXML
    private TableView<Producator> producatorView = new TableView<>();
    @FXML
    private TableColumn<Producator,Integer> idCol=new TableColumn<>();
    @FXML
    private TableColumn<Producator,String> numeCol=new TableColumn<>();
    @FXML
    private TableColumn<Producator,String> taraCol=new TableColumn<>();

    @FXML
    TextField idText = new TextField();
    @FXML
    TextField numeText = new TextField();
    @FXML
    TextField taraText = new TextField();



    public void setServices() throws SQLException {

        this.producatorDao = new ProducatorDao();


        this.model= FXCollections.observableArrayList(producatorDao.selectAll());
        producatorView.setItems(model);


    }
    @FXML
    public void initialize(){
        idCol.setCellValueFactory(new PropertyValueFactory<Producator, Integer>("idproducator"));
        numeCol.setCellValueFactory(new PropertyValueFactory<Producator, String>("nume"));
        taraCol.setCellValueFactory(new PropertyValueFactory<Producator, String>("tara"));


    }
    public void handleAdd() throws SQLException {
        if(idText.getText().equals("")){
            AlertBox.display("Error","ID-ul nu poate fi null!");
            return;
        }
        String s = idText.getText();
        for(int i = 0;i<s.length();i++){
            if(!"0123456789".contains(s.substring(i,i+1))){
                AlertBox.display("Error","ID-ul trebuie sa fie format doar din cifre!");
                return;
          }
        }
        Producator p = new Producator(Integer.parseInt(idText.getText()),numeText.getText(),taraText.getText());
        producatorDao.insert(p);
        this.model= FXCollections.observableArrayList(producatorDao.selectAll());
        producatorView.setItems(model);
    }
    public void handleUpdate() throws SQLException {
        if(idText.getText().equals("")){
            AlertBox.display("Error","ID-ul nu poate fi null!");
            return;
        }
        String s = idText.getText();
        for(int i = 0;i<s.length();i++){
            if(!"0123456789".contains(s.substring(i,i+1))){
                AlertBox.display("Error","ID-ul trebuie sa fie format doar din cifre!");
                return;
            }
        }
        Producator p = new Producator(Integer.parseInt(idText.getText()),numeText.getText(),taraText.getText());
        producatorDao.update(p,p.getIdproducator());
        this.model= FXCollections.observableArrayList(producatorDao.selectAll());
        producatorView.setItems(model);
    }


    public void handleDelete() throws SQLException {
        Producator p = producatorView.getSelectionModel().getSelectedItem();
        if(p == null){
            AlertBox.display("Error","Selectati un producator din tabel pentru a fi sters");
            return;
        }

            producatorDao.delete(p.getIdproducator());
        this.model= FXCollections.observableArrayList(producatorDao.selectAll());
        producatorView.setItems(model);

    }

}
