package cba.servlet;

import cba.entity.User;
import cba.service.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        InputStream in = request.getInputStream();
        byte[] buffer = new byte[256];
        int len = in.read(buffer);
        String jsonStr = new String(buffer, 0, len,"UTF-8");
        System.out.println(jsonStr);
        JSONObject jsonObject = new JSONObject(jsonStr);
        String userPhone = jsonObject.getString("userPhone");
        String password = jsonObject.getString("userPassword");
//        Gson gson = new GsonBuilder()
//                .serializeNulls()//序列化空值
//                .create();
//        User user = gson.fromJson(jsonStr,User.class);
//        System.out.println(user.toString());
//        String userPhone = user.getUserPhone();
//        String password = user.getUserPassword();

        System.out.println(userPhone);
        System.out.println(password);

        UserService userService = UserService.getInstance();
        boolean b = userService.isExist(userPhone);
        System.out.println(b);
        if(!b){
            if(userService.Register(userPhone,password)){
                response.getWriter().append("true");
            }else {
                response.getWriter().append("false");
            }
        }else{
            response.getWriter().append("用户已注册过，请登录！");
        }
    }
}
