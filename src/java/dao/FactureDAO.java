/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Modele.Factures;

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
public class FactureDAO implements DaoInterface<Factures, String> {

    private Session currentSession;
    private Transaction currentTransaction;

    public FactureDAO() {
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
    public List<Factures> findAll() {
        List<Factures> list = (List<Factures>) getCurrentSession().createQuery("from Factures").list();
        return list;
    }

    @Override
    public void deleteAll() {
        List<Factures> list = findAll();
        for (Factures facture : list) {
            delete(facture);
        }
    }

    

    @Override
    public void persist(Factures entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Factures entity) {
         getCurrentSession().update(entity);
    }

    @Override
    public Factures findById(String id) {
        Factures facture = (Factures) getCurrentSession().get(Factures.class, id);
        return facture;
    }

    @Override
    public void delete(Factures entity) {
        getCurrentSession().delete(entity);
    }

}
