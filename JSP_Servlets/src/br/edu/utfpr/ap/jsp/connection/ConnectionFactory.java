package br.edu.utfpr.ap.jsp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
    
    public static Connection getConnection() {
        try {
            Class.forName("org.firebirdsql.jdbc.FBDriver").newInstance();
            String url = "jdbc:firebirdsql:localhost/3050:/firebird/jspaulas.fdb?lc_ctype=ISO8859_1";
            Connection conn = DriverManager.getConnection(url,"SYSDBA","masterkey");
            return conn;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex ) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
