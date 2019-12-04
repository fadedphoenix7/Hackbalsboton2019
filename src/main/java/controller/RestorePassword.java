/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import controller.exceptions.EmptyException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import model.crud.UserCRUD;
import model.schemas.User;
import java.sql.SQLException;
import view.RestorePass;
import java.util.Random;
import view.CodePassword;

/**
 *
 * @author joses
 */
public class RestorePassword {
    
    public User getUser(RestorePass resP) throws EmptyException{
        User user = new User();
        UserCRUD model = new UserCRUD();
        
        Map<String, String> data = new HashMap<>();
        data.put("email", resP.getEmailText());
        
        
        if (!validCompleteness(data))
        {
            throw new EmptyException();
        }
        else
        {
            try{
                user = model.getUser(data.get("email"));
                System.out.println("Se encontro al usuario1");
            }catch(Exception ex){
                System.out.println("No se encuentra el usuario1");
            }

        }
        
        return user;
    }
    
    
    public boolean validCompleteness(Map<String,String> data){
        boolean isComplete = false;
        Set<String> keys = data.keySet();
        for(String key: keys){
            if(!data.get(key).isEmpty()){ //Checks that there is no empty information
                isComplete = true;
            }
        }
        return isComplete;
    }
    
    public String generateCode(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 6;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) 
            (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
 
        System.out.println(generatedString);
        return generatedString;
    }
    
    public boolean validateCode(CodePassword cd){
        boolean isCorrect = false;
        
        if(cd.getRealCode().equals(cd.getFalseCode())){
            isCorrect = true;
        }
        return isCorrect;
    }
}
