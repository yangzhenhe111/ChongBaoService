package cba.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cba.entity.User;
import cba.utils.DBUtil;

public class UserDaoImpl {
	private static UserDaoImpl impl = new UserDaoImpl();

	private UserDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public static UserDaoImpl getInstance() {
		return impl;
	}

	public boolean isUser(String num, String pwd) {
		Connection cn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select user_password from user where user_phone = ?";
		
		try {

			ps = cn.prepareStatement(sql);
			ps.setString(1, num);
			rs = ps.executeQuery();
			while (rs.next()) {
				String spwd = rs.getString("user_password");
				if (spwd.equals(pwd)) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(rs,rs, ps, cn);
		}
		return false;
	}
	public User getUser(String phone) {
		Connection cn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="select * from user where user_phone=?";
		System.out.println(sql);
		User user = new User();
		try {
			ps =cn.prepareStatement(sql);
			ps.setString(1, phone);
			rs= ps.executeQuery();
			while (rs.next()) {
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setAccountAmount(rs.getDouble("account_amount"));
				user.setAccountNumber(rs.getString("account_number"));
				user.setPicturePath(rs.getString("user_picture_path"));
				user.setUserPassword(rs.getString("user_password"));
				user.setUserPhone(rs.getString("user_phone"));
				user.setUserAutograph(rs.getString("user_autograph"));
				return user;
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(rs,rs, ps, cn);
		}
		return user;
	}
}
