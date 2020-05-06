package hanu.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class connect {
    private static String DB_URL = "jdbc:mysql://localhost:3306/ims_sqa?useSSL=FALSE";
    private static String USERNAME = "root";
    private static String PASSWORD = "123456";

    static Connection con=null;
    public static Connection getConnection()
    {
        if (con != null) return con;
        // get db, user, pass from settings file
        System.out.println("DB started at 3306?");
        return getConnection(DB_URL, USERNAME, PASSWORD);
    }

    private static Connection getConnection(String db_name,String user_name,String password)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(db_name+"&user="+user_name+"&password="+password);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return con;
    }
}







//    public static Connection getConnection() {
//        Connection connect = null;
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
//            System.out.println("Connect to MySQL database successfully!");
//        } catch (Exception e) {
//            System.out.println("Connect to MySQL database failed!");
//            e.printStackTrace();
//        }
//        return connect;
//    }
//}
