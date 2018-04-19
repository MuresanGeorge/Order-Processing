package sample;


import dao.ClientDao;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ControllerMainWindow
{

    public void initClientView() throws IOException, SQLException {
        Stage stage = new Stage();
        stage.setTitle("Client View");

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("ClientView.fxml"));
        GridPane root = loader.load();
        //GridPane root = FXMLLoader.load(getClass().getResource("ClientView.fxml"));

        ControllerClientView controllerClientView = loader.getController();
        controllerClientView.setServices();

        stage.setScene(new Scene(root, 600, 600));
        stage.show();
    }

    public void initProducatorView() throws IOException, SQLException {
        Stage stage = new Stage();
        stage.setTitle("Producator View");

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("ProducatorView.fxml"));
        GridPane root = loader.load();
        //GridPane root = FXMLLoader.load(getClass().getResource("ClientView.fxml"));

        ControllerProducatorView controllerProducatorView = loader.getController();
        controllerProducatorView.setServices();

        stage.setScene(new Scene(root, 600, 600));
        stage.show();
    }

    public void initProdusView() throws IOException, SQLException {
        Stage stage = new Stage();
        stage.setTitle("Produs View");

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("ProdusView.fxml"));
        GridPane root = loader.load();
        //GridPane root = FXMLLoader.load(getClass().getResource("ClientView.fxml"));

        ControllerProdusView controllerProdusView = loader.getController();
        controllerProdusView.setServices();

        stage.setScene(new Scene(root, 600, 600));
        stage.show();
    }

    public void initComandaView() throws IOException, SQLException {
        Stage stage = new Stage();
        stage.setTitle("Comanda View");

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("ComandaView.fxml"));
        GridPane root = loader.load();
        //GridPane root = FXMLLoader.load(getClass().getResource("ClientView.fxml"));

        ControllerComandaView controllerComandaView = loader.getController();
        controllerComandaView.setServices();

        stage.setScene(new Scene(root, 600, 600));
        stage.show();
    }
}
