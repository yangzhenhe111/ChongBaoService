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

@WebServlet("/GetIdPostServlet")
public class GetIdPostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        DBUtil dbUtillrz = new DBUtil();
        String id = request.getParameter("post_id");
        try {
            ResultSet resultSet = dbUtillrz.queryDate("select user.user_picture_path,user.user_phone,post.user_id,post_title,post_text,post_time,number_likes,number_comments,number_reprints,user_name,name,post.picture_path from post,user where post_id='"+id+"' and post.user_id = user.user_id");
            JSONArray jsonArray = new JSONArray();
            while (resultSet.next()){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("likes",resultSet.getString("number_likes"));
                jsonObject.put("comments",resultSet.getString("number_comments"));
                jsonObject.put("forwards",resultSet.getString("number_reprints"));
                jsonObject.put("user_id",resultSet.getString("user_id"));
                jsonObject.put("post_title",resultSet.getString("post_title"));
                jsonObject.put("post_text",resultSet.getString("post_text"));
                jsonObject.put("post_time",resultSet.getString("post_time"));
                jsonObject.put("post_topic",resultSet.getString("name"));
                jsonObject.put("phone",resultSet.getString("user_phone"));
                jsonObject.put("user_name",resultSet.getString("user_name"));
                jsonObject.put("img_path",resultSet.getString("picture_path"));
                jsonObject.put("user_picture_path",resultSet.getString("user_picture_path"));
                jsonArray.add(jsonObject);
            }
            response.getWriter().write(jsonArray.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
