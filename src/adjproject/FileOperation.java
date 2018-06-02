/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adjproject;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nafiul
 */
public class FileOperation {
    
    private static File file=null;
    private final static FileOperation INSTANC=new FileOperation();
    private FileOperation(){
        
    }
    
    static File handleFile(){
        try {
            file=new File("data.txt");
            if(!file.exists())file.createNewFile();
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(FileOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return file;
    }
    
}
