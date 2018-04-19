package dao;

import connection.ConnectionFactory;
import model.Client;
import model.Comanda;
import model.Producator;
import model.Produs;
import bill.Factura;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

/**
 * Created by George on 5/11/2017.
 */
public class ComandaDao {
    public void insert(Comanda comanda)
    {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try
        {
            ProdusDao pdao=new ProdusDao();
            try {
                List<Produs> produse=pdao.selectAll();
                for (Produs produs:produse) {
                    if(comanda.getIdprodus()==produs.getIdprodus()) {
                        if (comanda.getCantitate() <= produs.getStoc()) {
                            int nval;
                            nval = produs.getStoc() - comanda.getCantitate();
                            produs.setStoc(nval);

                            int idpp=produs.getIdprodus();
                            produs.setIdprodus(idpp);

                            String numepp=produs.getNume();
                            produs.setNume(numepp);

                            int idprpr=produs.getIdproducator();
                            produs.setIdproducator(idprpr);

                            pdao.update(produs,produs.getIdprodus());
                        } else{
                            System.out.println("nu s-a putut efectua comanda");
                            return;
                        }

                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //insattiez un obicet de tipul produs
            //cauta dupa id
            //unde l-a gasit iau stocul d la linia aia si verific daca stocul e mai mare decat cantiattea
            //daca stocul e mai mare inserez comanda si fac update la stoc
            connection=ConnectionFactory.getConnection();
            preparedStatement=connection.prepareStatement("INSERT INTO comanda (idcomanda,idprodus,idclient,cantitate)"
                    + " VALUES (?,?,?,?)");
            preparedStatement.setInt(1,comanda.getIdcomanda());
            preparedStatement.setInt(2,comanda.getIdprodus());
            preparedStatement.setInt(3,comanda.getIdclient());
            preparedStatement.setInt(4,comanda.getCantitate());

            preparedStatement.executeUpdate();
            System.out.println("INSERT INTO comanda");
        }catch(Exception e)
        {
            e.printStackTrace();

        }

        finally{
            if(preparedStatement!=null)
                try
                {
                    preparedStatement.close();
                }catch(SQLException e)
                {
                    e.printStackTrace();
                }
            if(connection!=null)
                try
                {
                    connection.close();
                }catch(SQLException e)
                {
                    e.printStackTrace();
                }
        }

        try {
            Factura.metoda(comanda);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //List<Client> clienti=cld.selectAll();
       // for (Client client:clienti) {
         //   System.out.println(client.getIdclient()+" "+client.getAdresa()+" "+client.getNume()+" ");

        //}

    }

    public List<Comanda> selectAll() throws SQLException {
        List<Comanda> comenzi=new ArrayList<Comanda>();
        Connection connection=null;
        Statement statement =null;
        ResultSet rs=null;
        try
        {
            connection=ConnectionFactory.getConnection();
            statement=connection.createStatement();
            rs=statement.executeQuery("SELECT * FROM comanda");
            while(rs.next())
            {
                Comanda comanda =new Comanda();
                comanda.setIdcomanda(rs.getInt("idcomanda"));
                comanda.setIdprodus(rs.getInt("idprodus"));
                comanda.setIdclient(rs.getInt("idclient"));
                comanda.setCantitate(rs.getInt("cantitate"));
                // client.setEmail(rs.getString("email"));
                //clienti.add(client);
                //produse.add(produs);
                //producatori.add(producator);
                comenzi.add(comanda);

            }

        }catch(Exception e){
            e.printStackTrace();
        }finally
        {
            if(rs!=null)
            {
                try{
                    rs.close();
                }catch(SQLException e)
                {
                    e.printStackTrace();
                }
            }
            if(statement!=null)
            {
                try{
                    statement.close();
                }catch(SQLException e)
                {
                    e.printStackTrace();
                }
            }
            if(connection!=null)
            {
                try{
                    connection.close();
                }catch(SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return comenzi;
    }
    public void delete (int id)
    {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try
        {
            connection=ConnectionFactory.getConnection();
            preparedStatement=connection.prepareStatement("DELETE FROM comanda WHERE idcomanda = ?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            System.out.println("stergere comanda");

        }catch(Exception e)
        {
            e.printStackTrace();
        }finally
        {
            if(preparedStatement!= null)
            {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection!=null)
            {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public void update (Comanda comanda,int id)
    {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try
        {
            ProdusDao pdao=new ProdusDao();
            try {
                List<Produs> produse=pdao.selectAll();
                for (Produs produs:produse) {
                    if(comanda.getIdprodus()==produs.getIdprodus()) {
                        if (comanda.getCantitate() <= produs.getStoc()) {
                            int nval;
                            nval = produs.getStoc() - comanda.getCantitate();
                            produs.setStoc(nval);

                            int idpp=produs.getIdprodus();
                            produs.setIdprodus(idpp);

                            String numepp=produs.getNume();
                            produs.setNume(numepp);

                            int idprpr=produs.getIdproducator();
                            produs.setIdproducator(idprpr);

                            //pdao.update(produs,produs.getIdprodus());
                        } else{
                            System.out.println("nu s-a putut efectua  update la comanda");
                            return;
                        }

                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }



            connection=ConnectionFactory.getConnection();
            preparedStatement=connection.prepareStatement("UPDATE comanda SET "+ "idprodus = ?,idclient = ?,cantitate = ? WHERE idcomanda = ?");


            preparedStatement.setInt(1,comanda.getIdprodus());
            preparedStatement.setInt(2,comanda.getIdclient());
            preparedStatement.setInt(3,comanda.getCantitate());
            preparedStatement.setInt(4,id);

            preparedStatement.executeUpdate();

            System.out.println("update comanda");

        }catch(Exception e)
        {
            e.printStackTrace();
        }finally
        {
            if(preparedStatement!= null)
            {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection!=null)
            {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
