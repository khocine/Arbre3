/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author pc
 */
public class Panier {
    Commandes commande;
   ArrayList<LignesCommande> myCart;
    
    public Panier(){
        myCart = new ArrayList<LignesCommande>();
        commande = new Commandes();
   }

    public Commandes getCommande() {
        return commande;
    }

    public void setCommande(Commandes commande) {
        this.commande = commande;
    }

    public ArrayList<LignesCommande> getMyCart() {
        return myCart;
    }

    public void setMyCart(ArrayList<LignesCommande> myCart) {
        this.myCart = myCart;
    }
   
    
   public void removeElement(int d) {
        myCart.remove(d);
    } 
   
    public void addElement(Produits _produit, String _quantite) {
        
       Short quantite = new Short(_quantite);
       boolean match = false;

            for (int i = 0; i < myCart.size(); i++) {

                if (myCart.get(i).getProduits().getCodeProduit().equals(_produit.getCodeProduit())) {
                    myCart.get(i).setQuantite((short) (myCart.get(i).getQuantite()+quantite));
                    match = true;
                }
            }

            if (!match) {
                LignesCommandeId id = new LignesCommandeId(_produit.getCodeProduit(),commande.getIdCommande()); 
                LignesCommande ligne = new LignesCommande(id,_produit,commande,quantite);
                myCart.add(ligne);
            }
        }
    
    public int getNumberItem(){
        int count = 0;
    
    Iterator<LignesCommande> lignes = myCart.iterator();
        while(lignes.hasNext()) {
         LignesCommande ligne = lignes.next();
         count =count +ligne.getQuantite();
        
    }
        return count;
    }

    public double getTotal() {
        double total = 0;
    
    Iterator<LignesCommande> lignes = myCart.iterator();
        while(lignes.hasNext()) {
         LignesCommande ligne = lignes.next();
         total =total +ligne.getProduits().getPrixProduit().doubleValue()*ligne.getQuantite();
        
    }
        return total;
    }
}
