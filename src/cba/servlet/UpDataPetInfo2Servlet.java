package cba.servlet;

import cba.entity.Pet;
import cba.entity.User;
import cba.service.UserService;
import cba.service.impl.PetServiceImpl;
import com.google.gson.Gson;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/UpDataPetInfo2Servlet")
public class UpDataPetInfo2Servlet extends HttpServlet {
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
        Gson gson = new Gson();
        Pet pet = gson.fromJson(jsonStr,Pet.class);
        System.out.println(pet.toString());
//        User user = new User();
//        JSONObject jsonObject = new JSONObject(jsonStr);
//        String userPhone = jsonObject.getString("userPhone");
//        String picturePath = jsonObject.getString("picturePath");
//        String userSex = jsonObject.getString("userSex");
//        String userBrithday = jsonObject.getString("userBrithday");
//        String userAutograph = jsonObject.getString("userAutograph");
//        String userName = jsonObject.getString("userName");
//
//        System.out.println(userPhone);
//        System.out.println(picturePath);
//
//        user.setUserPhone(userPhone);
//        user.setPicturePath(picturePath);
//        user.setUserSex(userSex);
//        user.setUserBrithday(userBrithday);
//        user.setUserAutograph(userAutograph);
//        user.setUserName(userName);

//        UserService userService = UserService.getInstance();
//        boolean b = userService.Updata(user);
        PetServiceImpl  petService = PetServiceImpl.getInstance();
        boolean b = petService.UpdataPet(pet);
        System.out.println(b);
        if(b){
            System.out.println("成功");
            response.getWriter().append("true");
        }else {
            System.out.println("失败");
            response.getWriter().append("false");
        }

    }
}
