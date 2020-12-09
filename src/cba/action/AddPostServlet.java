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

@WebServlet("/AddPostServlet")
public class AddPostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String user_id = request.getParameter("user_id");
        String post_time = request.getParameter("post_time");
        String post_topic = request.getParameter("post_topic");
        String post_title = request.getParameter("post_title");
        String post_text = request.getParameter("post_text");
        String number_like = request.getParameter("number_like");
        String number_comment = request.getParameter("number_comment");
        String number_forward = request.getParameter("number_forward");
        String img_path = "img1.jpg";
        DBUtil dbUtillrz = new DBUtil();
        try {
            int i;
            i = dbUtillrz.updateData("insert into post (user_id,post_title,post_text,number_likes,number_comments,number_reprints,picture_path,post_time,name) values ('"+user_id+"','"+post_title+"','"+post_text+"','"+number_like+"','"+number_comment+"','"+number_forward+"','"+img_path+"','"+post_time+"','"+post_topic+"')");
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
