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

@WebServlet("/GetPostByIDServlet")
public class GetPostByIDServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        DBUtil dbUtil = new DBUtil();
        try {
            ResultSet resultSet;
            String sql = "select post_id,post_title,post_time,number_likes,number_comments,picture_path from post where user_id="+id+" ORDER BY post_time DESC";
            resultSet = dbUtil.queryDate(sql);
            JSONArray jsonArray = new JSONArray();
            while (resultSet.next()){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("post_id",resultSet.getString("post_id"));
                jsonObject.put("likes",resultSet.getString("number_likes"));
                jsonObject.put("comments",resultSet.getString("number_comments"));
                jsonObject.put("post_title",resultSet.getString("post_title"));
                jsonObject.put("post_time",resultSet.getString("post_time"));
                jsonObject.put("picture_path",resultSet.getString("picture_path"));
                jsonArray.add(jsonObject);
            }
            response.getWriter().write(jsonArray.toString());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
