/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adjproject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nafiul
 */
public class ProductOperationMysql implements ProductOperation{

    @Override
    public List<Product> getAllProduct() {
        List<Product> productList=new ArrayList();
        
        try {
            Connection connection =DBConnection.getConnection();
            Statement statement=connection.createStatement();
            String sql="select * from product";
            ResultSet rs=statement.executeQuery(sql);
            
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                double price=rs.getDouble("price");
                
                Product product=new Product(id,name,price);
                productList.add(product);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductOperationMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return productList;
    }

    @Override
    public void insertProduct(Product product) {
        try {
            Connection connection =DBConnection.getConnection();
            Statement statement=connection.createStatement();
            String sql=String.format("insert into product values(%d,'%s',%f)",product.getProductId(),product.getProductName(),product.getProductPrice());
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ProductOperationMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @Override
    public void updateProduct(Product product) {
        try {
            Connection connection =DBConnection.getConnection();
            Statement statement=connection.createStatement();
            String sql=String.format("UPDATE product set name='%s',price=%f where id=%d",product.getProductName(),product.getProductPrice(),product.getProductId());
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ProductOperationMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void deleteProduct(Product product) {
        try {
            Connection connection =DBConnection.getConnection();
            Statement statement=connection.createStatement();
            String sql="DELETE FROM product where id="+product.getProductId();
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ProductOperationMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public Product getProduct(int id) {
        Product product=new Product();
        try {
            Connection connection =DBConnection.getConnection();
            Statement statement=connection.createStatement();
            String sql="select from product where id="+id;
            ResultSet rs=statement.executeQuery(sql);
            
            product.setProductId(id);
            product.setProductName(rs.getString("name"));
            product.setProductPrice(rs.getDouble("price"));
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductOperationMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return product;
        
    }
    
}
