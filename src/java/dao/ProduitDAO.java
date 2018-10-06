
package dao;

import Modele.Artisans;
import dao.interfaces.DaoInterface;


import Modele.Produits;
import java.util.List;
import java.util.Random;
import org.hibernate.Criteria;
import org.hibernate.Query;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;


/**
 *
 * @author 1895066
 */
public class ProduitDAO implements DaoInterface<Produits, String> {

    private Session currentSession;
    private Transaction currentTransaction;

    public ProduitDAO() {
    }

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }


   

    @Override
    public void persist(Produits entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Produits entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public void delete(Produits entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public Produits findById(String id) {
         Produits produit = (Produits) getCurrentSession().get(Produits.class, id);
       return produit;
    }

    @Override
    public List<Produits> findAll() {
        List<Produits> list = (List<Produits>) getCurrentSession().createQuery("from Produits").list();
        return list;
    }

    @Override
    public void deleteAll() {
          List<Produits> list = findAll();
        for (Produits produit : list) {
            delete(produit);
        }
    }

    public List<Produits> FindByArtisans(String _idArtisan) {
        Query query= getCurrentSession().createQuery("from Produits where idArtisan=:id");
        query.setParameter("id",_idArtisan);
        List<Produits> list = query.list();
        return list;
    }

    public List<Produits> getGroupProducts(int start, int numberOfProducts) {
          Query query = getCurrentSession().createQuery("from Produits");
         query.setFirstResult(start);
        query.setMaxResults(numberOfProducts);
        List<Produits> list = (List<Produits>)query.list();
        return list;
    }

   

    public Produits getRandomProduct() {
        Object result=null;
        Criteria crit = getCurrentSession().createCriteria(Produits.class);
        crit.setProjection(Projections.rowCount());
        int count = ((Number) crit.uniqueResult()).intValue();
            if (0 != count) {
              int index = new Random().nextInt(count);
              crit = getCurrentSession().createCriteria(Produits.class);
              result = crit.setFirstResult(index).setMaxResults(1).uniqueResult();
            }
       return (Produits)result;
    }
   
     public List<Produits> getGroupProductsByArtisansId( Artisans _artisan, int startIndex, int numberOfProducts) {
        
         
        Query query= getCurrentSession().createQuery("from Produits where artisans=:_artisan");
        
        query.setParameter("_artisan",_artisan);        
//        query.setFirstResult(startIndex);
//        query.setMaxResults(numberOfProducts);
        
        List<Produits> list = (List<Produits>)query.list();
        
        return list;
    }

    public List<Produits> getGroupProducts(int PRODUCT_PER_PAGE) {
        List<Produits> list = (List<Produits>) getCurrentSession().createQuery("from Produits where (Select count(*) from Produits)-SUBSTRING (codeProduit ,4 , 3 )<12").list();
        return list;
    }
    

}


