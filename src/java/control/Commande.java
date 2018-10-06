/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import Modele.Gestionnaire;
import Modele.LignesCommande;
import Modele.Produits;
import Utilitaire.FormatUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
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
public class Commande extends HttpServlet {
        private String url;
    private ServletContext sc;
    private RequestDispatcher rd;
    private HttpSession session;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private Gestionnaire gs;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param _request servlet request
     * @param _response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException {
        _response.setContentType("text/html;charset=UTF-8");
        
        request=_request;
        response=_response;
        session = request.getSession();
        session.setAttribute("currentPage", "/Cart.jsp");
        

        if (session == null) {
            response.sendRedirect("http://localhost:82/error.html");
        }
        
        gs =(Gestionnaire) session.getAttribute("gs");
       String action= request.getParameter("action");
       String delivery= request.getParameter("delivery_price");
       if (action==null) {
//           if (delivery == null)
//           {
       String quantite = request.getParameter("quantity_input");
       String codeProduct = request.getParameter("codeProduct_input");
       if (!quantite.equals("0")) { 
       Produits currentProduct = gs.getProduitsService().findById(codeProduct);
       gs.setDetailsProduits(currentProduct,"FR");
       gs.getCart().addElement(currentProduct, quantite);
       setCartAttribute();
       
       
          forwardTo("/Product.jsp");
       }
       else {
       
            forwardTo("/Product.jsp");
       }
//           }
//           else {
//               session.setAttribute("delivery_price", delivery);
//               session.setAttribute("totalTTC_Shipping", session.getAttribute("TotalTTC")+delivery);
//               forwardTo("/Checkout.jsp");
//               //implementer et forward chekout
//           }
           
       }
       
       else if (action.equals("clearCart")) {
       gs.clearCart();
       initCartAttribute();
       forwardTo("/index.jsp");
      
           
       } else if (action.equals("updateCart")){
               Iterator<LignesCommande> itr = gs.getCart().getMyCart().iterator();    
      while(itr.hasNext()) {
         LignesCommande element = itr.next();
         Short newQuantity = Short.parseShort(request.getParameter(element.getProduits().getCodeProduit()));
         if (element.getQuantite()!= newQuantity)
         {
             element.updateLigne(newQuantity);
           }
       
       }
      setCartAttribute();
      forwardTo("/Cart.jsp");
            
    }
       else {
        session.setAttribute("delivery_price", delivery);
        String totalttc = (String) session.getAttribute("totalTTC");
        
        String totalTTC_Shipping = FormatUtil.StringAddFormator(totalttc, delivery);
        
               session.setAttribute("totalTTC_Shipping", totalTTC_Shipping);
               forwardTo("/Checkout.jsp");
       
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

    private void initCartAttribute() {
        session.setAttribute("count",0);
        session.setAttribute("total",0);
       session.setAttribute("totalTTC", 0);
    }

    private void forwardTo(String _url) throws ServletException, IOException {
         sc = getServletContext();
            rd = sc.getRequestDispatcher(_url);
            rd.forward(request, response);
    }

    private void setCartAttribute() {
        session.setAttribute("cart", gs.getCart());
       session.setAttribute("count",gs.getCart().getNumberItem());
       session.setAttribute("total",gs.getCart().getTotal());
       String TotalTTC = gs.getTotalTTC(gs.getCart().getTotal()); 
       session.setAttribute("totalTTC", TotalTTC);
    }

}
