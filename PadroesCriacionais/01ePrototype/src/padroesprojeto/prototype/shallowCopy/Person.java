/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package padroesprojeto.prototype.shallowCopy;

/**
 *
 * @author ana
 */
public class Person implements Cloneable {

    private Car car; //referência a um objeto
    private String name;

    public Person(String s, String t) {
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
    public Object clone() {//shallow copy
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
