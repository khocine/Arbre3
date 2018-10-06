/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import Modele.Artisans;
import Modele.Produits;
//import Modele.ProduitsIngredients;
import dao.ProduitDAO;
//import dao.ProduitIngredientDAO;
import dao.ProduitsLanguesDAO;

import java.util.List;

/**
 *
 * @author 1895066
 */
public class ProduitsService {
    
    private  ProduitDAO produitDao;

   public  static ProduitsLanguesDAO produitsLanguesDao;
   
    
    public ProduitsService()
    {
    produitDao = new ProduitDAO();

    }
    
    public void save(Produits entity)
    {
        produitDao.openCurrentSessionwithTransaction();
        produitDao.persist(entity);
        produitDao.closeCurrentSessionwithTransaction();
    }
	public void update(Produits entity)
        {
        produitDao.openCurrentSessionwithTransaction();
        produitDao.update(entity);
        produitDao.closeCurrentSessionwithTransaction();
        }
        
	public Produits findById(String id)
        {
            produitDao.openCurrentSession();
            Produits produit = produitDao.findById(id);
            produitDao.closeCurrentSession();
            return produit;
        }
	public void delete(String id)
        {
            produitDao.openCurrentSessionwithTransaction();
            Produits artisan = produitDao.findById(id);
            produitDao.delete(artisan);
            produitDao.closeCurrentSessionwithTransaction();
        }
	public List<Produits> findAll()
        {
            produitDao.openCurrentSessionwithTransaction();
            List<Produits> list = produitDao.findAll();
            produitDao.closeCurrentSessionwithTransaction();
            return list;
        }
	public void deleteAll()
        {
        produitDao.openCurrentSessionwithTransaction();
        produitDao.deleteAll();
        produitDao.closeCurrentSessionwithTransaction();
        }
        
        public List<Produits> FindByArtisans(String idArtisan){
        produitDao.openCurrentSessionwithTransaction();
        List<Produits> list = produitDao.FindByArtisans(idArtisan);
        produitDao.closeCurrentSessionwithTransaction();    
        return list;
        }
        


    public List<Produits> getGroupProducts(int start, int numberOfProducts) {
         produitDao.openCurrentSessionwithTransaction();
            List<Produits> list = produitDao.getGroupProducts(start, numberOfProducts);
            produitDao.closeCurrentSessionwithTransaction();
            return list;
    }

   

  

    public Produits getRandomProduct() {
         produitDao.openCurrentSessionwithTransaction();
            Produits p = produitDao.getRandomProduct();
            produitDao.closeCurrentSessionwithTransaction();
            return p;
    }
    
    public List<Produits> getGroupProducts(int PRODUCT_PER_PAGE) {
         produitDao.openCurrentSessionwithTransaction();
            List<Produits> list = produitDao.getGroupProducts(PRODUCT_PER_PAGE);
            produitDao.closeCurrentSessionwithTransaction();
            return list;
    }
    
 
    
    public List<Produits> getGroupProductsByArtisansId( Artisans _artisan, int startIndex, int numberOfProducts){
    produitDao.openCurrentSessionwithTransaction();
            List<Produits> list = produitDao.getGroupProductsByArtisansId(_artisan, startIndex, numberOfProducts);
            produitDao.closeCurrentSessionwithTransaction();
            return list;
    }
    
}

