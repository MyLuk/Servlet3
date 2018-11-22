package org.myluk.servlets;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.myluk.hibernate.DAO.FilesDAO;
import org.myluk.hibernate.entity.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/ImageUploadDemoServlet")
public class ImageUploadDemoServlet extends HttpServlet {
    private static String path = "/home/michael/Pictures/downloadDemo/";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action").toLowerCase();
        switch (action) {
            case "filesupload":
                filesUpload(request, response);
                break;
            case "listingimages":
                listingImages(request, response);
            default:
                request.getRequestDispatcher("imageUploadDemo.jsp").forward(request, response);
        }

    }

    private void listingImages(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Files> files = new FilesDAO().listFiles();
        request.setAttribute("files", files);
        request.setAttribute("path", path);
        request.getRequestDispatcher("listFiles.jsp").forward(request, response);
    }

    private void filesUpload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletFileUpload fileUpload = new ServletFileUpload(new DiskFileItemFactory());
        FilesDAO filesDAO = new FilesDAO();
        try {
            List<FileItem> images = fileUpload.parseRequest(request);
            images.forEach(i-> System.out.println(i.getName()));
            for (FileItem i : images) {

                String name = i.getName();
                File file = new File(path + name);
                if (!file.exists()) {
                    filesDAO.addFileDtails(new Files(name));
                    i.write(file);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        listingImages(request, response);
    }

}
