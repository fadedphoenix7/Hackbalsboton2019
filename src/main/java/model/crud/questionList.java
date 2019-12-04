/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.crud;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import model.bootstraper.EMFBootstrapper;
import model.schemas.Security;

/**
 *
 * @author joses
 */
public class questionList {
    public ArrayList<Security> getQuestions(){
        ArrayList<Security> security;
        EntityManager manager = EMFBootstrapper.openEntityManager();
        try {
            security = ( ArrayList<Security>) manager.createQuery("FROM Security").getResultList();
        }
        catch(PersistenceException e) {
            throw e;
        }
        
        return security;
    }
}
