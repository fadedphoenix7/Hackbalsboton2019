/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;
import view.*;
/**
 *
 * @author raulrivadeneyra
 */
public class Main {
    
    private final Devices devicesWindow = new Devices();
    private final Home homeWindow = new Home();
    private final Login loginWindow = new view.Login();
    private final Register registerWindow = new Register();
    private final setupAreas setupAreasWindow = new view.setupAreas();
    private final setupDevices setupDevicesWindow = new view.setupDevices();
    private final setupRooms setupRoomsWindow = new setupRooms();

    public static void main(String args[]){
        try
        {
            new Main().start();
        }
        catch (Exception e)
        {
            e.printStackTrace ();
        }
    }
    public void start(){
        setupAreasWindow.setVisible(true);
    }
    public Register getRegisterWindow(){
        return registerWindow;
    }
    public Login getLoginWindow(){
        return loginWindow;
    }
    
}
