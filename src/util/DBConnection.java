package util;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection(){
        try{
            return  DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db",
                    "root", "Your_Password"); //change password according to your MySQL setup
            
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}



