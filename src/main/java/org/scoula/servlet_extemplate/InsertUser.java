package org.scoula.servlet_extemplate;
import dao.UserDaoImpl;
import domain.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/insertUser")
public class InsertUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        Integer age = Integer.valueOf(request.getParameter("age"));
        String password = request.getParameter("password");


        UserVO user = new UserVO();
        user.setName(name);
        user.setEmail(email);
        user.setAge(age);
        user.setPassword(password);

        UserDaoImpl userDaoImpl = new UserDaoImpl();
        int result = userDaoImpl.insert(user);

        if(result >0){
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("insertUser.jsp").forward(request, response);
    }

}
