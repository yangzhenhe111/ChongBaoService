package cba.dao;

import cba.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private static UserDao cdi=new UserDao();
    private UserDao () {};
    public static UserDao getInstance() {
        return cdi;
    }
    //方法

    /**
     *
     * @param phone 通过输入的手机号判断用户是否存在
     * @return true 存在
     * false 不存在
     */
    public boolean isExist(String phone){
        Connection connection = DBUtil.getConnection();
        boolean b = false;
        String sql = "select * from user where user_phone=?;";
        PreparedStatement ps ;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,phone);
            ResultSet rs = ps.executeQuery();
            b = rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return b;
    }

    /**
     * 注册新用户
     * @param phone 注册用的手机号
     * @param pass 注册的密码
     * @return true 注册成功
     * false 注册失败
     */
    public boolean Register(String phone,String pass){
        Connection connection = DBUtil.getConnection();
        String sql = "insert into user(user_phone,user_password) values (?,?);";
        PreparedStatement ps ;
        int n = 0;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,phone);
            ps.setString(2,pass);
            System.out.println(sql);
            n = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(n > 0){
            return true;
        }
        return false;
    }
}
