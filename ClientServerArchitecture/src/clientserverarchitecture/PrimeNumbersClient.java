/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientserverarchitecture;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Windows
 */
public class PrimeNumbersClient{
    private int primeNumberWanted;
    private String name;
    public PrimeNumbersClient(int index,String name){
        this.primeNumberWanted=index;
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public int getRegisteredIndex(){
        return this.primeNumberWanted;
    }
    public void found(long whatYouWereLookingFor){
        System.out.println("The prime Number At "+this.primeNumberWanted+" is "+whatYouWereLookingFor);
    }
    public void connectToServer() throws IOException{
        Socket socket=new Socket("localhost",12345);
        Packet outgoing=new Packet(this);
        ObjectOutputStream sender=new ObjectOutputStream(socket.getOutputStream());
        sender.writeObject(outgoing);
    }
}
