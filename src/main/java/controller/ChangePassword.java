/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.crud.UserCRUD;
import model.schemas.User;
import view.NewPassword;

/**
 *
 * @author joses
 */
public class ChangePassword {
     
    public boolean newPasswordd(NewPassword newP){
        boolean changeCorrect = false;
        UserCRUD model = new UserCRUD();
        User user = newP.getUser();
        User newUser;
        try {
            newUser = (User) user.clone();
            newUser.setPassword(newP.getNewPass());
            model.deleteUser(user.getEmail());
            model.createUser(newUser);
            System.out.println("Se Cambio la password");
            changeCorrect = true;
        }
        catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
           return changeCorrect;
    }
}
