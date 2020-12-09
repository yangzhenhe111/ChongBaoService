package cba.service.impl;

import java.util.List;

import com.google.gson.Gson;

import cba.dao.impl.PostDaoImpl;
import cba.entity.Post;
import javafx.geometry.Pos;

public class PostServiceImpl {

	private PostServiceImpl() {

	}

	private static PostServiceImpl impl = new PostServiceImpl();

	public static PostServiceImpl getInstance() {
		return impl;
	}
	public String getPosts(int userId){
		PostDaoImpl impl = PostDaoImpl.getInstance();
		List<Post> list = impl.getPosts(userId);
		return new Gson().toJson(list);
	}
}
