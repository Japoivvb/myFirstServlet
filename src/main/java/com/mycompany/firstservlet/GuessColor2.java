package com.mycompany.firstservlet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import jakarta.servlet.ServletConfig;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author JoseAlbertoPortugalO
 */
public class GuessColor2 extends HttpServlet {

    private String colorInicial;

    @Override
    public void init(ServletConfig config) throws ServletException {

        super.init(config);

        //Color configurat com a paràmetre inicial. És el color a endevinar.
        this.colorInicial = getServletConfig().getInitParameter("color");
    }

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
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Endevina el color</title>");
            out.println("</head>");
            out.println("<body>");

            String colorUsuari = request.getParameter("color");

            if (colorUsuari != null && !colorUsuari.equals("")) {

                crearPaginaGuanyador(colorUsuari, out);

            } else {

                crearPaginaInicial(out);
            }

            out.println("</body>");
            out.println("</html>");

        }
    }

    private void crearPaginaGuanyador(String colorUsuari, PrintWriter out) {

        String endevinat = "Llàstima, has perdut!";

        if (this.colorInicial.toLowerCase().equals(colorUsuari.toLowerCase())) {
            endevinat = "Felicitats! Has endevinat el color.";
        }

        out.println("<h1>" + endevinat + "</h1>");
        out.println("<a href='GuessColor2'>Tornar<a/>");

    }

    private void crearPaginaInicial(PrintWriter out) {
        out.println("<h1>Endevina el color configurat:</h1>");
        out.println("<a href='GuessColor2?color=white'>blanc</a>");
        out.println("<a href='GuessColor2?color=red'>vermell</a>");
        out.println("<a href='GuessColor2?color=blue'>blau</a>");
        out.println("<a href='GuessColor2?color=yellow'>groc</a>");
        out.println("<a href='GuessColor2?color=green'>verd</a>");
        out.println("<a href='GuessColor2?color=black'>negre</a>");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
