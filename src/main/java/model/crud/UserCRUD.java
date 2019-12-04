/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import model.bootstraper.EMFBootstrapper;
import model.schemas.User;


/**
 *
 * @author joses
 */
public class UserCRUD {
    
    public void createUser(User user){
        EntityManager manager = EMFBootstrapper.openEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(user);
            transaction.commit();
            System.out.printf("se ha agregado con exito");
        }
        catch(PersistenceException e) {
            transaction.rollback();
            throw e;
        }
        finally {
            manager.close();
        }
    }

    public User getUser(String email){
        EntityManager manager = EMFBootstrapper.openEntityManager();
        User user = new User();
        try {
            user = (User) manager.createQuery("from User u where u.Email='" + email + "'").getSingleResult();
        }
        catch(PersistenceException e) {
            throw e;
        }

        return user;
    }
    
    public void deleteUser(String email){


            User user = getUser(email);
            System.out.println(user);
            EntityManager manager = EMFBootstrapper.openEntityManager();
            System.out.println("aqui 5");
            EntityTransaction transaction = manager.getTransaction();
            try {
                transaction.begin();
                System.out.println("aqui 6");
                //manager.remove(user);
                manager.remove(manager.contains(user) ? user : manager.merge(user));
                transaction.commit();
                System.out.println("aqui 7");
                System.out.printf("se ha eliminado con exito");
            }
            catch(PersistenceException e) {
                transaction.rollback();
                throw e;
            }
            finally {
                manager.close();
            }
        
    }

}
