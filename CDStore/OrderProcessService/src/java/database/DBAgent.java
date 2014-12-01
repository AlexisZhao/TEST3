package database;

/**
 * @author Fan Note: Parts of the source code(Methods: executeSQL,
 * getQueryResult) are from Ezilla (CSI5380Fall2009)
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBAgent {

    static Connection conn = null;
    static String SQLQUERIES_FILE = "database.SQLQueries";

    public DBAgent() {
        try {
            conn = getMySQLConn();
        } catch (NamingException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public static Connection getMySQLConn() throws SQLException,
            NamingException {
        Context jndiCntx = new InitialContext();
        DataSource ds = (DataSource) jndiCntx
                .lookup("java:comp/env/jdbc/mysqldb");
        return ds.getConnection();
    }

    public void beginTransaction() {
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void endTransaction() {
        try {
            conn.commit();
            conn.setAutoCommit(true);
            conn.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void rollback() {

        try {
            conn.rollback();
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    //This methods executes insert, update and delete SQL queries. 
    public int executeSQL(String queryid, String... args) {
        int result = -1;
        Statement s = null;
        try {
            /* Create the statement object */
            s = conn.createStatement();

            /* Get the SQL query from the properties files */
            String rawSqlSQL = java.util.ResourceBundle.getBundle(SQLQUERIES_FILE).getString(queryid);
            String sql = String.format(rawSqlSQL, args);

            /* Execute the sql query */
            result = s.executeUpdate(sql);
        } catch (Exception e) {
            System.err.println("Exception in executing SQL query: " + e.getMessage());
            e.getStackTrace();
        }
        return result;
    }

    public ResultSet getQueryResult(String queryid, String... args) {
        Statement s = null;
        ResultSet rs = null;
        try {
            s = conn.createStatement();

            String rawSql = java.util.ResourceBundle.getBundle(SQLQUERIES_FILE).getString(queryid);
            String sql = String.format(rawSql, args);

            rs = s.executeQuery(sql);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return rs;
    }
}
