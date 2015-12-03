package edu.elon.data;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author lawrencemullen && maddiechili
 */
public class ConnectionPool {

  private static ConnectionPool pool = null;
  private static DataSource dataSource = null;

    //Need to make sure that we are consistent and using the database
  // resouurce name used by openshift of jdbc/MySQLDA
  private ConnectionPool() {
    try {
      InitialContext ic = new InitialContext();
      dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/MySQLDS");
    } catch (NamingException e) {
      System.out.println(e);
    }
  }

    /**
     * creates an instance of the connection
     * @return the connection pool
     */
    public static synchronized ConnectionPool getInstance() {
    if (pool == null) {
      pool = new ConnectionPool();
    }
    return pool;
  }

    /**
     * creates a connection
     * @return null
     */
    public Connection getConnection() {
    try {
      return dataSource.getConnection();
    } catch (SQLException e) {
      System.out.println(e);
      return null;
    }
  }

    /**
     * frees connection to database
     * @param c
     */
    public void freeConnection(Connection c) {
    try {
      c.close();
    } catch (SQLException e) {
      System.out.println(e);
    }
  }
}
