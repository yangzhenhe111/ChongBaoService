package cba.action;

import cba.utils.DBUtil;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/PostComment")
public class PostComment extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        DBUtil dbUtil = new DBUtil();
        int post_id = Integer.parseInt(req.getParameter("post_id"));
        String comment = req.getParameter("comment");
        int user_id = Integer.parseInt(req.getParameter("user_id"));
        String comment_time = req.getParameter("comment_time");
        System.out.println("post_id:"+post_id+"评论内容:"+comment+"user_id:"+user_id+"评论时间:"+comment_time);
        try {
            int n = dbUtil.addDataToTable("insert into comment (comment_time,comments,user_id,post_id) values ('"+comment_time+"','"+comment+"','"+user_id+"','"+post_id+"')");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("judge",n);
            if (n==1){
                System.out.println("成功插入");
            }else {
                System.out.println("插入失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
