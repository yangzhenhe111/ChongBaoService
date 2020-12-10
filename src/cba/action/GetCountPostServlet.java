package cba.action;

import cba.utils.DBUtil;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/GetCountPostServlet")
public class GetCountPostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String i = "0";
        DBUtil dbUtil = new DBUtil();
        try {
            ResultSet resultSet;
            String sql = "select count(*) from post";
            resultSet = dbUtil.queryDate(sql);
            JSONObject jsonObject = new JSONObject();
            while (resultSet.next()){
                i = String.valueOf(resultSet.getInt("count(*)"));
            }
            response.getWriter().write(jsonObject.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
