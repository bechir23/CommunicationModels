/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author bechi
 */
public class ServerRMI {

    
    
    
    public static void main (String args []) throws RemoteException, AlreadyBoundException
    {
      TaskServiceImpl   obj=new TaskServiceImpl() ;
            Registry registry = LocateRegistry.createRegistry(1199);
        registry.bind("hello",obj) ;
            System.out.println("Server is Running ");
    }
}
