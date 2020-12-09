package cba.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cba.entity.Order;
import cba.utils.DBUtil;

public class OrderDaoImpl {
	private OrderDaoImpl() {

	}

	private static OrderDaoImpl impl = new OrderDaoImpl();

	public static OrderDaoImpl getInstance() {
		return impl;
	}
	
	public List<Order> getOrders(int userId){
		List<Order> list =new ArrayList<Order>();
		Connection cn = DBUtil.getConnection();
		String sql ="select * from orders where user_id=?";
		PreparedStatement ps =null;
		ResultSet rs = null;
		try {
			ps = cn.prepareStatement(sql);
			ps.setInt(1, userId);
			rs=ps.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setOrderId(rs.getInt("order_id"));
				order.setOrderStart(rs.getString("order_start"));
				order.setOrderEnd(rs.getString("order_end"));
				order.setPetId(rs.getInt("pet_id"));
				order.setAddresser(rs.getString("addresser"));
				order.setAddressee(rs.getString("addressee"));
				order.setPetShopContact(rs.getString("petshop_contact"));
				order.setRemarks(rs.getString("remarks"));
				order.setOrderAmount(rs.getString("order_amount"));
				order.setClientContact(rs.getString("client_contact"));
				order.setRunnerContact(rs.getString("runner_contact"));
				order.setRunnerName(rs.getString("runner_name"));
				order.setOrderTime(rs.getString("order_time"));
				order.setKilometers(rs.getString("kilometers"));
				order.setOrderState(rs.getString("order_state"));
				order.setUserId(rs.getInt("user_id"));
				order.setAddresseeContact(rs.getString("addressee_contact"));
				list.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(rs,rs, ps, cn);
		}
		return list;
	}
	public int  changeState(String state,int orderid) {
		Connection cn=DBUtil.getConnection();
		PreparedStatement ps =null;
		ResultSet rs = null;
		String sql="update orders set order_state =? where order_id=?";
		System.out.println(sql);
		try {
			ps = cn.prepareStatement(sql);
			ps.setString(1, state);
			ps.setInt(2, orderid);
			System.out.println(sql);
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(rs,rs, ps, cn);
		}
		return 6;
	}
}
