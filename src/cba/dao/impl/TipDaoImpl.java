package cba.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import cba.utils.DBUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TipDaoImpl {
private TipDaoImpl() {
	
}
private static TipDaoImpl impl = new TipDaoImpl();
public static TipDaoImpl getInstance() {
	return impl;
}
public String getTips(int userId) {
	Connection cn= DBUtil.getConnection();
	ResultSet resultSet=null;
	String sql = "select user.user_picture_path,post_id,post_title,post_text,post_time,name,user_name,number_likes,number_comments,number_reprints,post.picture_path from post,user where  user.user_id = ? ORDER BY post_time DESC";
    PreparedStatement ps;
    JSONArray jsonArray = new JSONArray();
    System.out.println(sql);
	try {
		ps = cn.prepareStatement(sql);
		ps.setInt(1, userId);
	    resultSet = ps.executeQuery();  
	    while (resultSet.next()){
	        JSONObject jsonObject = new JSONObject();
	        jsonObject.put("post_id",resultSet.getString("post_id"));
	        jsonObject.put("likes",resultSet.getString("number_likes"));
	        jsonObject.put("comments",resultSet.getString("number_comments"));
	        jsonObject.put("forwards",resultSet.getString("number_reprints"));
	        jsonObject.put("post_title",resultSet.getString("post_title"));
	        jsonObject.put("post_text",resultSet.getString("post_text"));
	        jsonObject.put("post_time",resultSet.getString("post_time"));
	        jsonObject.put("post_topic",resultSet.getString("name"));
	        jsonObject.put("user_name",resultSet.getString("user_name"));
	        jsonObject.put("picture_path",resultSet.getString("picture_path"));
	        jsonObject.put("user_picture_path",resultSet.getString("user_picture_path"));
	         jsonArray.add(jsonObject);
	    }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return  jsonArray.toString();
}
}
