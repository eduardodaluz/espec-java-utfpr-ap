/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package padroesprojeto.prototype.shallowCopy;

/**
 *
 * @author ana
 */
public class DeepCopyTest {
    public static void main(String[] args) {
        PersonDeepCopy p = new PersonDeepCopy("Pessoa-A","Civic");//objeto original
        System.out.println("Original (valores originais):"
                + p.getName() + " - " + p.getCar().getName());
        PersonDeepCopy q = (PersonDeepCopy) p.clone();//Clone como deep copy
        System.out.println("Clone (antes das mudanças): "
                + q.getName() + " - " + q.getCar().getName());
        q.setName("Pessoa-B");//mudando o atributo primitivo
        q.getCar().setName("Voyage");//mudando o objeto referenciado
        System.out.println("Clone (depois das mudanças): "
                + q.getName() + " - " + q.getCar().getName());
        System.out.println("Original (depois de mudar o clone): "
                + p.getName() + " - " + p.getCar().getName());
    }
}
