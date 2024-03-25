/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

/**
 *
 * @author bechi
 */
public class ClientRMI {
    public static void  main(String args[]) throws RemoteException, NotBoundException
    {
Registry registry=LocateRegistry.getRegistry("localhost", 1099) ;
TaskService stub=(TaskService) registry.lookup("hello");
Task task1=new Task(1,"bechir");
Task task2=new Task(2,"ben tekfa")    ;
stub.addTask(task1);
stub.addTask(task2);
List<Task> tasks=stub.getAllTasks();
for(Task task:tasks) { System.out.println("Task ID: " + task.getId() + ", Description: " + task.getDescription());}
stub.removeTask(1);
    }
 
}
