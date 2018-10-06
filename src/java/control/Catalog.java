/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import Modele.Artisans;
import Modele.Gestionnaire;
import Modele.Produits;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 1895135
 */
@WebServlet(name = "Catalog", urlPatterns = {"/Catalog"})
public class Catalog extends HttpServlet {
    private final int PRODUCT_PER_PAGE =12;
     private String url;
    private ServletContext sc;
    private RequestDispatcher rd;
    private HttpSession session;
    private Artisans artisan;
    private Gestionnaire gs;
    private List<Produits> group;

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
        session = request.getSession();
        session.setAttribute("triArtisans","Trier par artisans");
        session.setAttribute("currentPage", "/Catalog.jsp");
        gs = (Gestionnaire) session.getAttribute("gs");
       String artisanId = request.getParameter("artisanId");
        String pageId = request.getParameter("pageId");

//        if (artisanId == null && pageId == null) {
//            session.setAttribute("productsPerPage", gs.getGroupProductProduts(PRODUCT_PER_PAGE));
//            sc = getServletContext();
//            rd = sc.getRequestDispatcher("/Catalog.jsp");
//            rd.forward(request, response);
//        }
        if (artisanId != null) {
            if (artisanId.equals("00")) {
             session.setAttribute("triArtisans","Tout");
             session.setAttribute("productsPerPage", gs.getGroupProducts(0, 12));
             session.setAttribute("artisan", null);
             session.setAttribute("all","1");
            
            }
            else {
            artisan = gs.findArtisanById(artisanId);
            session.setAttribute("artisan", artisan);
            session.setAttribute("triArtisans",artisan.getNomArtisan());
            List<Produits> group =gs.getGroupProductsByArtisansId(artisan, 0, 12);
            gs.setDetailsGroupProducts(group,"FR");
            session.setAttribute("productsPerPage",group );
            session.setAttribute("all","0");
            }
        }

        else if (pageId != null && (Artisans) session.getAttribute("artisan") != null) {
            artisan = (Artisans) session.getAttribute("artisan");
            switch (pageId) {
                case "01":
                    group =gs.getGroupProductsByArtisansId(artisan, 0, 12);
                    gs.setDetailsGroupProducts(group,"FR");
                    session.setAttribute("productsPerPage", group);
                    break;
                case "02":
                    group =gs.getGroupProductsByArtisansId(artisan, 11, 12);
                    gs.setDetailsGroupProducts(group,"FR");
                    session.setAttribute("productsPerPage", group);
                    break;
                case "03":
                    group =gs.getGroupProductsByArtisansId(artisan, 23, 12);
                    gs.setDetailsGroupProducts(group,"FR");
                    session.setAttribute("productsPerPage", group);
                    break;
            }

        }
        else if (pageId != null && artisanId == null) {
            switch (pageId) {
                case "01":
                    session.setAttribute("productsPerPage", gs.getGroupProducts(0, 12));
                    break;
                case "02":
                    session.setAttribute("productsPerPage", gs.getGroupProducts(11, 12));
                    break;
                case "03":
                    session.setAttribute("productsPerPage", gs.getGroupProducts(23, 12));
                    break;
            }
        }

        sc = getServletContext();
        rd = sc.getRequestDispatcher("/Catalog.jsp");
        rd.forward(request, response);
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
