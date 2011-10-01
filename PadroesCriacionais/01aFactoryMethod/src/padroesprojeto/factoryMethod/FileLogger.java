/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package padroesprojeto.factoryMethod;

/**
 *
 * @author ana
 */
public class FileLogger implements Logger {

    public void log(String msg) {
        FileUtil futil = new FileUtil();
        futil.writeToFile("src/log.txt", msg);
    }
}
