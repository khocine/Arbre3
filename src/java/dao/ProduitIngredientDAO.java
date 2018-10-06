
//package dao;
//
//import Modele.Produits;
//import dao.interfaces.DaoInterface;
//
//
////import Modele.ProduitsIngredients;
//import java.util.List;
//import org.hibernate.Query;
//
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//
//
///**
// *
// * @author 1895066
// */
//public class ProduitIngredientDAO implements DaoInterface<ProduitsIngredients, String> {
//
//    private Session currentSession;
//    private Transaction currentTransaction;
//
//    public ProduitIngredientDAO() {
//    }
//
//    public Session openCurrentSession() {
//        currentSession = getSessionFactory().openSession();
//        return currentSession;
//    }
//
//    public Session openCurrentSessionwithTransaction() {
//        currentSession = getSessionFactory().openSession();
//        currentTransaction = currentSession.beginTransaction();
//        return currentSession;
//    }
//
//    public void closeCurrentSession() {
//        currentSession.close();
//    }
//
//    public void closeCurrentSessionwithTransaction() {
//        currentTransaction.commit();
//        currentSession.close();
//    }
//
//    private static SessionFactory getSessionFactory() {
//        Configuration configuration = new Configuration().configure();
//        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
//        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
//        return sessionFactory;
//    }
//
//    public Session getCurrentSession() {
//        return currentSession;
//    }
//
//    public void setCurrentSession(Session currentSession) {
//        this.currentSession = currentSession;
//    }
//
//    public Transaction getCurrentTransaction() {
//        return currentTransaction;
//    }
//
//    public void setCurrentTransaction(Transaction currentTransaction) {
//        this.currentTransaction = currentTransaction;
//    }
//
//
//   
//
//    @Override
//    public void persist(ProduitsIngredients entity) {
//        getCurrentSession().save(entity);
//    }
//
//    @Override
//    public void update(ProduitsIngredients entity) {
//        getCurrentSession().update(entity);
//    }
//
//    @Override
//    public void delete(ProduitsIngredients entity) {
//        getCurrentSession().delete(entity);
//    }
//
//    @Override
//    public ProduitsIngredients findById(String id) {
//         ProduitsIngredients produitIngredient = (ProduitsIngredients) getCurrentSession().get(ProduitsIngredients.class, id);
//       return produitIngredient;
//    }
//
//    @Override
//    public List<ProduitsIngredients> findAll() {
//        List<ProduitsIngredients> list = (List<ProduitsIngredients>) getCurrentSession().createQuery("from ProduitsIngredients").list();
//        return list;
//    }
//
//    @Override
//    public void deleteAll() {
//          List<ProduitsIngredients> list = findAll();
//        for (ProduitsIngredients produitIngredient : list) {
//            delete(produitIngredient);
//        }
//    }
//    
//    public List<ProduitsIngredients> findproductByIngredient(String _idIngredient) {
//        Query query= getCurrentSession().createQuery("from ProduitsIngredients where idIngredient=:id");
//        query.setParameter("id",_idIngredient);
//        List<ProduitsIngredients> list = query.list();
//        return list;
//    }
//    
//    public List<ProduitsIngredients> findingredientByproduct(String _codeProduit) {
//        Query query= getCurrentSession().createQuery("from ProduitsIngredients where codeProduit=:id");
//        query.setParameter("id",_codeProduit);
//        List<ProduitsIngredients> list = query.list();
//        return list;
//    }
//
//}
//
//
//
