/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Modele.Commandes;

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
public class CommandeDAO implements DaoInterface<Commandes, String> {

    private Session currentSession;
    private Transaction currentTransaction;

    public CommandeDAO() {
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
    public List<Commandes> findAll() {
        List<Commandes> list = (List<Commandes>) getCurrentSession().createQuery("from Commandes").list();
        return list;
    }

    @Override
    public void deleteAll() {
        List<Commandes> list = findAll();
        for (Commandes commande : list) {
            delete(commande);
        }
    }

    

    @Override
    public void persist(Commandes entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Commandes entity) {
         getCurrentSession().update(entity);
    }

    @Override
    public Commandes findById(String id) {
        Commandes commande = (Commandes) getCurrentSession().get(Commandes.class, id);
        return commande;
    }

    @Override
    public void delete(Commandes entity) {
        getCurrentSession().delete(entity);
    }

}



