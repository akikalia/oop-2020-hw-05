package manager;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao{
    private String database = "StoreProductDatabase";
    private String password = "";
    private String username = "root";
    private String table = "products";

    private Connection conn;

    public ProductDao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost",
                    username,
                    password);
            Statement stmt = conn.createStatement();
            stmt.executeQuery("USE " + database);
        }catch(ClassNotFoundException c){
            c.printStackTrace();
        }
        catch (SQLException s ){
            s.printStackTrace();
        }
    }

    public List<String> getNameList(){
        List<String> names = new ArrayList();
        PreparedStatement stm = null;

        try {
            stm = conn.prepareStatement("select name from " + table+";");
            ResultSet res = stm.executeQuery();

            while(res.next())
                names.add(res.getString(1));
        } catch (SQLException e){ e.printStackTrace();}
        return names;
    }

    public Product getProduct(String product_id){
        Product product = null;
        PreparedStatement stm = null;

        try {
            System.out.println("product ID:" + product_id);
            stm = conn.prepareStatement("select * from " + table  + " where productid = '"+ product_id+"' ;");
            ResultSet res = stm.executeQuery();

            res.next();
            product = new Product(res.getString(1),res.getString(2), res.getString(3), res.getString(4));
        } catch (SQLException e){ e.printStackTrace();}
        return product;
    }

    public List<Product> getProductList(){
        List<Product> products = new ArrayList();
        PreparedStatement stm = null;


        try {
            stm = conn.prepareStatement("select * from " + table+" ;");
            ResultSet res = stm.executeQuery();

            while(res.next())
                products.add(new Product(res.getString(1),res.getString(2), res.getString(3), res.getString(3)));
        } catch (SQLException e){ e.printStackTrace();}
        return products;
    }

    public void closeDB(){
    }

}