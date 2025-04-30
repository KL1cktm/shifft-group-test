package by.korona.communicationform;

import by.korona.communicationform.dto.Message;
import by.korona.communicationform.service.DefaultMessageService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/wall")
public class WallServlet  extends HttpServlet {

    private final DefaultMessageService messageService=new DefaultMessageService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        List<Message> messages=messageService.findAll();
        getServletContext().setAttribute("messages", messages);
        request.getRequestDispatcher("messages.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session=request.getSession();
        Object name=session.getAttribute("name");
        if(name==null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }else {
            String message = request.getParameter("message");
            messageService.add(new Message(LocalDateTime.now(), (String) name, message));
            response.sendRedirect("messages.jsp");
        }
    }
}
