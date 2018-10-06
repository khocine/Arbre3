
package dao;

import dao.interfaces.DaoInterface;


import Modele.Ingredients;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


/**
 *
 * @author 1895066
 */
public class IngredientDAO implements DaoInterface<Ingredients, String> {

    private Session currentSession;
    private Transaction currentTransaction;

    public IngredientDAO() {
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
    public void persist(Ingredients entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Ingredients entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public void delete(Ingredients entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public Ingredients findById(String id) {
         Ingredients ingredient = (Ingredients) getCurrentSession().get(Ingredients.class, id);
       return ingredient;
    }

    @Override
    public List<Ingredients> findAll() {
        List<Ingredients> list = (List<Ingredients>) getCurrentSession().createQuery("from Ingredients").list();
        return list;
    }

    @Override
    public void deleteAll() {
          List<Ingredients> list = findAll();
        for (Ingredients ingredient : list) {
            delete(ingredient);
        }
    }

}
