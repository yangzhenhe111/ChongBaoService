package cba.action;

import cba.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/DeleteFollowServlet")
public class DeleteFollowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        int follow_id = Integer.parseInt(request.getParameter("follow_id"));
        DBUtil dbUtillrz = new DBUtil();
        try {
            int i;
            i = dbUtillrz.updateData("delete from follow where user_id="+user_id+" and follow_id="+follow_id);
            if (i>0){
                response.getWriter().write("true");
            }else{
                response.getWriter().write("false");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
