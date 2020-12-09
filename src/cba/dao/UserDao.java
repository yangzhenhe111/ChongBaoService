package cba.dao;

import cba.entity.User;
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

    /**
     * 修改个人信息
     * @param user 要修改的个人信息
     * @return true 修改成功
     * false 修改失败
     */
    public boolean upData(User user){
        Connection connection = DBUtil.getConnection();
        String sql = "update user " +
                "set user_name=?, user_sex=?, user_picture_path=?, user_brithday=?,user_autograph=? " +
                "where user_phone=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        int n = 0;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getUserSex());
            ps.setString(3,user.getPicturePath());
            ps.setString(4,user.getUserBrithday());
            ps.setString(5,user.getUserAutograph());
            ps.setString(6,user.getUserPhone());
            System.out.println(sql);
            n = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtil.close(rs,rs, ps, connection);
        }
        if(n > 0){
            return true;
        }
        return false;
    }
}
