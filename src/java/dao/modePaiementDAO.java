/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Modele.ModesPaiement;

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
public class modePaiementDAO implements DaoInterface<ModesPaiement, String> {

    private Session currentSession;
    private Transaction currentTransaction;

    public modePaiementDAO() {
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
    public List<ModesPaiement> findAll() {
        List<ModesPaiement> list = (List<ModesPaiement>) getCurrentSession().createQuery("from ModesPaiement").list();
        return list;
    }

    @Override
    public void deleteAll() {
        List<ModesPaiement> list = findAll();
        for (ModesPaiement modePaiement : list) {
            delete(modePaiement);
        }
    }

    

    @Override
    public void persist(ModesPaiement entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(ModesPaiement entity) {
         getCurrentSession().update(entity);
    }

    @Override
    public ModesPaiement findById(String id) {
        ModesPaiement modePaiement = (ModesPaiement) getCurrentSession().get(ModesPaiement.class, id);
        return modePaiement;
    }

    @Override
    public void delete(ModesPaiement entity) {
        getCurrentSession().delete(entity);
    }

}

