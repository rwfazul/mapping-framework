/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import banco.RegistroDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Evento;
import model.Palestra;
import model.dao.mysql.PalestraDAOMySQL;

/**
 *
 * @author isabella
 */
@WebServlet(name = "PalestraServlet", urlPatterns = {"/palestraServlet"})
public class PalestraServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, Integer id_evento)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Palestra p = new Palestra();
        Evento e = (Evento) new DBConfig().getRegistroDAO().buscar(id_evento);
        RegistroDAO pdao = new PalestraDAOMySQL();
        p.setEvento(e);
        Collection<Palestra> palestras = pdao.buscar(p);
        try {
            request.setAttribute("palestras", palestras);
            request.setAttribute("evento", e);
        } catch (Exception ex) {
            Logger.getLogger(PalestraServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        String pagina = "/index.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
        dispatcher.forward(request, response);
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
        Integer id_evento = 0;
        String acao = request.getParameter("action");
        RegistroDAO dao = new DBConfig().getRegistroDAO();
        if ("list".equals(acao)) {
            id_evento = Integer.parseInt(request.getParameter("id_evento"));
            request.setAttribute("page", "gerenciarPalestras.jsp");
        } else if ("delete".equals(acao)) {
            RegistroDAO pdao = new PalestraDAOMySQL();
            Palestra p = (Palestra) pdao.buscar(Integer.parseInt(request.getParameter("id_palestra")));
            id_evento = Integer.parseInt(request.getParameter("id_evento"));
            try {
                pdao.excluir(p);
                request.setAttribute("page", "gerenciarPalestras.jsp");
            } catch (Exception ex) {
                Logger.getLogger(EventoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        processRequest(request, response, id_evento);
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
        Integer id_evento = 0;
        processRequest(request, response, id_evento);
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
