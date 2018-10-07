/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;


import Modele.Gestionnaire;
import Modele.Produits;

import java.io.IOException;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.TaxeEtLivraison;



/**
 *
 * @author 1895066
 */
public class Initialisation extends HttpServlet {
private String url;
    private ServletContext sc;
    private RequestDispatcher rd;
    private HttpSession session;
    private final int PRODUCT_PER_PAGE_CATALOG=12;
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
       session = request.getSession();

        if (session == null) {
            response.sendRedirect("/index.jsp");
        }
        
        boolean match = false;
        Locale locale = request.getLocale();
        Gestionnaire gs = new Gestionnaire();
        List<Produits> group = gs.getGroupProducts(0, PRODUCT_PER_PAGE_CATALOG);
       
        session = request.getSession();
       
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("langue")) {
                    session.setAttribute("language", c.getValue());
                    match = true;
                    break;
                }
            }
        }
        if (!match) {
            String language = locale.getLanguage();
            switch (language) {
                case "fr":
                    session.setAttribute(language, "fr_FR");
                    gs.setDetails("FR");
                    session.setAttribute("langueDetail","FR");
                    gs.setDetailsGroupProducts(group,"FR");
                    break;
                case "en":
                    session.setAttribute(language, "en_EN");
                    gs.setDetails("EN");
                    session.setAttribute("langueDetail","EN");
                    gs.setDetailsGroupProducts(group,"EN");
                    break;
              
            }
        }

        
        
        
        
        
       session.setAttribute("lastProducts", gs.getListeProduits());
       session.setAttribute("count", 0);
       session.setAttribute("gs",gs);
       session.setAttribute("nextDayDelivery", TaxeEtLivraison.nextDayDelivery);
       session.setAttribute("standardDelivery", TaxeEtLivraison.standardDelivery);
       session.setAttribute("connected",false);
       
       session.setAttribute("productsPerPage",group );
       session.setAttribute("triArtisans","Trier par artisans");
       session.setAttribute("all","1");
       session.setAttribute("connected",false);
       
       Map<String, String> hm = new LinkedHashMap<>();
       hm = gs.getMapProducts();
       session.setAttribute("mapProduit",hm);
//       List listName = gs.getListeNameProduct();
//       session.setAttribute("listName",listName);
       
       
       
       url = "/index.jsp";
            sc = getServletContext();
            rd = sc.getRequestDispatcher(url);
            rd.forward(request, response);}

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
