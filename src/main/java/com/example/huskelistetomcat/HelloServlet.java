//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.huskelistetomcat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(
        name = "helloServlet",
        value = {"/hello-servlet"}
)
public class HelloServlet extends HttpServlet {
    private String message;

    public static List<User> users = new ArrayList<>();

    public HelloServlet() {
    }

    public void init() {
        this.message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String pass1 = request.getParameter("pass1");
        String pass2 = request.getParameter("pass2");

        this.log(pass1 + " " + pass2);

        PrintWriter out = response.getWriter();

        if (pass1.equals(pass2)) {
            HttpSession session = request.getSession();
            String navn = request.getParameter("name");
            session.setAttribute("navn", navn);

            users.add(new User(navn,pass1,request.getRequestedSessionId()));

            EmneTilfoej.emneListe = EmneTilfoej.emneNavne();
            session.setAttribute("emneListe", EmneTilfoej.emneListe);
            request.getRequestDispatcher("WEB-INF/BrugerSide.jsp").forward(request, response);
        } else {
            request.setAttribute("msg", "De to passwords var ikke ens!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    public void destroy() {
    }
}
