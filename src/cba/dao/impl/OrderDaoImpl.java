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

	public int insertOrder(Order order){
		Connection connection = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into orders(order_start,order_end,pet_id,addresser,addressee,petshop_contact,remarks,order_amount," +
				"client_contact,runner_contact,runner_name,order_time,kilometers,order_state,user_id,addressee_contact,iteminfo) " +
				"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		int n = 0;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1,order.getOrderStart());
			ps.setString(2,order.getOrderEnd());
			ps.setInt(3,2);
			ps.setString(4,order.getAddresser());
			ps.setString(5,order.getAddressee());
			ps.setString(6,order.getPetShopContact());
			ps.setString(7,order.getRemarks());
			ps.setInt(8,Integer.valueOf(order.getOrderAmount()));
			ps.setString(9,order.getClientContact());
			ps.setString(10,order.getRunnerContact());
			ps.setString(11,order.getRunnerName());
			ps.setString(12,order.getOrderTime());
			ps.setString(13,order.getKilometers());
			ps.setString(14,order.getOrderState());
			ps.setInt(15,order.getUserId());
			ps.setString(16,order.getAddresseeContact());
			ps.setString(17,order.getIteminfo());
			n = ps.executeUpdate();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return n;
	}
}
