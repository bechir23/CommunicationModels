/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bechi
 */
public class ServerChat {
     private static final CopyOnWriteArrayList<PrintWriter> clientsout = new CopyOnWriteArrayList<>();

    public static void main(String [] args) throws IOException
    {ServerSocket serverSocket=new ServerSocket(200); 
    System.out.println("Server is listening "); 
while(true)
{    Socket clientSocket=serverSocket.accept() ;    
PrintWriter out=new PrintWriter(clientSocket.getOutputStream(),true) ;
clientsout.add(out);
                new Thread(new ClientHandler(clientSocket)).start();

}   

    }
    private static class ClientHandler implements Runnable {
        private final Socket clientSocket ;
        public ClientHandler(Socket clientSocket) {this.clientSocket=clientSocket;}
        @Override
    public void run() {
            try {
                Scanner in=new Scanner(clientSocket.getInputStream()) ;
                while(in.hasNextLine())
                {String message=in.nextLine();
                System.out.println("Received from client:"+message);
                 for(PrintWriter out:clientsout)
                {out.println(message);}}
               
            } catch (IOException ex) {
                Logger.getLogger(ServerChat.class.getName()).log(Level.SEVERE, null, ex);
            }
    }}
        
    }

