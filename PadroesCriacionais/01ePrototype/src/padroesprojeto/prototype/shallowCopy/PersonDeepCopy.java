/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package padroesprojeto.prototype.shallowCopy;

/**
 *
 * @author ana
 */
public class PersonDeepCopy implements Cloneable {

    private Car car; //referência a um objeto
    private String name;

    public PersonDeepCopy(String s, String t) {
        name = s;
        car = new Car(t);
    }

    public Car getCar() {
        return car;
    }

    public String getName() {
        return name;
    }

    public void setName(String s) {
        name = s;
    }

    @Override
    public Object clone() {//deep copy
        PersonDeepCopy p = new PersonDeepCopy(name, car.getName());
        return p;
    }
}
