
package dao;

import Modele.Produits;
import dao.interfaces.DaoInterface;


import Modele.ProduitsLangues;
import java.util.List;
import org.hibernate.Query;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


/**
 *
 * @author 1895066
 */
public class ProduitsLanguesDAO implements DaoInterface<ProduitsLangues, String> {

    private Session currentSession;
    private Transaction currentTransaction;

    public ProduitsLanguesDAO() {
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
    public void persist(ProduitsLangues entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(ProduitsLangues entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public void delete(ProduitsLangues entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public ProduitsLangues findById(String id) {
         ProduitsLangues produitLangue = (ProduitsLangues) getCurrentSession().get(ProduitsLangues.class, id);
       return produitLangue;
    }

    @Override
    public List<ProduitsLangues> findAll() {
        List<ProduitsLangues> list = (List<ProduitsLangues>) getCurrentSession().createQuery("from ProduitsLangues").list();
        return list;
    }

    @Override
    public void deleteAll() {
          List<ProduitsLangues> list = findAll();
        for (ProduitsLangues produitLangue : list) {
            delete(produitLangue);
        }
    }
    
    public List<ProduitsLangues> findProductByLanguage(String _codeLangue) {
        Query query= getCurrentSession().createQuery("from ProduitsLangues where codeLangue=:id");
        query.setParameter("id",_codeLangue);
        List<ProduitsLangues> list = query.list();
        return list;
    }
    
    public List<ProduitsLangues> findNameIngredientByIngredientAndLanguage(String _codeLangue,String _codeProduit) {
        Query query= getCurrentSession().createQuery("from ProduitsLangues where codeProduit=:id AND codeLangue=id_2");
        query.setParameter("id",_codeProduit);
        query.setParameter("id_2",_codeLangue);
        List<ProduitsLangues> list = query.list();
        return list;
    }

}




