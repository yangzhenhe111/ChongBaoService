package cba.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cba.entity.Pet;
import cba.utils.DBUtil;

public class PetDaoImpl {
	private PetDaoImpl() {

	}
	private static PetDaoImpl impl = new PetDaoImpl();
	public static PetDaoImpl getInstance() {
		return impl;
	}
	public List<Pet> getPets(int userId){
		Connection cn = DBUtil.getConnection();
		String sql ="select * from pet where user_id =?";
		PreparedStatement ps = null;
		System.out.println(sql);
		ResultSet rs = null;
		List<Pet> list = new ArrayList<>();
		try {
			ps=cn.prepareStatement(sql);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			while (rs.next()) {
			Pet pet = new Pet();
			pet.setPetId(rs.getInt("pet_id"));
			pet.setPicturePath(rs.getString("picture_path"));
			pet.setPetName(rs.getString("pet_name"));
			pet.setPetType(rs.getString("pet_type"));
			pet.setPetAge(rs.getInt("pet_age"));
			pet.setPetWeight(rs.getString("pet_weight"));
			pet.setUserId(rs.getInt("user_id"));
			pet.setPetAutograph(rs.getString("pet_autograph"));
			list.add(pet);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(rs,rs, ps, cn);
		}
		return list;
	}
public Pet getPet(int petId){
	Connection cn = DBUtil.getConnection();
	String sql ="select * from pet where pet_id =?";
	PreparedStatement ps = null;
	System.out.println(sql);
	ResultSet rs=null;
	Pet pet= new Pet();
	try {
		ps = cn.prepareStatement(sql);
		ps.setInt(1,petId);
		rs= ps.executeQuery();
		while (rs.next()){
			pet.setPetId(petId);
			pet.setPicturePath(rs.getString("picture_path"));
			pet.setPetName(rs.getString("pet_name"));
			pet.setPetType(rs.getString("pet_type"));
			pet.setPetAge(rs.getInt("pet_age"));
			pet.setPetWeight(rs.getString("pet_weight"));
			pet.setUserId(rs.getInt("user_id"));
			pet.setPetAutograph(rs.getString("pet_autograph"));
		}
	} catch (SQLException throwables) {
		throwables.printStackTrace();
	}finally {
		DBUtil.close(rs,rs,ps,cn);
	}
	return  pet;
}
	/**
	 * 修改pet信息
	 * @param pet
	 * @return
	 */
	public boolean updataPet(Pet pet){
		Connection connection = DBUtil.getConnection();
		String sql = "update pet " +
				"set picture_path=?, pet_name=?, pet_type=?, pet_age=?,pet_autograph=? " +
				"where pet_id=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		int n = 0;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1,pet.getPicturePath());
			ps.setString(2,pet.getPetName());
			ps.setString(3,pet.getPetType());
			ps.setInt(4,pet.getPetAge());
			ps.setString(5,pet.getPetAutograph());
			ps.setInt(6,pet.getPetId());
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

	/**
	 * 添加pet信息
	 * @param pet
	 * @return
	 */
	public boolean addPet(Pet pet){
		Connection connection = DBUtil.getConnection();
		String sql = "insert into pet(picture_path,pet_name,pet_type,pet_age," +
				"pet_weight,pet_autograph,user_id) " +
				"values (?,?,?,?,'20',?,?);";
		PreparedStatement ps = null;
		ResultSet rs = null;
		int n = 0;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1,pet.getPicturePath());
			ps.setString(2,pet.getPetName());
			ps.setString(3,pet.getPetType());
			ps.setInt(4,pet.getPetAge());
			ps.setString(5,pet.getPetAutograph());
			ps.setInt(6,pet.getUserId());
			n = ps.executeUpdate();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}finally {
			DBUtil.close(rs,rs,ps,connection);
		}
		if(n > 0){
			return true;
		}else {
			return false;
		}

	}

	/**
	 * 删除
	 * @param petId
	 * @return
	 */

	public int deletePet(int petId) {
		Connection connection = DBUtil.getConnection();
		String sql = "delete from pet where pet_id=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		int n = 0;

		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, petId);
			n = ps.executeUpdate();
		} catch (SQLException var11) {
			var11.printStackTrace();
		} finally {
			DBUtil.close((ResultSet)rs, (ResultSet)rs, ps, connection);
		}

		return n;
	}
}
