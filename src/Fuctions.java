import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

 public class  Fuctions {
        Connection con;
        Statement statement;
        ResultSet rs;

        public Connection getCon() {
            return con;
        }
        public Statement getStatement(){
            return statement;
        }

        public ResultSet getRs() {
            return rs;
        }
        public Fuctions(Connection con){
            this.con = con;
            try {
                statement = con.createStatement();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        public void createWareHouse() throws SQLException {
            String sql1 = "drop TABLE if exists warehouse";
            String sql =
                    "CREATE TABLE warehouse  (\n" +
                            "  `ID` int NOT NULL auto_increment PRIMARY KEY ,\n" +
                            "  `managerName` varchar(30) NOT NULL,\n" +
                            "  `phoneNumber` varchar (20) NOT NULL\n" +
                            "\n" +
                            ")";
            statement.executeUpdate(sql1);
            statement.executeUpdate(sql);
        }
        public void createBuyer() throws SQLException{
            String sql1 = "drop TABLE if exists buyer";
            String sql =
                    "CREATE TABLE buyer  (\n" +
                            "  `name` varchar(30) PRIMARY KEY ,\n" +
                            "  `address` varchar(30) NOT NULL,\n" +
                            "  `phoneNumber` varchar (20) NOT NULL\n" +
                            "\n" +
                            ")";
            statement.executeUpdate(sql1);
            statement.executeUpdate(sql);
        }
        public void createDepartment() throws SQLException{
            String sql1 = "drop TABLE if exists department";
            String sql =
                    "CREATE TABLE department  (\n" +
                            "  `ID` int NOT NULL auto_increment PRIMARY KEY ,\n" +
                            "  `Name` varchar(30) NOT NULL,\n" +
                            "  `price` varchar (20) NOT NULL,\n" +
                            "  `managername` varchar (20) NOT NULL,\n" +
                            "  `address` varchar (20) NOT NULL,\n" +
                            "  `phoneNumber` varchar (20) NOT NULL\n" +
                            "\n" +
                            ")";
            statement.executeUpdate(sql1);
            statement.executeUpdate(sql);
        }
        public void createGoods() throws SQLException{
            String sql1 = "drop TABLE if exists goods";
            String sql =
                    "CREATE TABLE goods  (\n" +
                            "  `ID` int NOT NULL auto_increment PRIMARY KEY ,\n" +
                            "  `Name` varchar(30) NOT NULL,\n" +
                            "  `cost` varchar (20) NOT NULL,\n" +
                            "  `pricr` varchar (20) NOT NULL,\n" +
                            "  `buyer` varchar (20) NOT NULL,\n" +
                            "  `Subdepar` varchar (20) NOT NULL,\n" +
                            "  `Depot` varchar (20) NOT NULL\n" +
                            "\n" +
                            ")";
            statement.executeUpdate(sql1);
            statement.executeUpdate(sql);
        }
        public void createStaff() throws SQLException{
            String sql1 = "drop TABLE if exists staff";
            String sql =
                    "CREATE TABLE staff  (\n" +
                            "  `ID` int NOT NULL auto_increment PRIMARY KEY ,\n" +
                            "  `name` varchar(30) NOT NULL,\n" +
                            "  `Position` varchar(30) NOT NULL,\n" +
                            "  `phoneNum` varchar (255) NOT NULL,\n" +
                            "  `address` varchar (20) NOT NULL,\n" +
                            "  `age` int (20) NOT NULL\n" +
                            "\n" +
                            ")";
            statement.executeUpdate(sql1);
            statement.executeUpdate(sql);
        }

        public void insertBuyer() throws SQLException {
            String sql1 = "insert into buyer values('Tom','北京','17358458653')";
            String sql2 = "insert into buyer values('Sam','上海','18324378571')";
            String sql3 = "insert into buyer values('Mike','广州','15968380173')";
            statement.execute(sql1);
            statement.execute(sql2);
            statement.execute(sql3);
        }
        public void insertDepartment() throws SQLException {
            String sql1 = "insert into department values(1,'Fresh_Department','100k$','Tom','北京','17358458653')";
            String sql2 = "insert into department values(2,'Store Department','121k$','Li','北京','18324378571')";
            String sql3 = "insert into department values(3,'Retail department','113k$','Wang','北京','17358458653')";
            statement.execute(sql1);
            statement.execute(sql2);
            statement.execute(sql3);
        }
        public void insertGoods() throws SQLException {
            String sql1 = "insert into goods values(1,'Fish','10','20','Tom','Fresh_Department','1')";
            String sql2 = "insert into goods values(2,'rice','2','3','Sam','Fresh_Department','1')";
            String sql3 = "insert into goods values(3,'beef','15','30','Mike','Fresh_Department','1')";
            String sql4 = "insert into goods values(4,'toy_car','20','46','Mike','Store Department','2')";
            String sql5 = "insert into goods values(5,'pencil','2','5','Sam','Retail department','2')";
            String sql6 = "insert into goods values(6,'Cosmetics','100','500','MIke','Store Department','3')";
            statement.execute(sql1);
            statement.execute(sql2);
            statement.execute(sql3);
            statement.execute(sql4);
            statement.execute(sql5);
            statement.execute(sql6);
        }
        public void insertWareHouse() throws SQLException {
            String sql1 = "insert into warehouse values(1,'Tom','17358458653')";
            String sql2 = "insert into warehouse values(2,'Sam','18324378571')";
            String sql3 = "insert into warehouse values(3,'Mike','15968380173')";
            statement.execute(sql1);
            statement.execute(sql2);
            statement.execute(sql3);
        }
        public void insertStaffs() throws SQLException {
            String sql1 = "insert into staff values('1','zhou','Staff member','17358458653','北京',22)";
            String sql2 = "insert into staff values(2,'Sam','Manager','18324378571','上海',32)";
            String sql3 = "insert into staff values(3,'Mike','Manager','15924378571','上海',32)";
            String sql4 = "insert into staff values(4,'Tom','Manager','18924378571','广州',35)";
            statement.execute(sql1);
            statement.execute(sql2);
            statement.execute(sql3);
            statement.execute(sql4);
        }

        public void deleteWareHouse() throws SQLException{
            String sql = "delete from warehouse where id = 1";
            statement.execute(sql);

        }
        public void updateWareHouse() throws SQLException{
            String sql = "update warehouse set managerName = 'James' where id = 2";
            statement.execute(sql);
        }
        public void selectWareHouse() throws SQLException {
            String sql = "select ID,managerName,phoneNumber from warehouse";
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("ID");
                String name = rs.getString("managername");
                String phone = rs.getString("phoneNumber");
                System.out.println("负责人编号："+id+"\t"+"负责人姓名"+name+"\t"+"负责人电话："+phone+"\n" );
            }
        }

    }
