package cba.servlet;

import cba.service.impl.PetServiceImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/DeletePetServlet"})
public class DeletePetServlet extends HttpServlet {
    public DeletePetServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int perId = Integer.valueOf(request.getParameter("petid"));
        System.out.println(perId);
        PetServiceImpl petService = PetServiceImpl.getInstance();
        boolean b = petService.deletePet(perId);
        System.out.println(b);
        if (b) {
            response.getWriter().append("true");
        } else {
            response.getWriter().append("false");
        }

    }
}
