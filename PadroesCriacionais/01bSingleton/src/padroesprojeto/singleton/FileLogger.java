/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package padroesprojeto.singleton;

/**
 *
 * @author ana
 */
public class FileLogger implements Logger {

    private static FileLogger logger;

    public FileLogger(){
    }

    public static FileLogger getFileLogger(){
        if(logger == null){
            logger = new FileLogger();
        }
        return logger;
    }
    public synchronized void log(String msg) {
        FileUtil futil = new FileUtil();
        futil.writeToFile("src/log.txt", msg);
    }
}
