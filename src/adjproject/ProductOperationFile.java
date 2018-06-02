/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adjproject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nafiul
 */
public class ProductOperationFile implements ProductOperation {

    @Override
    public List<Product> getAllProduct() {
        List<Product> productList = new ArrayList();

        File file = FileOperation.handleFile();
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String str = sc.nextLine();
                String parts[] = str.split("#");
                Product product = new Product(Integer.parseInt(parts[0]), parts[1], Double.parseDouble(parts[2]));
                productList.add(product);
            }

        } catch (IOException ex) {
            Logger.getLogger(ProductOperationFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        return productList;
    }

    @Override
    public void insertProduct(Product product) {

        try {
            File file = FileOperation.handleFile();
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(product.getProductId() + "#" + product.getProductName() + "#" + product.getProductPrice() + "\n");
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(ProductOperationFile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void updateProduct(Product product) {
        List<Product> productList = new ArrayList();
        productList = getAllProduct();

        for (Product pro : productList) {
            if (pro.getProductId() == product.getProductId()) {
                pro.setProductName(product.getProductName());
                pro.setProductPrice(product.getProductPrice());
            }
        }

        File file = FileOperation.handleFile();
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            
            FileWriter fileWriter=new FileWriter(file);
            for(Product pro: productList){
                fileWriter.write(pro.getProductId()+"#"+pro.getProductName()+"#"+pro.getProductPrice()+"\n");
                
            }
            fileWriter.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ProductOperationFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteProduct(Product product) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Product> productList = new ArrayList();
        productList = getAllProduct();

        for (Product pro : productList) {
            if (pro.getProductId() == product.getProductId()) {
                productList.remove(pro);
                break;
            }
        }
        
        File file = FileOperation.handleFile();
        try {
            if(!file.exists()) {
                file.createNewFile();
            }
            
            FileWriter fileWriter=new FileWriter(file);
            for(Product pro: productList){
                fileWriter.write(pro.getProductId()+"#"+pro.getProductName()+"#"+pro.getProductPrice()+"\n");
                
            }
            fileWriter.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ProductOperationFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }

    @Override
    public Product getProduct(int id) {
        List<Product> productList = new ArrayList();
        productList = getAllProduct();
        Product product=new Product();

        for (Product pro : productList) {
            if (pro.getProductId() == product.getProductId()) {
                product=pro;
                break;
            }
        }
        return product;
    }

}
