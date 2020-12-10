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

@WebServlet("/GetAllSortServlet")
public class GetAllSortServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String sortname = request.getParameter("sortname");
        int i = Integer.parseInt(request.getParameter("i"));
        System.out.println(sortname);
        System.out.println(i);
        DBUtil dbUtillrz = new DBUtil();
        try {
            ResultSet resultSet;
            if (i==1){
                resultSet = dbUtillrz.queryDate("select user.user_picture_path,post.picture_path,post_id,post_title,post_text,post_time,topic.name,user_name,number_likes,number_comments,number_reprints from post,user,topic where user.user_id = post.user_id and topic.name = post.name and topic.name= '"+sortname+"' ORDER BY post_time DESC");
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
                response.getWriter().write(jsonArray.toString());
            }
            if (i==2){
                resultSet = dbUtillrz.queryDate("select user.user_picture_path,post.picture_path,post_id,post_title,post_text,post_time,topic.name,user_name,number_likes,number_comments,number_reprints from post,user,topic where user.user_id = post.user_id and topic.name = post.name and topic.name= '"+sortname+"' ORDER BY number_comments DESC");
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
                response.getWriter().write(jsonArray.toString());
            }
            if (i==3){
                resultSet = dbUtillrz.queryDate("select user.user_picture_path,post.picture_path,post_id,post_title,post_text,post_time,topic.name,user_name,number_likes,number_comments,number_reprints from post,user,topic where user.user_id = post.user_id and topic.name = post.name and topic.name= '"+sortname+"' ORDER BY number_likes DESC");
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
                response.getWriter().write(jsonArray.toString());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
