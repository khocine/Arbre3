/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Modele.Administrateurs;

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
public class AdministrateurDAO implements DaoInterface<Administrateurs, String> {

    private Session currentSession;
    private Transaction currentTransaction;

    public AdministrateurDAO() {
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
    public List<Administrateurs> findAll() {
        List<Administrateurs> list = (List<Administrateurs>) getCurrentSession().createQuery("from Administrateurs").list();
        return list;
    }

    @Override
    public void deleteAll() {
        List<Administrateurs> list = findAll();
        for (Administrateurs administrateur : list) {
            delete(administrateur);
        }
    }

    

    @Override
    public void persist(Administrateurs entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Administrateurs entity) {
         getCurrentSession().update(entity);
    }

    @Override
    public Administrateurs findById(String id) {
        Administrateurs administrateur = (Administrateurs) getCurrentSession().get(Administrateurs.class, id);
        return administrateur;
    }

    @Override
    public void delete(Administrateurs entity) {
        getCurrentSession().delete(entity);
    }

}
