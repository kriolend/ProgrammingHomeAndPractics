package ua.org.oa.rumyancevv.practics8.controllers;

import ua.org.oa.rumyancevv.practics8.dao.Dao;
import ua.org.oa.rumyancevv.practics8.dao.implJdbc.HumanDao;
import ua.org.oa.rumyancevv.practics8.model.entity.Human;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("Hello Vasia");

        Dao<Human> humanDao = (Dao<Human>) new HumanDao();

        humanDao.create(new Human("Vasya",25));


        List<Human> humanList = humanDao.getAll();
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.print("<html><body><h2>Humans Details</h2>");
        out.print("<table border=\"1\" cellspacing=10 cellpadding=5>");
        out.print("<th>Humans ID</th>");
        out.print("<th>Humans Name</th>");
        out.print("<th>Humans Age</th>");

        for (Human human : humanList) {
            out.print("<tr>");
            out.print("<td>" + human.getId() + "</td>");
            out.print("<td>" + human.getName() + "</td>");
            out.print("<td>" + human.getAge() + "</td>");
            out.print("</tr>");
        }
        out.print("</table></body><br/>");
    }
}
