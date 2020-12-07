package cba.service.impl;

import java.util.List;

import com.google.gson.Gson;

import cba.dao.impl.OrderDaoImpl;
import cba.entity.Order;

public class OrderServiceImpl {
	private OrderServiceImpl() {
		
	}
	private static OrderServiceImpl impl=new OrderServiceImpl();
	public static OrderServiceImpl getInstance() {
		return impl;
	}
	
	public String getOrders(int userId) {
		OrderDaoImpl impl = OrderDaoImpl.getInstance();
		List<Order> list =impl.getOrders(userId);
		return new Gson().toJson(list);
	}
	public int  changeState(String state,int orderId) {
		OrderDaoImpl impl = OrderDaoImpl.getInstance();
		return impl.changeState(state, orderId);
	}

}
