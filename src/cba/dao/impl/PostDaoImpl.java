package cba.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cba.entity.Post;
import cba.utils.DBUtil;

public class PostDaoImpl {
	private static PostDaoImpl impl = new PostDaoImpl();

	private PostDaoImpl() {

	}

	public static PostDaoImpl getInstance() {
		return impl;
	}

	public List<Post> getPosts(int userId) {
		List<Post> list = new ArrayList<Post>();
		Connection con = DBUtil.getConnection();
		String sql = "select * from post where user_id =?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			while (rs.next()) {
				Post post = new Post();
				post.setPostId(rs.getInt("post_id") );
				post.setUserId(rs.getInt("user_id"));
				post.setPostText(rs.getString("post_text"));
				post.setPostTitle(rs.getString("post_title"));
				list.add(post);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs,rs, ps, con);
		}
		return list;
	}
}
