package sample;

import dao.ClientDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Client;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerClientView
{

    private ClientDao clientDao;
    private ObservableList<Client> model;


    @FXML
    private TableView<Client> clientView = new TableView<>();
    @FXML
    private TableColumn<Client,Integer> idCol=new TableColumn<>();
    @FXML
    private TableColumn<Client,String> numeCol=new TableColumn<>();
    @FXML
    private TableColumn<Client,String> adresaCol=new TableColumn<>();
    @FXML
    private TableColumn<Client,String> emailCol=new TableColumn<>();
    @FXML
    TextField idText = new TextField();
    @FXML
    TextField numeText = new TextField();
    @FXML
    TextField adresaText = new TextField();
    @FXML
    TextField emailText = new TextField();


    public void setServices() throws SQLException {

        this.clientDao = new ClientDao();


        this.model= FXCollections.observableArrayList(clientDao.selectAll());
        clientView.setItems(model);
       //this.clientView.setItems(model);
        //this.numeCol=new Tab

//        for (Client client:model) {
//            System.out.println(client.getIdclient() + " " + client.getAdresa() + " " + client.getNume() + " " + client.getEmail());
//        }
        //  clientView.setItems(model);

    }
    @FXML
    public void initialize(){
        idCol.setCellValueFactory(new PropertyValueFactory<Client, Integer>("idclient"));
        numeCol.setCellValueFactory(new PropertyValueFactory<Client, String>("nume"));
        adresaCol.setCellValueFactory(new PropertyValueFactory<Client, String>("adresa"));
        emailCol.setCellValueFactory(new PropertyValueFactory<Client, String>("email"));

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
        Client c = new Client(Integer.parseInt(idText.getText()),numeText.getText(),adresaText.getText(),emailText.getText());
        clientDao.insert(c);
        this.model= FXCollections.observableArrayList(clientDao.selectAll());
        clientView.setItems(model);
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
        Client c = new Client(Integer.parseInt(idText.getText()),numeText.getText(),adresaText.getText(),emailText.getText());
        clientDao.update(c,c.getIdclient());
        this.model= FXCollections.observableArrayList(clientDao.selectAll());
        clientView.setItems(model);
    }


    public void handleDelete() throws SQLException {
        Client c = clientView.getSelectionModel().getSelectedItem();
        if(c == null){
            AlertBox.display("Error","Selectati un client din tabel pentru a fi sters");
            return;
        }

            clientDao.delete(c.getIdclient());
        this.model= FXCollections.observableArrayList(clientDao.selectAll());
        clientView.setItems(model);

    }

}
