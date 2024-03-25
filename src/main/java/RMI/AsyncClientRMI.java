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
public class AsyncClientRMI {
 public static void  main(String args[]) throws RemoteException, NotBoundException, InterruptedException
    {
Registry registry=LocateRegistry.getRegistry("localhost", 1199) ;
TaskService stub=(TaskService) registry.lookup("hello");
 Thread asyncThread = new Thread(() -> {
    try {
        Task task1 = new Task(1, "bechir");
        stub.addTask(task1);
        
            List<Task> tasks = stub.getAllTasks();
            for (Task task : tasks) {
                System.out.println("Task ID: " + task.getId() + ", Description: " + task.getDescription());
            }
        
    } catch (RemoteException e) {
        
    }
});
asyncThread.start();

System.out.println("Continuing with others Task");

Task task2 = new Task(2, "ben tekfa");
stub.addTask(task2);
    List<Task> tasks = stub.getAllTasks();
    for (Task task : tasks) {
        System.out.println("Task ID: " + task.getId() + ", Description: " + task.getDescription());
    }


try {
    asyncThread.join();
} catch (InterruptedException e) {
}
}
}

