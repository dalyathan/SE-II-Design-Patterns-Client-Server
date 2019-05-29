/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientserverarchitecture;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Windowsc
 */
public class PrimeNumbersServer extends Thread {
    private static ArrayList<PrimeNumbersClient> clientQueue=new ArrayList();
    private static PrimeNumbersServerThread prime_generator;
    public static void main(String[] args) throws ClassNotFoundException{
        clientQueue=new ArrayList();
        prime_generator=new PrimeNumbersServerThread();
        prime_generator.start();
        try {
            ServerSocket server_socket=new ServerSocket(12345);
            Socket client=null;
            while(true){
                client=server_socket.accept();
                ObjectInputStream object_in=new ObjectInputStream(client.getInputStream());
                Packet incoming=(Packet)object_in.readObject();
                addToClientQueue(incoming.getSender());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static synchronized void addToClientQueue(PrimeNumbersClient client){
        long reply=prime_generator.getPrimeAt(client.getRegisteredIndex());
        if(reply!=0){
            client.found(reply);
        }
        clientQueue.add(client);
    }
    public static void notifyCleints(int latestIndex,long latestPrimaryNumber){
        for(PrimeNumbersClient queuedClient:clientQueue){
            if(queuedClient.getRegisteredIndex()==latestIndex){
                queuedClient.found(latestPrimaryNumber);
            }
        }
    }
}
