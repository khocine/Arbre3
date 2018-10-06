/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import Modele.Clients;
import dao.ClientDAO;
import java.util.List;
/**
 *
 * @author 1895066
 */
public class ClientService {
    
    private static ClientDAO clientDao;
    
    public ClientService()
    {
    clientDao = new ClientDAO();
    }
    
    public void save(Clients entity)
    {
        clientDao.openCurrentSessionwithTransaction();
        clientDao.persist(entity);
        clientDao.closeCurrentSessionwithTransaction();
    }
	public void update(Clients entity)
        {
        clientDao.openCurrentSessionwithTransaction();
        clientDao.update(entity);
        clientDao.closeCurrentSessionwithTransaction();
        }
        
	public Clients findById(String id)
        {
            clientDao.openCurrentSession();
            Clients artisan = clientDao.findById(id);
            clientDao.closeCurrentSession();
            return artisan;
        }
	public void delete(String id)
        {
            clientDao.openCurrentSessionwithTransaction();
            Clients artisan = clientDao.findById(id);
            clientDao.delete(artisan);
            clientDao.closeCurrentSessionwithTransaction();
        }
	public List<Clients> findAll()
        {
            clientDao.openCurrentSessionwithTransaction();
            List<Clients> list = clientDao.findAll();
            clientDao.closeCurrentSessionwithTransaction();
            return list;
        }
	public void deleteAll()
        {
        clientDao.openCurrentSessionwithTransaction();
        clientDao.deleteAll();
        clientDao.closeCurrentSessionwithTransaction();
        }
    
    
}
