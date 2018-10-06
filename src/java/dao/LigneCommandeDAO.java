/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Modele.LignesCommande;

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
public class LigneCommandeDAO implements DaoInterface<LignesCommande, String> {

    private Session currentSession;
    private Transaction currentTransaction;

    public LigneCommandeDAO() {
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
    public List<LignesCommande> findAll() {
        List<LignesCommande> list = (List<LignesCommande>) getCurrentSession().createQuery("from LignesCommande").list();
        return list;
    }

    @Override
    public void deleteAll() {
        List<LignesCommande> list = findAll();
        for (LignesCommande ligneCommande : list) {
            delete(ligneCommande);
        }
    }

    

    @Override
    public void persist(LignesCommande entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(LignesCommande entity) {
         getCurrentSession().update(entity);
    }

    @Override
    public LignesCommande findById(String id) {
        LignesCommande ligneCommande = (LignesCommande) getCurrentSession().get(LignesCommande.class, id);
        return ligneCommande;
    }

    @Override
    public void delete(LignesCommande entity) {
        getCurrentSession().delete(entity);
    }

}


