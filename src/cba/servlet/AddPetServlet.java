package cba.servlet;

import cba.entity.Pet;
import cba.service.impl.PetServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/AddPetServlet")
public class AddPetServlet extends HttpServlet {
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

        PetServiceImpl petService = PetServiceImpl.getInstance();
        boolean b = petService.AddPet(pet);
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
