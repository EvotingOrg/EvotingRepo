/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evoting.controller.util;

import com.evoting.entity.Users;
import com.evoting.facade.UsersFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASHOK
 */
@WebServlet(name = "EmailServlet", urlPatterns = {"/EmailServlet"})
public class EmailServlet extends HttpServlet {

    @EJB
    private EmailSessionBean emailBean;
    @Inject
    private UsersFacade userFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, AddressException {
        String form_name = request.getParameter("formName");
        String to = "";
        String from = "";
        String subject = "";
        String body = "";

        if (form_name.equals("contact-form-popup")) {
            to = "ashookkafle@gmail.com";
            from = request.getParameter("email_addr");
            subject = request.getParameter("subject");
            String message = request.getParameter("message");
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String c_name = request.getParameter("c_name");

            body = "<html>Name: " + name + "<br/>"
                    + "Phone: " + phone + "<br/>"
                    + "Company Name: " + c_name + "<br/>"
                    + "Message: " + message + "</html>";
        } 
        else if (form_name.equals("forgot-password-form")) {
            from = "ashookkafle@gmail.com";
            to = request.getParameter("forgot_email");

            //Generating random password string            
            String new_password = PasswordGenerator.passGen();            
            String hash_password = HashedPasswordGenerator.generateHash(new_password);
            
            Users dbUser = userFacade.findByUserName(to);
            dbUser.setPassword(hash_password);
            userFacade.edit(dbUser);

            subject = "Password Reset";
            body = "<html>Congratulation, Your Password is successfully reset. Your new login credentials are:<br/>"
                    + "Username: " + to
                    + "Password: " + new_password + "<br/>"
                    + "Hashed Password: " + hash_password + "<br/>"
                    + "You can reset your password from 'My Account' after login.</html>";
        }

        javax.mail.internet.InternetAddress ia = new javax.mail.internet.InternetAddress(to);
        try {
            ia.validate();
        } catch (javax.mail.internet.AddressException ae) {

        }

        emailBean.sendEmail(to, from, subject, body);

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EmailServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Form Submitted</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (AddressException ex) {
            Logger.getLogger(EmailServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (AddressException ex) {
            Logger.getLogger(EmailServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
