/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.crud;
import model.bootstraper.EMFBootstrapper;
import model.schemas.Security;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import view.QuestionPass;



/**
 *
 * @author joses
 */
public class QuestionR {
    
    public Security getQuestiuon(int id){
        EntityManager manager = EMFBootstrapper.openEntityManager();
        Security quest = new Security();
        try {
            quest = (Security) manager.createQuery("FROM Security u WHERE u.Id = '"+id+"'").getSingleResult();
        }catch(PersistenceException e) {
            throw e;
        }
        return quest;
    }
    
    public boolean isCorrect(QuestionPass qp){
        boolean isAcept = false;
        if(qp.getRealAnswer().equals(qp.getAnswer())){
            isAcept = true;
        }

        return isAcept;
        
    }
    
}
