/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package padroesprojeto.abstractFactory;

/**
 *
 * @author ana
 */
public class LuxuryVehicleFactory extends VehicleFactory {
    public Car getCar() {
        return new LuxuryCar("Carro de luxo");
    }
    public SUV getSUV() {
        return new LuxurySUV("SUV de luxo");
    }
}
