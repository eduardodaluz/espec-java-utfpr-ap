/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package padroesprojeto.prototype;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 *
 * @author ana
 */
public class AccountManager {

    private Vector supervisorPermissions, accountRepPermissions;
    private AccountPrototypeFactory factory;

    private static Vector getPermissionsFromFile(String fileName) {
        File f = new File("src/" + fileName);
        Vector result = new Vector();
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            line = br.readLine();
            while (line != null) {
                result.add(line);
                line = br.readLine();
            }
            br.close();
            fr.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    private void buildPrototype() {
        supervisorPermissions = getPermissionsFromFile("supervisor.txt");
        UserAccount supervisor = new UserAccount();
        supervisor.setPermissions(supervisorPermissions);
        accountRepPermissions = getPermissionsFromFile("accountrep.txt");
        UserAccount accountRep = new UserAccount();
        accountRep.setPermissions(accountRepPermissions);
        factory = new AccountPrototypeFactory(supervisor, accountRep);
    }

    private UserAccount createSupervisorAccount(String un, String pwd, String fn, String ln) {
        UserAccount newSupervisor = factory.getSupervisor(); //criando um supervisor
        newSupervisor.setUserName(un);
        newSupervisor.setPassword(pwd);
        newSupervisor.setFName(fn);
        newSupervisor.setLName(ln);
        return newSupervisor;
    }

    private UserAccount createAccountRep(String un, String pwd, String fn, String ln) {
        UserAccount newAccountRep = factory.getAccountRep();
        newAccountRep.setUserName(un);
        newAccountRep.setPassword(pwd);
        newAccountRep.setFName(fn);
        newAccountRep.setLName(ln);
        return newAccountRep;
    }

    public static void main(String[] args) {
        AccountManager am = new AccountManager();
        am.buildPrototype(); //constrói os protótipos com as permissões
        UserAccount sup1 = am.createSupervisorAccount("admin", "admin", "Joao", "da Silva");
        UserAccount sup2 = am.createSupervisorAccount("root", "root", "maria", "da silva");
        UserAccount com1 = am.createAccountRep("default", "default", "Jose", "de Souza");
        UserAccount com2 = am.createAccountRep("local", "local", "Joana", "de Souza");
        System.out.println(sup1.getPermissions());
        System.out.println(sup2.getPermissions());
        System.out.println(com1.getPermissions());
        System.out.println(com2.getPermissions());
    }
}
