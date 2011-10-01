/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package padroesprojeto.singleton;

/**
 *
 * @author ana
 */
public class ConsoleLogger implements Logger{

    public void log(String msg) {
        System.out.println(msg);
    }
}
