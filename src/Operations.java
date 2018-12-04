import java.sql.*;
public class Operations {
public void Operate()throws Exception{
    Connection con = JDBCUtil.getConnection();
    Fuctions main = new Fuctions(con);
        main.createWareHouse();
        main.insertWareHouse();
        main.createBuyer();
        main.insertBuyer();
        main.createDepartment();
        main.insertDepartment();
        main.createStaff();
        main.insertStaffs();
        main.createGoods();
        main.insertGoods();
        System.out.println("-------Create the database successfully!------\n--------We will test database now!---------\n"
                +"超市仓库相关信息:");
        main.selectWareHouse();
        System.out.println("----删除操作后：");
        main.deleteWareHouse();
        main.selectWareHouse();
        main.updateWareHouse();
        System.out.println("----更新操作后：");
        main.selectWareHouse();

}
}
