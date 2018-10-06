/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import static jdk.nashorn.internal.objects.NativeMath.round;
import service.ArtisanService;
import service.ClientService;
import service.IngredientsService;
import service.ProduitsService;
import service.TaxeEtLivraison;

/**
 *
 * @author 1895135
 */
public class Gestionnaire {
    private List<Produits> listeProduits;
    private ProduitsService ps;
    private ArtisanService as;
   private IngredientsService is;
   private Panier cart;
   private ClientService sc ;
   
   public ProduitsService getPs() {
        return ps;
    }

    public IngredientsService getIs() {
        return is;
    }

    public void setIs(IngredientsService is) {
        this.is = is;
    }

    public Panier getCart() {
        return cart;
    }

    public void setCart(Panier cart) {
        this.cart = cart;
    }

//    public IngredientsService getIs() {
//        return is;
//    }
//    
    public Gestionnaire(){
        Random ran = new Random();
        as = new ArtisanService();
        ps = new ProduitsService();
        //is = new IngredientsService();
        listeProduits = new ArrayList<Produits>();
        int i = ran.nextInt(23);
        listeProduits = ps.getGroupProducts(i,8);
        cart = new Panier();
        sc = new ClientService();
    }

    public List<Produits> getListeProduits() {
        return listeProduits;
    }

    public void setDetails(String langue){
         Iterator<Produits> itr = listeProduits.iterator();
      
      while(itr.hasNext()) {
         Produits element = itr.next();
       Set langues =element.getProduitsLangueses();
       Iterator<ProduitsLangues> itrLg = langues.iterator();
        while(itrLg.hasNext()) {
         ProduitsLangues elementLg = itrLg.next();
         if (elementLg.getLangues().getCodeLangue().equals(langue)){
            element.setName(elementLg.getNomProduit());
             
         
         }
       
         //element.setName(langues.get(0).getNomProduit());
         
      }
      }}
    
    public void setDetailsProduits(Produits _produit,String _langue){
        Set langues =_produit.getProduitsLangueses();
       Iterator<ProduitsLangues> itrLg = langues.iterator();
        while(itrLg.hasNext()) {
         ProduitsLangues elementLg = itrLg.next();
         if (elementLg.getLangues().getCodeLangue().equals(_langue)){
            _produit.setName(elementLg.getNomProduit());
           _produit.setDescription(elementLg.getDescription());
         
         }
        
    }
    setDetailsIngredients(_produit,_langue);
    }
    
    
     public List<Produits> setDetailsGroupProducts(List<Produits> _produits,String _langue){
        Iterator<Produits> group = _produits.iterator(); 
         while(group.hasNext()) {
         Produits produit = group.next();    
         Set langues =produit.getProduitsLangueses();    
          Iterator<ProduitsLangues> itrLg = langues.iterator();   
          while(itrLg.hasNext()) {
         ProduitsLangues elementLg = itrLg.next();
         if (elementLg.getLangues().getCodeLangue().equals(_langue)){
            produit.setName(elementLg.getNomProduit());
           produit.setDescription(elementLg.getDescription());
         
         }   
         }
         
         
         }
         
       return _produits;
       
     }
    
    
    public ProduitsService getProduitsService(){
    return ps;
    }

   

    public void setDetailsIngredients(Produits _produit, String _langue) {
        
        
        Set ingredients = _produit.getIngredientses();
        Iterator<Ingredients> itrIng = ingredients.iterator();
        while(itrIng.hasNext()) {
         Ingredients elementIng = itrIng.next();
         Set ingredientsLangueses =elementIng.getIngredientsLangueses();
         Iterator<IngredientsLangues> itrLg = ingredientsLangueses.iterator();
        while(itrLg.hasNext()) {
           IngredientsLangues elementLg = itrLg.next();
           if (elementLg.getLangues().getCodeLangue().equals(_langue)){
             elementIng.setNomIngredient(elementLg.getNomIngredients());
         }
           
        }
        
        }
    }

    public String getTotalTTC(double total) {
        DecimalFormat df = new DecimalFormat("#.##");
        double totall = total + total*(TaxeEtLivraison.TVQ+TaxeEtLivraison.TPS);
        return df.format(total + total*(TaxeEtLivraison.TVQ+TaxeEtLivraison.TPS));
    }

    public void clearCart() {
       cart.myCart.clear();
        System.out.println("");
    }

    public ArrayList<String> getListeNameProduct(){
    List<Produits> produits =this.getProduitsService().findAll();
        ArrayList<String> list = new ArrayList<String>();
       for (int i=0;i<produits.size();i++) {
           this.setDetailsProduits(produits.get(i),"FR");
      list.add(produits.get(i).getName());

        }
        return list;
    
    }

    public Map<String, String> getMapProducts() {
        Map<String, String> hm = new LinkedHashMap<>();
        
        List<Produits> produits =this.getProduitsService().findAll();
       for (int i=0;i<produits.size();i++) {
           this.setDetailsProduits(produits.get(i),"FR");
      hm.put(produits.get(i).getCodeProduit(), produits.get(i).getName());

        }
  return hm;
    }

    public Object getRandomProduct() {
        int randomNum;
        boolean done = false;
        Produits p;
        List<Produits> randomProducts = new ArrayList<Produits>();
//        int count = this.getProduitsService().getNumberProducts();
        while (!done) {
//        randomNum = (int)(Math.random()*(count + 1));
        p = this.getProduitsService().getRandomProduct();
        if (!randomProducts.contains(p)) {
            this.setDetailsProduits(p, "FR");
            randomProducts.add(p);
        }
        if (randomProducts.size()==4) done = true;
        
        }
        return randomProducts;
    }

    public Object getGroupProductProduts(int PRODUCT_PER_PAGE) {
        return ps.getGroupProducts(PRODUCT_PER_PAGE);
    }

    public Artisans findArtisanById(String artisanId) {
       
     return as.findById(artisanId);
     }

    public List<Produits> getGroupProductsByArtisansId(Artisans _artisan, int startIndex, int numberOfProducts) {
        return ps.getGroupProductsByArtisansId(_artisan, startIndex, numberOfProducts);
    }

     public List<Produits> getGroupProducts(int startIndex, int numberOfProducts){
        return ps.getGroupProducts(startIndex, numberOfProducts);
    }

    public ClientService getClientsService() {
       
       return sc;
    }
    
    
    
}
