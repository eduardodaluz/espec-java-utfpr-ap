/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package padroesprojeto.abstractFactory;

/**
 *
 * @author ana
 */
public class LuxuryCar implements Car {

    private String name;

    public LuxuryCar(String cName) {
        name = cName;
    }

    public String getCarName() {
        return name;
    }

    public String getCarFeatures() {
        return "Características do carro de luxo.";
    }
}
