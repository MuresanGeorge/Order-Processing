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
public class ProdusDao {
    public void insert(Produs produs)
    {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try
        {
            connection=ConnectionFactory.getConnection();
            preparedStatement=connection.prepareStatement("INSERT INTO produs (idprodus,nume,idproducator,stoc)"
                    + " VALUES (?,?,?,?)");
            preparedStatement.setInt(1,produs.getIdprodus());
            preparedStatement.setString(2,produs.getNume());
            preparedStatement.setInt(3,produs.getIdproducator());
            preparedStatement.setInt(4,produs.getStoc());

            preparedStatement.executeUpdate();
            System.out.println("INSERT INTO produs");
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

    public List<Produs> selectAll() throws SQLException {
        List<Produs> produse=new ArrayList<Produs>();
        Connection connection=null;
        Statement statement =null;
        ResultSet rs=null;
        try
        {
            connection=ConnectionFactory.getConnection();
            statement=connection.createStatement();
            rs=statement.executeQuery("SELECT * FROM produs");
            while(rs.next())
            {
                Produs produs =new Produs();
                produs.setIdprodus(rs.getInt("idprodus"));
                produs.setNume(rs.getString("nume"));
                produs.setIdproducator(rs.getInt("idproducator"));
                produs.setStoc(rs.getInt("stoc"));
               // client.setEmail(rs.getString("email"));
                //clienti.add(client);
                produse.add(produs);

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
        return produse;
    }
    public void delete (int id)
    {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try
        {
            connection=ConnectionFactory.getConnection();
            preparedStatement=connection.prepareStatement("DELETE FROM produs WHERE idprodus = ?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            System.out.println("stergere produs");

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
    public void update (Produs produs,int id)
    {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try
        {
            connection=ConnectionFactory.getConnection();
            preparedStatement=connection.prepareStatement("UPDATE produs SET "+ "nume = ?,idproducator = ?,stoc = ? WHERE idprodus = ?");


            preparedStatement.setString(1,produs.getNume());
            preparedStatement.setInt(2,produs.getIdproducator());
            preparedStatement.setInt(3,produs.getStoc());
            preparedStatement.setInt(4,id);

            preparedStatement.executeUpdate();

            System.out.println("update produs");

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
