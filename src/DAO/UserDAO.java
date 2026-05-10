
package DAO;

import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    // REGISTER
    public boolean register(String username, String password) {

        try {
            Connection con = DBConnection.getConnection();

            // check existing user
            String checkSql = "SELECT * FROM users WHERE username=?";

            PreparedStatement checkPst = con.prepareStatement(checkSql);

            checkPst.setString(1, username);

            ResultSet rs = checkPst.executeQuery();

            if(rs.next()) {
                return false;
            }

            // insert user
            String sql = "INSERT INTO users(username, password) VALUES(?, ?)";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, username);
            pst.setString(2, password);

            int rows = pst.executeUpdate();

            return rows > 0;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // LOGIN
    public boolean login(String username, String password) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM users WHERE username=? AND password=?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            return rs.next();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
