/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package padroesprojeto.abstractFactory;

/**
 *
 * @author ana
 */
public class NonLuxuryCar implements Car {

    private String name;

    public NonLuxuryCar(String cName) {
        name = cName;
    }

    public String getCarName() {
        return name;
    }

    public String getCarFeatures() {
        return "Características do carro popular.";
    }
}
