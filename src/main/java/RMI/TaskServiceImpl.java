/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bechi
 */
public class TaskServiceImpl extends UnicastRemoteObject implements TaskService{
    private final List<Task> tasks ;
    public TaskServiceImpl() throws RemoteException {
        tasks = new ArrayList<>();
    }

        @Override
        public void addTask(Task task) throws RemoteException {
            tasks.add(task) ;
        }

        @Override
        public void removeTask(int taskId) throws RemoteException {
              tasks.removeIf(task -> task.getId() == taskId);
        }

        @Override
        public List<Task> getAllTasks() throws RemoteException {
        return tasks ;}

  

   
}