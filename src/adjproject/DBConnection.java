/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adjproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nafiul
 */
public class DBConnection {

    private static Connection connection=null;
    private static DBConnection INSTANCE=new DBConnection();
    private DBConnection() {
        Properties properties = new Properties();
        try {
            InputStream inputStream = new FileInputStream("db.properties");
            properties.load(inputStream);
            
            String username=properties.get("username").toString();
            String password=properties.get("password").toString();
            String dbname=properties.get("dbname").toString();
            String hostname=properties.getProperty("hostname");
            String dburl="jdbc:mysql://"+hostname+"/"+dbname;
            
            connection=DriverManager.getConnection(dburl,username,password);
            
            

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getConnection(){
        return connection;
    }
    

}
