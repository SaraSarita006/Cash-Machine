package Utils;

import java.sql.*;

public class DBUtils
{
    public static Connection getConn()
    {
        return DBHelper.connectDB();
    }

    public static Statement getStatement(Connection conn)
    {
        Statement stmt = null;
        try
        {
            stmt = conn.createStatement();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return stmt;
    }

    public static PreparedStatement getPStmt(Connection conn, String sql)
    {
        PreparedStatement pstmt = null;
        try
        {
            pstmt = conn.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return pstmt;
    }

    public static ResultSet getRs(Statement stmt, String sql)
    {
        try
        {
            return stmt.executeQuery(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static void executeUpdate(Statement stmt, String sql)
    {
        try
        {
            stmt.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static ResultSet exeuteQuery(Connection conn, String sql)
    {
        ResultSet rs = null;
        try
        {
            rs = conn.prepareStatement(sql).executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rs;
    }

    public static void close(Connection conn){
        if(conn!=null)
        {
            try
            {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    };

}
