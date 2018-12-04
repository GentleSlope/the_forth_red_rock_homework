import java.sql.*;

public class demo {
    public static final String PASSWORDS = "j15968380173";
    public static final String USER = "root";
    public static final String DRIVER  = "com.mysql.cj.jdbc.Driver";
    public static final String URl = "jdbc:mysql://localhost:3306/mlgb";

    public static void main(String[] args) {
        try{
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(URl,USER,PASSWORDS);
            String sql = "select distinct sec,master,doctor,MBA,BD from mlgb.demo where sec like ? ";
             PreparedStatement pstmt = con.prepareStatement(sql);
             pstmt.setString(1,"%"+"HR"+"%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                String sec = rs.getString("sec");
                int master = rs.getInt("master");
                int doctor = rs.getInt("doctor");
                System.out.println(sec+"行业需要master"+master+"人 需要doctor" + doctor +"人");

            }
            rs.close();
            pstmt.close();
            con.close();

        }catch (Exception e)
        { e.printStackTrace(); }

    }



}
