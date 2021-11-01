//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.huskelistetomcat;

import DBAccess.ConnectionConfiguration;
import DBAccess.Liste;

import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(
        name = "Emnetilføoej",
        value = {"/Emnetilføoej"}
)
public class EmneTilfoej extends HttpServlet {

    public static Set emneListe;

    public EmneTilfoej() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        emneListe = (Set) session.getAttribute("emneListe");

        if (emneListe == null) {
            emneListe = new LinkedHashSet<>();
        }

        emneListe = emneNavne();
        session.setAttribute("emneListe", emneListe);

        String emne = request.getParameter("emne");

        System.out.println(emneListe);

        emneListe.add(emne);

        List<String> emneArrayList = new ArrayList<>(emneListe);

        Liste.tilfoejEmne(new Emne(emneArrayList.get(emneArrayList.size()-1)));

        for (User u : HelloServlet.users) {
            if (request.getRequestedSessionId().equals(u.getSessionID())){
                u.getEmner().add(emne);
            }
            System.out.println(Arrays.toString(u.getEmner().toArray()));
        }

        request.getRequestDispatcher("WEB-INF/BrugerSide.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    public static Set<String> emneNavne(){
        Set<String> emneNameList = new LinkedHashSet<>();

        for (Emne e : hentEmner() ) {
            emneNameList.add(e.getNavn());
        }

        return emneNameList;
    }

    public static Set<Emne> hentEmner() {
        Set<Emne> emneList = new LinkedHashSet<>();

        String sql = "SELECT * FROM emner";

        try (Connection con = ConnectionConfiguration.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String emne = resultSet.getString("emne");

                emneList.add(new Emne(id, emne));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emneList;
    }
}
