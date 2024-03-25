/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author bechi
 */
public interface TaskService extends Remote {
    void addTask(Task task) throws RemoteException;
    void removeTask(int taskId)  throws RemoteException;
    List<Task> getAllTasks() throws RemoteException ;

   
    
    
}
