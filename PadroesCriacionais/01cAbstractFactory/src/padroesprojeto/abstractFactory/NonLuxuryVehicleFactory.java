/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package padroesprojeto.abstractFactory;

/**
 *
 * @author ana
 */
public class NonLuxuryVehicleFactory extends VehicleFactory {
    public Car getCar() {
        return new NonLuxuryCar("Carro popular");
    }
    public SUV getSUV() {
        return new NonLuxurySUV("SUV popular");
    }
}
