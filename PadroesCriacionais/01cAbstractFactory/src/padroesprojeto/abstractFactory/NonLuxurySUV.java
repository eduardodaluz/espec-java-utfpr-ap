/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package padroesprojeto.abstractFactory;

/**
 *
 * @author ana
 */
public class NonLuxurySUV implements SUV {

    private String name;

    public NonLuxurySUV(String sName) {
        name = sName;
    }

    public String getSUVName() {
        return name;
    }

    public String getSUVFeatures() {
        return "Características do carro SUV popular.";
    }
}
