package Utils;


import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.*;
import java.util.ArrayList;

public class DBHelper
{
    public static Connection connectDB() //generate the connection object according to the connection informations.
    {
        String driverClassName = "com.mysql.cj.jdbc.Driver"; // driver's information
        // just change the url, userName, pwd.
        String url = "jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";// here is the connection string for the mysql 8.0
        String userName = "root";
        String pwd = "2006";
        Connection conn = null;
        try
        {
            Class.forName(driverClassName).newInstance();
            conn = DriverManager.getConnection(url, userName,pwd);
            System.out.println("Connect Database Successfully.");
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    // get data from database by providing the tableName and the object Type.
    //this is a generic method, it can be used for any type data.
    public static <E> ArrayList<E> selectData(String tableName, E en) throws ClassNotFoundException
    {
        String className = en.getClass().getName();// get the data's type name
        ArrayList<E> resultSet = new ArrayList<E>();// prepare the list for the result.
        Connection conn = connectDB();// call teh connectDB() just we defined to get the connection object.
        QueryRunner runner = new QueryRunner();
        String sql = "select * from "+tableName;
        ArrayList<E> classList;
        try {
            classList = (ArrayList<E>)runner.query(conn,sql,new BeanListHandler(Class.forName(className)));
            for(E bean : classList)
            {
                resultSet.add(bean);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DbUtils.closeQuietly(conn);
        return resultSet;
    }

    public static Boolean ExcuteNoQuery(String sql, Object... params) {
        Connection conn = connectDB();
        int i = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            // 设置问号值
            for (int j = 0; j < params.length; j++) {
                Object object = params[j];
                ps.setObject(j + 1, object);
            }
            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i > 0;
    }

}
