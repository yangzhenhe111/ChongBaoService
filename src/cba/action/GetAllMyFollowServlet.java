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

@WebServlet("/GetAllMyFollowServlet")
public class GetAllMyFollowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        DBUtil dbUtillrz = new DBUtil();
        try {
            ResultSet resultSet = dbUtillrz.queryDate("select user.user_id,user.user_name,user.user_picture_path,user.user_autograph from user where user.user_id in (select follow_id from follow where follow.user_id="+user_id+")");
            JSONArray jsonArray = new JSONArray();
            while (resultSet.next()){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("user_id",resultSet.getString("user_id"));
                jsonObject.put("user_name",resultSet.getString("user_name"));
                jsonObject.put("user_picture_path",resultSet.getString("user_picture_path"));
                jsonObject.put("user_autograph",resultSet.getString("user_autograph"));
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
