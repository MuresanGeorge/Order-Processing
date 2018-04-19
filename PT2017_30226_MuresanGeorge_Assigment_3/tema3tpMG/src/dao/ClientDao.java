package dao;
import connection.ConnectionFactory;
import model.Client;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

/**
 * Created by George on 5/10/2017.
 * Clasa ClientDao  implemeteaza metodele : insert, delete, update si selectall
 * Este folosita pentru accesarea si procesarea datelor din baza de date
 */
public class ClientDao {
    /**
     * Pentru a insera  un client nou in baza de date
     * @param client clientul nou ce va fi inserat
     */
   public void insert(Client client)
    {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try
        {
            connection=ConnectionFactory.getConnection();
            preparedStatement=connection.prepareStatement("INSERT INTO client (idclient,nume,adresa,email)"
                    + " VALUES (?,?,?,?)");
            preparedStatement.setInt(1,client.getIdclient());
            preparedStatement.setString(2,client.getNume());
            preparedStatement.setString(3,client.getAdresa());
            preparedStatement.setString(4,client.getEmail());
            preparedStatement.executeUpdate();
            System.out.println("INSERT INTO client(idclient,nume,adresa,email)"+ "VALUES (?,?,?,?)");
        }catch(Exception e)
        {
            e.printStackTrace();

        }finally{
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

    }
    /**
     * Pentru afisarea datelor fiecarui client
     * @return clienti
     */
    public List<Client> selectAll() throws SQLException {
        List<Client> clienti=new ArrayList<Client>();
        Connection connection=null;
        Statement statement =null;
        ResultSet rs=null;
        try
        {
            connection=ConnectionFactory.getConnection();
            statement=connection.createStatement();
            rs=statement.executeQuery("SELECT * FROM client");
            while(rs.next())
            {
                Client client =new Client();
                client.setIdclient(rs.getInt("idclient"));
                client.setNume(rs.getString("nume"));
                client.setAdresa(rs.getString("adresa"));
                client.setEmail(rs.getString("email"));
                clienti.add(client);

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
        return clienti;
    }
    /**
     * Pentru stergerea unui client cu un id specificat
     * @param id id-ul clientului care va fi sters
     */
    public void delete (int id)
    {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try
        {
            connection=ConnectionFactory.getConnection();
            preparedStatement=connection.prepareStatement("DELETE FROM client WHERE idclient = ?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            System.out.println("stergere client");

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
    /**
     * Pentru reactualizarea datelor unui client
     * @param id id-ul clientului care va fi updatat
     * @param client clientul care va fi updatat
     */
    public void update (Client client,int id)
    {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try
        {
            connection=ConnectionFactory.getConnection();
            preparedStatement=connection.prepareStatement("UPDATE client SET "+ "nume = ?,adresa = ?,email= ? WHERE idclient = ?");

            preparedStatement.setInt(4,id);
            preparedStatement.setString(1,client.getNume());
            preparedStatement.setString(2,client.getAdresa());
            preparedStatement.setString(3,client.getEmail());
            preparedStatement.executeUpdate();

            System.out.println("update client");

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
