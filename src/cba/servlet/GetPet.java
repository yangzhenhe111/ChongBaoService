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
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

@WebServlet("/GetPet")
public class GetPet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int petId = Integer.parseInt(request.getParameter("petId"));

        PetServiceImpl impl = PetServiceImpl.getInstance();
        String str = impl.getPet(petId);
        OutputStream out= response.getOutputStream();
        out.write(str.getBytes("utf-8"));
        System.out.println(str);

    }
}
