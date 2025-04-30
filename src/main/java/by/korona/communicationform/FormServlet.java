package by.korona.communicationform;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/form")
public class FormServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session=request.getSession();
        String username=request.getParameter("username");
        if(username==null){
            username="Анонимус";
        }
        Object counter=session.getAttribute("counter");
        if (counter == null) {
            session.setAttribute("counter", 1);
            counter=1;
        } else {
            session.setAttribute("counter", ((Integer) counter) + 1);
        }
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<h1>Счётчик посещений "+counter+"<h1>");
        out.println("<h1>Привет, "+username+"</h1>");
        request.getRequestDispatcher("form.jsp").include(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name=request.getParameter("name");
        log.info("Username is {}", name);
        request.getSession().setAttribute("name", name);
        String email=request.getParameter("email");
        log.info("Email is {}", email);
        String phone=request.getParameter("phone");
        log.info("Phone is {}", phone);
        String gender=request.getParameter("gender");
        log.info("Gender is {}", gender);
        String message=request.getParameter("message");
        log.info("Message is {}", message);
        request.getRequestDispatcher("thanksForm.jsp").forward(request, response);
    }
}