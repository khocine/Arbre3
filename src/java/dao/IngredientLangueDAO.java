
package dao;

import Modele.Produits;
import dao.interfaces.DaoInterface;


import Modele.IngredientsLangues;
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
public class IngredientLangueDAO implements DaoInterface<IngredientsLangues, String> {

    private Session currentSession;
    private Transaction currentTransaction;

    public IngredientLangueDAO() {
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
    public void persist(IngredientsLangues entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(IngredientsLangues entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public void delete(IngredientsLangues entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public IngredientsLangues findById(String id) {
         IngredientsLangues ingredientsLangue = (IngredientsLangues) getCurrentSession().get(IngredientsLangues.class, id);
       return ingredientsLangue;
    }

    @Override
    public List<IngredientsLangues> findAll() {
        List<IngredientsLangues> list = (List<IngredientsLangues>) getCurrentSession().createQuery("from IngredientsLangues").list();
        return list;
    }

    @Override
    public void deleteAll() {
          List<IngredientsLangues> list = findAll();
        for (IngredientsLangues ingredientsLangue : list) {
            delete(ingredientsLangue);
        }
    }
    
    public List<IngredientsLangues> findIngredientByLanguage(String _codeLangue) {
        Query query= getCurrentSession().createQuery("from IngredientsLangues where codeLangue=:id");
        query.setParameter("id",_codeLangue);
        List<IngredientsLangues> list = query.list();
        return list;
    }
    
    public List<IngredientsLangues> findNameIngredientByIngredientAndLanguage(String _codeLangue,String _codeProduit) {
        Query query= getCurrentSession().createQuery("from IngredientsLangues where codeProduit=:id AND codeLangue=id_2");
        query.setParameter("id",_codeProduit);
        query.setParameter("id_2",_codeLangue);
        List<IngredientsLangues> list = query.list();
        return list;
    }

}





