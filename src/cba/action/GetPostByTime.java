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
        try {
            ResultSet resultSet;
            String sql = "select post_id,post_title,post_time,number_likes,number_comments,picture_path from post ORDER BY post_time DESC";
            System.out.println("1");
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
            resp.getWriter().write(jsonArray.toString());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
