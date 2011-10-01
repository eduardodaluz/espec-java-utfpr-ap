/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package padroesprojeto.factoryMethod;

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
        Logger logger = factory.getLogger();
        logger.log("Uma mensagem para o log.");
    }

}
