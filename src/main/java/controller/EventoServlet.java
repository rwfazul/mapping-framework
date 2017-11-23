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
import model.conversores.EventoConversor;
import model.dao.mysql.PalestraDAOMySQL;
import org.bson.Document;

/**
 *
 * @author isabella
 */
@WebServlet(name = "EventoServlet", urlPatterns = {"/eventoServlet"})
public class EventoServlet extends HttpServlet {

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
        String pagina = "/index.jsp";
        Collection<Evento> eventos = new DBConfig().getRegistroDAO().buscarTodos();
        try {
            request.setAttribute("eventos", eventos);
        } catch (Exception ex) {
            Logger.getLogger(EventoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        RegistroDAO dao = new DBConfig().getRegistroDAO();
        String acao = request.getParameter("action");

        if (null != acao) switch (acao) {
            case "list":
                request.setAttribute("page", "gerenciarEventos.jsp");
                break;
            case "insert":
                request.setAttribute("page", "inserirEvento.jsp");
                break;
            case "delete":
                Evento e = (Evento) dao.buscar(Integer.parseInt(request.getParameter("id_evento")));
                RegistroDAO pdao = new PalestraDAOMySQL();
                Palestra p = new Palestra();
                p.setEvento(e);
                Collection<Palestra> palestras = pdao.buscar(p);
                try {
                    //Exclui todas palestras daquele evento para poder excluir o evento
                    for (Palestra pa : palestras) {
                        pdao.excluir(pa);
                    }
                    dao.excluir(e);
                    request.setAttribute("page", "gerenciarEventos.jsp");
                } catch (Exception ex) {
                    Logger.getLogger(EventoServlet.class.getName()).log(Level.SEVERE, null, ex);
                }   break;
            case "update":
                e = (Evento) dao.buscar(Integer.parseInt(request.getParameter("id_evento")));
                request.setAttribute("eventoUpdate", e);
                request.setAttribute("page", "inserirEvento.jsp");
                break;
            default:
                break;
        }

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
        Document doc = Document.parse(request.getParameter("eventoJson"));
        Evento e = new EventoConversor().toModel(doc);

        new DBConfig().getRegistroDAO().inserir(e);

        PrintWriter out = response.getWriter();
        out.print("{\"url\": \"index.jsp\"}");
        out.flush();
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
