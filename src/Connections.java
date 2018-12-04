import java.sql.*;

class JDBCUtil{
    static {
        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        Connection con = null;
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mlgb","root","j15968380173");
        }catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }

    public static void close(ResultSet rs,Statement statement,Connection con) {
        try{
            if (statement!= null)
                statement.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        try{
            if (con!=null)
                con.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}