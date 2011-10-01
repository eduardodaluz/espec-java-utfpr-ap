/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package padroesprojeto.singleton;

/**
 *
 * @author ana
 */
public class LoggerTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LoggerFactory factory = new LoggerFactory();
        Logger logger1 = factory.getLogger();
        Logger logger2 = factory.getLogger();
        logger1.log("Uma primeira mensagem para o log.");
        logger2.log("Uma nova mensagem para o log.");
    }

}
