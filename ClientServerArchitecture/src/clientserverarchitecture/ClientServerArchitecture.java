/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientserverarchitecture;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows
 */
public class ClientServerArchitecture {

    
    public static void main(String[] args) {
        ArrayList<PrimeNumbersClient> clients=new ArrayList();
        int numberOfClients=(int)(Math.random()*100);
        for(int clientNumber=0;clientNumber<numberOfClients;clientNumber++){
            PrimeNumbersClient client=new PrimeNumbersClient((int)(Math.random()*100000),"Client"+clientNumber);
            try {
                client.connectToServer();
            } catch (IOException ex) {
                System.out.println("Client"+clientNumber+" couldn't connect");
            }
        }
    }
    
}
