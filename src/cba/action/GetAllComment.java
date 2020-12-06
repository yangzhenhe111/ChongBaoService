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

@WebServlet("/GetAllComment")
public class GetAllComment extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        DBUtil dbUtillrz = new DBUtil();
        int postid = Integer.parseInt(req.getParameter("post_id"));
        System.out.println(postid);
        try {
            ResultSet resultSet = dbUtillrz.queryDate("select user.user_name,comment_id,comment_time,comments,user.user_id,user.user_picture_path from comment,user where comment.user_id=user.user_id and post_id ='"+postid+"' ORDER BY comment_time DESC");
            JSONArray jsonArray = new JSONArray();
            while (resultSet.next()){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("comment_id",resultSet.getString("comment_id"));
                jsonObject.put("comment_time",resultSet.getString("comment_time"));
                jsonObject.put("comments",resultSet.getString("comments"));
                jsonObject.put("user_id",resultSet.getString("user_id"));
                jsonObject.put("user_name",resultSet.getString("user_name"));
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
