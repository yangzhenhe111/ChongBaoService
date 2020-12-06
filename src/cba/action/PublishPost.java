package cba.action;

import cba.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/PublishPost")
public class PublishPost extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        DBUtil dbUtillrz = new DBUtil();
        int postid = Integer.parseInt(req.getParameter("postid"));
        int userid = Integer.parseInt(req.getParameter("userid"));
        String title = req.getParameter("title");
        String conetent = req.getParameter("content");
        String time = req.getParameter("time");
        String imgpath = req.getParameter("imgpath");
        DBUtil dbUtil = new DBUtil();
        try {
            int n = dbUtil.addDataToTable("insert into post (post_id,user_id,post_title,post_text,post_time) values ('"+postid+"','"+userid+"','"+title+"','"+conetent+"','"+time+"')");
            if (n==1){
                resp.getWriter().write("true");
                System.out.println("成功");
            }else {
                resp.getWriter().write("false");
                System.out.println("失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
