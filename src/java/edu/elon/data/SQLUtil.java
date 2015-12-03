   package edu.elon.data;

import java.sql.*;

/**
 *
 * @author lawrencemullen && maddiechili
 */
public class SQLUtil {

    /**
     * close the sql statement
     * @param s
     */
    public static void closeStatement(Statement s) {
        try {
            if (s != null) {
                s.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /**
     *close the prepared sql statement
     * @param ps
     */
    public static void closePreparedStatement(Statement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /**
     *close the result set 
     * @param rs
     */
    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}