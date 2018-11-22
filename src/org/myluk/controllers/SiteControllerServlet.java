//package org.myluk.controllers;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet("/site")
//public class SiteControllerServlet extends HttpServlet {
//
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String page = request.getParameter("page").toLowerCase();
//        switch (page) {
//            case "home":
//                homePage(request, response);
//                break;
//            default:
//                errorPage(request, response);
//                break;
//        }
//    }
//
//    private void errorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute("title", "Error page");
//        request.getRequestDispatcher("error.jsp").forward(request, response);
//    }
//
//    private void homePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute("title", "Homepage");
//        request.getRequestDispatcher("index1.jsp").forward(request, response);
//    }
//}
