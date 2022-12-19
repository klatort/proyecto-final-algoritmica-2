/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libraries;
import java.io.*;

/**
 *
 * @author Fabo
 */
public class Persistencia {
    
    public static void serialize(Object obj, String nomArchivo){
        try {
            FileOutputStream fs = new FileOutputStream(nomArchivo + ".txt");
            
            ObjectOutputStream os = new ObjectOutputStream(fs);   
            os.writeObject(obj);
            os.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Los Objetos se han serializado correctamente.");
    }
    
    public static Object deserialize(String nomArchivo){
        try {
            FileInputStream fis = new FileInputStream(nomArchivo + ".txt");
            
            ObjectInputStream ois = new ObjectInputStream(fis);
            var aux = (Object)ois.readObject();
            ois.close();
            return aux;
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
}
