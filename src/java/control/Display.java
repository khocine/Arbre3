/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import Modele.Gestionnaire;
import Modele.Produits;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author pc
 */
public class Display extends HttpServlet {
private ServletContext sc;
    private RequestDispatcher rd;
    private HttpSession session;
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
        String index="";
        
        response.setContentType("application/json");
        session = request.getSession();
        String toSearch = request.getParameter("format");
        String soap = request.getParameter("savon");
        
         Gestionnaire gs =(Gestionnaire) session.getAttribute("gs");
        
        if (session == null) {
            response.sendRedirect("http://localhost:82/error.html");
        }
        
        
        session.setAttribute("randomProduct",gs.getRandomProduct());
        
        if (toSearch==null){
       if (soap == null) {
        index = request.getParameter("index");
        
       }
       else {
            index = request.getParameter("savon");
       }
        
        Produits currentProduct = gs.getProduitsService().findById(index);
        gs.setDetailsProduits(currentProduct,"FR");
        gs.setDetailsIngredients(currentProduct, "FR");
        session.setAttribute("currentProduct",currentProduct);

        String url = "/Product.jsp";
            sc = getServletContext();
            rd = sc.getRequestDispatcher(url);
            rd.forward(request, response);
        
       
        }
        else {
//        List<Produits> produits =gs.getProduitsService().findAll();
//        response.setContentType("Application/json");
//        ArrayList<String> list = new ArrayList<String>();
//       for (int i=0;i<produits.size();i++) {
//           gs.setDetailsProduits(produits.get(i),"FR");
//      list.add(produits.get(i).getName());
//
//        }
        response.setContentType("Application/json");
       Gson gson = new GsonBuilder().setPrettyPrinting().create();
       String json = gson.toJson(session.getAttribute("mapProduit"));
//       String json = gson.toJson(session.getAttribute("listName"));
       response.getWriter().write(json);
        
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
