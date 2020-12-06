package cba.action;

import cba.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/likes")
public class likes extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        DBUtil dbUtillrz = new DBUtil();
        int postid = Integer.parseInt(req.getParameter("post_id"));
        int nolike = Integer.parseInt(req.getParameter("likes"));
        DBUtil dbUtil = new DBUtil();
        try {
            int n = dbUtil.updateData("update post set number_likes = '"+nolike+"' where post_id = '"+postid+"'");
            if (n==1){
                resp.getWriter().write("true");
            }else {
                resp.getWriter().write("false");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
