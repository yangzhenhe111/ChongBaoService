package cba.service.impl;

import cba.dao.impl.TipDaoImpl;

public class TipServiceImpl {
private TipServiceImpl() {
	
}
private static TipServiceImpl impl= new TipServiceImpl();
public static TipServiceImpl getInstance() {
	return impl;
}
public String getTips(int userId) {
	TipDaoImpl impl = TipDaoImpl.getInstance();
	return impl.getTips(userId);
}
}
