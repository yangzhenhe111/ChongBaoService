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

@WebServlet("/GetAllPostServlet")
public class GetAllPostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        DBUtil dbUtillrz = new DBUtil();
        try {
            ResultSet resultSet = dbUtillrz.queryDate("select user.user_picture_path,post_id,post_title,post_text,post_time,name,user_name,number_likes,number_comments,number_reprints,post.picture_path from post,user where user.user_id = post.user_id");
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
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
