/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ArtisanDAO;
import Modele.Artisans;
import java.util.List;

/**
 *
 * @author 1895066
 */
public class ArtisanService {
    
    private static ArtisanDAO artisanDao;
    
    public ArtisanService()
    {
    artisanDao = new ArtisanDAO();
    }
    
    public void save(Artisans entity)
    {
        artisanDao.openCurrentSessionwithTransaction();
        artisanDao.persist(entity);
        artisanDao.closeCurrentSessionwithTransaction();
    }
	public void update(Artisans entity)
        {
        artisanDao.openCurrentSessionwithTransaction();
        artisanDao.update(entity);
        artisanDao.closeCurrentSessionwithTransaction();
        }
        
	public Artisans findById(String id)
        {
            artisanDao.openCurrentSession();
            Artisans artisan = artisanDao.findById(id);
            artisanDao.closeCurrentSession();
            return artisan;
        }
	public void delete(String id)
        {
            artisanDao.openCurrentSessionwithTransaction();
            Artisans artisan = artisanDao.findById(id);
            artisanDao.delete(artisan);
            artisanDao.closeCurrentSessionwithTransaction();
        }
	public List<Artisans> findAll()
        {
            artisanDao.openCurrentSessionwithTransaction();
            List<Artisans> list = artisanDao.findAll();
            artisanDao.closeCurrentSessionwithTransaction();
            return list;
        }
	public void deleteAll()
        {
        artisanDao.openCurrentSessionwithTransaction();
        artisanDao.deleteAll();
        artisanDao.closeCurrentSessionwithTransaction();
        }
    
}
