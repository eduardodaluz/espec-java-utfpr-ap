/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package padroesprojeto.prototype;

/**
 *
 * @author ana
 */
public class AccountPrototypeFactory {

    private UserAccount accountRep;
    private UserAccount supervisor;

    public AccountPrototypeFactory(UserAccount supAccount, UserAccount aRep) {
        accountRep = aRep;
        supervisor = supAccount;
    }

    public UserAccount getAccountRep() {
        return (UserAccount) accountRep.clone();
    }

    public UserAccount getSupervisor() {
        return (UserAccount) supervisor.clone();
    }
}
