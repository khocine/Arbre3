/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Modele.Artisans;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import dao.interfaces.DaoInterface;


/**
 *
 * @author 1895066
 */
public class ArtisanDAO implements DaoInterface<Artisans, String> {

    private Session currentSession;
    private Transaction currentTransaction;

    public ArtisanDAO() {
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
    public List<Artisans> findAll() {
        List<Artisans> list = (List<Artisans>) getCurrentSession().createQuery("from Artisans").list();
        return list;
    }

    @Override
    public void deleteAll() {
        List<Artisans> list = findAll();
        for (Artisans artisan : list) {
            delete(artisan);
        }
    }

    

    @Override
    public void persist(Artisans entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Artisans entity) {
         getCurrentSession().update(entity);
    }

    @Override
    public Artisans findById(String id) {
        Artisans artisan = (Artisans) getCurrentSession().get(Artisans.class, id);
        return artisan;
    }

    @Override
    public void delete(Artisans entity) {
        getCurrentSession().delete(entity);
    }

}
