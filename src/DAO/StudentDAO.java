package DAO;

import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {

    // ADD STUDENT
    public boolean addStudent(String name,
                              String course,
                              float marks) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "INSERT INTO students(name, course, marks) VALUES(?,?,?)";

            PreparedStatement pst =
                    con.prepareStatement(sql);

            pst.setString(1, name);
            pst.setString(2, course);
            pst.setFloat(3, marks);

            int rows = pst.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    // GET ALL STUDENTS
    public ResultSet getStudents() {

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql = "SELECT * FROM students";

            PreparedStatement pst =
                    con.prepareStatement(sql);

            return pst.executeQuery();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }

    // SEARCH STUDENT
    public ResultSet searchStudent(String keyword) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "SELECT * FROM students WHERE name LIKE ?";

            PreparedStatement pst =
                    con.prepareStatement(sql);

            pst.setString(1, "%" + keyword + "%");

            return pst.executeQuery();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }

    // DELETE STUDENT
    public boolean deleteStudent(int id) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "DELETE FROM students WHERE id=?";

            PreparedStatement pst =
                    con.prepareStatement(sql);

            pst.setInt(1, id);

            int rows = pst.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    // UPDATE STUDENT
    public boolean updateStudent(int id,
                                 String name,
                                 String course,
                                 float marks) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "UPDATE students SET name=?, course=?, marks=? WHERE id=?";

            PreparedStatement pst =
                    con.prepareStatement(sql);

            pst.setString(1, name);
            pst.setString(2, course);
            pst.setFloat(3, marks);
            pst.setInt(4, id);

            int rows = pst.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }
}