/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package padroesprojeto.factoryMethod;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author ana
 */
public class FileUtil {

    public void writeToFile(String caminho, String msg) {
        File f = new File(caminho);
        try {
            if(!f.exists()){
                f.createNewFile();
            }
            FileWriter fw = new FileWriter(f,true);
            PrintWriter pw = new PrintWriter(fw);
            pw.append(msg);
            pw.println();
            pw.close();
            fw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
