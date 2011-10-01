/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package padroesprojeto.prototype;

import java.util.Vector;

/**
 *
 * @author ana
 */
public class UserAccount implements Cloneable {

    private String userName, password, fname, lname;
    private Vector permissions = new Vector();

    public void setUserName(String uName) {
        userName = uName;
    }

    public void setPassword(String pwd) {
        password = pwd;
    }

    public void setFName(String name) {
        fname = name;
    }

    public void setLName(String name) {
        lname = name;
    }

    public void setPermissions(Vector rights) {
        permissions = rights;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFName() {
        return fname;
    }

    public String getLName() {
        return lname;
    }

    public Vector getPermissions() {
        return permissions;
    }

    @Override
    public Object clone() { //Shallow Copy
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
