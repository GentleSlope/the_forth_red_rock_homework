import java.sql.*;
public  class database{

    public static void main(String[] args) {
        try{
            Operations ope = new Operations();
            ope.Operate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Connection con = JDBCUtil.getConnection();
            Fuctions main = new Fuctions(con);
            JDBCUtil.close(main.getRs(),main.getStatement(),main.getCon());
        }
    }

}

