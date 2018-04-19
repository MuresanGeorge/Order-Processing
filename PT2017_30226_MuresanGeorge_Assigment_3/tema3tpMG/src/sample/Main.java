package sample;
import dao.ClientDao;
import dao.ComandaDao;
import dao.ProdusDao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Client;
import model.Comanda;
import model.Produs;

import java.sql.SQLException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        ClientDao clientDao = new ClientDao();

        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        primaryStage.setTitle("Hello World");

        ControllerMainWindow controllerMainWindow = new ControllerMainWindow();
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }


    public static void main(String[] args) throws SQLException {
        launch(args);
        //-------------------------------------testclient---------------------------
//        ClientDao cld=new ClientDao();
//        Client cli=new Client();
//        cli.setIdclient(1);
//        cli.setEmail("email5");
//        cli.setAdresa("adresa5");
//        cli.setNume("nume5");
//        cld.insert(cli);


//        System.out.print(cli.getEmail()+" "+cli.getAdresa()+" "+cli.getNume());
//        System.out.println();
//        cld.insert(cli);
//        cld.delete(2);
//        List<Client> clienti=cld.selectAll();
//        for (Client client:clienti) {
//            System.out.println(client.getIdclient()+" "+client.getAdresa()+" "+client.getNume()+" ");
//
//        }
//        Client cl4=new Client();
//        cl4.setNume("updatenume4");
//        cld.update(cl4,4);
        /*List<Client> clienti=cld.selectAll();
        for (Client client:clienti) {
            System.out.println(client.getIdclient()+" "+client.getAdresa()+" "+client.getNume()+" "+client.getEmail());

        }
        Client cl4=new Client();
        cl4.setNume("updatenume4dinnou");
        cld.update(cl4,4);*/

        //--------------------------------test producator--------------------
//        Producator p1=new Producator();
//        p1.setTara("Romania");
//        p1.setIdproducator(1);
//        p1.setNume("BOSCH");
//        ProducatorDao pdao=new ProducatorDao();
//        pdao.insert(p1);
        //Producator p2=new Producator();
        //p2.setTara("romANIA UPDATE");
        //pdao.update(p2,1);
        //pdao.delete(1);
        //--------------------------------test produs--------------------
//        Produs p=new Produs();
//        p.setIdprodus(1);
//        p.setNume("BORMASINA");
//        p.setIdproducator(1);
//        p.setStoc(1000);
//        ProdusDao pdao=new ProdusDao();
//        pdao.insert(p);
//

//        Producator p2=new Producator();
//        p2.setIdproducator(2);
//        p2.setNume("SAMSUNG");
//        p2.setTara("ROMANIA");
//        ProducatorDao p2dao=new ProducatorDao();
//        p2dao.insert(p2);


       //ProdusDao pdao=new ProdusDao();
       //pdao.insert(p);
        //Produs p1=new Produs();
       //p1.setNume("BOrmainaupdate");
      // p1.setIdproducator(2);
       // pdao.update(p1,1);
//-----------------------------test comanda-------------------
//        ProdusDao pdao=new ProdusDao();
//        Comanda c1=new Comanda();
//        ComandaDao comdao=new ComandaDao();
//        c1.setIdclient(0);
//        c1.setIdcomanda(1);
//        c1.setIdprodus(1);
//        c1.setCantitate(100);
//        comdao.insert(c1);
//        c1.setIdprodus(1);
//        //c1.setIdcomanda(1);
//        //comdao.update(c1,1);
//        comdao.delete(1);
//        pdao.delete(1);

    }
}
