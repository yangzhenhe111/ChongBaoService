package cba.service.impl;

import java.util.List;


import cba.dao.impl.PetDaoImpl;
import cba.entity.Pet;
import com.google.gson.Gson;

public class PetServiceImpl {
private PetServiceImpl() {
	
};
private static PetServiceImpl impl=new PetServiceImpl();
public static PetServiceImpl getInstance() {
	return impl;
}
public String getPets(int userId) {
	PetDaoImpl impl = PetDaoImpl.getInstance();
	List<Pet> list = impl.getPets(userId);
	return new Gson().toJson(list);
}
}
