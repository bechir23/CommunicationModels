/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bechi
 */
public class ClientChat2 {
         
            public static void main(String[] args) {

          
        try {
              Socket  socket;
            socket = new Socket("localhost",200);
                         Scanner scanner = new Scanner(System.in);
            PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
            Scanner in=new Scanner(socket.getInputStream());
                        System.out.println("Connected to server. Type 'exit' to quit.");
                         Thread readerThread = new Thread(() -> {
                while (in.hasNextLine()) {
                    System.out.println("From broadcasting Server: " + in.nextLine());
                }
            });
            readerThread.start();
            String message;
            while(true)
            {message=scanner.nextLine();
            if ("exit".equalsIgnoreCase(message)) {socket.close();
                    break;
                }
            out.println(message);
            }

        } catch (IOException ex) {
            Logger.getLogger(ClientChat.class.getName()).log(Level.SEVERE, null, ex);
        }
            
      
       
}
    
}
