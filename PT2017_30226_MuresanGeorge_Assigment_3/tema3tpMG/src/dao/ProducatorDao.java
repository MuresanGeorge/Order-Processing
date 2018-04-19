package dao;

import connection.ConnectionFactory;
import model.Client;
import model.Producator;
import model.Produs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

/**
 * Created by George on 5/11/2017.
 */
public class ProducatorDao {
    public void insert(Producator producator)
    {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try
        {
            connection=ConnectionFactory.getConnection();
            preparedStatement=connection.prepareStatement("INSERT INTO producator (idproducator,nume,tara)"
                    + " VALUES (?,?,?)");
            preparedStatement.setInt(1,producator.getIdproducator());
            preparedStatement.setString(2,producator.getNume());
            preparedStatement.setString(3,producator.getTara());

            preparedStatement.executeUpdate();
            System.out.println("INSERT INTO producator");
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

    public List<Producator> selectAll() throws SQLException {
        List<Producator> producatori=new ArrayList<Producator>();
        Connection connection=null;
        Statement statement =null;
        ResultSet rs=null;
        try
        {
            connection=ConnectionFactory.getConnection();
            statement=connection.createStatement();
            rs=statement.executeQuery("SELECT * FROM producator");
            while(rs.next())
            {
                Producator producator =new Producator();
                producator.setIdproducator(rs.getInt("idproducator"));
                producator.setNume(rs.getString("nume"));
                producator.setTara(rs.getString("tara"));
                // client.setEmail(rs.getString("email"));
                //clienti.add(client);
                //produse.add(produs);
                producatori.add(producator);

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
        return producatori;
    }
    public void delete (int id)
    {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try
        {
            connection=ConnectionFactory.getConnection();
            preparedStatement=connection.prepareStatement("DELETE FROM producator WHERE idproducator = ?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            System.out.println("stergere producator");

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
    public void update (Producator producator,int id)
    {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try
        {
            connection=ConnectionFactory.getConnection();
            preparedStatement=connection.prepareStatement("UPDATE producator SET "+ "nume = ?,tara = ? WHERE idproducator = ?");


            preparedStatement.setString(1,producator.getNume());
            preparedStatement.setString(2,producator.getTara());
            preparedStatement.setInt(3,id);

            preparedStatement.executeUpdate();

            System.out.println("update producator");

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
