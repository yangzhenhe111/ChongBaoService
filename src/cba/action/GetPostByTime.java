package cba.action;

import cba.utils.DBUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/GetPostByTime")
public class GetPostByTime extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        DBUtil dbUtil = new DBUtil();
        int i = Integer.parseInt(req.getParameter("i"));
        System.out.println(i);
        try {
            ResultSet resultSet;
            if (i==1){
                String sql = "select user.user_picture_path,post_id,post_title,post_text,post_time,name,user_name,number_likes,number_comments,number_reprints,post.picture_path from post,user where post.user_id = user.user_id ORDER BY post_time DESC";
                resultSet = dbUtil.queryDate(sql);
                JSONArray jsonArray = new JSONArray();
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
                resp.getWriter().write(jsonArray.toString());
            }
            if (i==3){
                String sql = "select user.user_picture_path,post_id,post_title,post_text,post_time,name,user_name,number_likes,number_comments,number_reprints,post.picture_path from post,user where post.user_id = user.user_id ORDER BY number_likes DESC";
                resultSet = dbUtil.queryDate(sql);
                JSONArray jsonArray = new JSONArray();
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
                resp.getWriter().write(jsonArray.toString());
            }
            if (i==2){
                String sql = "select user.user_picture_path,post_id,post_title,post_text,post_time,name,user_name,number_likes,number_comments,number_reprints,post.picture_path from post,user where post.user_id = user.user_id ORDER BY number_comments DESC";
                resultSet = dbUtil.queryDate(sql);
                JSONArray jsonArray = new JSONArray();
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
                resp.getWriter().write(jsonArray.toString());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
