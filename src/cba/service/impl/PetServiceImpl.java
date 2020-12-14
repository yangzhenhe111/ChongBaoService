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

	/**
	 * 修改pet信息
	 * @param pet
	 * @return
	 */
	public boolean UpdataPet(Pet pet){
		PetDaoImpl petDao = PetDaoImpl.getInstance();
		boolean b = petDao.updataPet(pet);
		return b;
	}

	/**
	 * 添加pet信息
	 * @param pet
	 * @return
	 */
	public boolean AddPet(Pet pet){

		PetDaoImpl petDao = PetDaoImpl.getInstance();
		boolean b = petDao.addPet(pet);
		return b;
	}


	public boolean deletePet(int petId) {
		PetDaoImpl petDao = PetDaoImpl.getInstance();
		int n = petDao.deletePet(petId);
		return n > 0;
	}
}
