package edu.elon.data;

import java.sql.*;
import java.util.ArrayList;

import edu.elon.business.User;

public class BookDB {

    public static int insert(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO User (FirstName, LastName, Email, BookTitle, DueDate, Overdue) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4,user.getTitle());
            ps.setString(5, user.getDueDate());
            ps.setString(6, user.getOverdue());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            SQLUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }


    public static int delete(String title) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "DELETE FROM User "
                + "WHERE BookTitle = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, title);

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            SQLUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }


    public static User selectUser(String title) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM User "
                + "WHERE BookTitle = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, title);
            rs = ps.executeQuery();
            User user = null;
            if (rs.next()) {
                user = new User();
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setEmail(rs.getString("Email"));
                user.setTitle(rs.getString("BookTitle"));
                user.setDueDate(rs.getString("DueDate"));
                user.setDueDate(rs.getString("Overdue"));
            }
            return user;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            SQLUtil.closeResultSet(rs);
            SQLUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static int update(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "UPDATE User SET "
                + "FirstName = ?, "
                + "LastName = ?, "
                + "Email = ?,"
                + "DueDate = ?,"
                + "Overdue = ?"
                + "WHERE BookTitle = ?"
                
                ;
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getDueDate());
            ps.setString(5, user.getOverdue());
            ps.setString(6, user.getTitle());


            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            SQLUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static ArrayList<User> selectUsers() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM User";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<User> users = new ArrayList<User>();
            while (rs.next())
            {
                User user = new User();
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setEmail(rs.getString("Email"));
                user.setTitle(rs.getString("BookTitle"));
                user.setDueDate(rs.getString("DueDate"));
                user.setOverdue(rs.getString("Overdue"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            SQLUtil.closeResultSet(rs);
            SQLUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }    
}