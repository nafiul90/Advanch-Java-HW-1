/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adjproject;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author nafiul
 */
public class ADJProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Product product = new Product(46,"logitech camera",2100);
        ProductOperation productOperation=new ProductOperationFile();
        productOperation.insertProduct(product);
        //productOperation.deleteProduct(product);
        //productOperation.updateProduct(product);
        List<Product> productList=productOperation.getAllProduct();
        
        for(Product pro:productList){
            System.out.println(pro);
        }
        
    }
    
}
