package cba.utils;

import java.sql.*;

public class DBUtil {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // 1.获取驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2.获取connection
            connection = DriverManager.getConnection("jdbc:mysql://8.131.233.21:3306/pet", "root", "chongbao666");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 3.返回
        return connection;

    }

    public static void close(ResultSet rs2, ResultSet rs, PreparedStatement ps, Connection cn) {
        try {
            if(rs2!=null) {
                rs2.close();
            }
            if(rs!=null) {
                rs.close();
            }
            if(ps!=null) {
                ps.close();
            }
            if(cn!=null) {
                cn.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public ResultSet queryDate(String sql) throws ClassNotFoundException, SQLException {
        // 连接到数据库
        getConnection();
        Statement stmt = getConnection().createStatement();
        // 执行查询
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }

    public int addDataToTable(String sql) throws ClassNotFoundException, SQLException {
        // 连接到数据库
        getConnection();
        Statement stmt = getConnection().createStatement();
        return stmt.executeUpdate(sql);
    }

    public int updateData(String sql) throws ClassNotFoundException, SQLException {
        // 连接到数据库
        getConnection();
        Statement stmt = getConnection().createStatement();
        return stmt.executeUpdate(sql);
    }
}
