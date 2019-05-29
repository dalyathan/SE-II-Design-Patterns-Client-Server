/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientserverarchitecture;

/**
 *
 * @author Windows
 */
public class Packet {
    private PrimeNumbersClient sender;
    public Packet(PrimeNumbersClient sender){
        this.sender=sender;
    }
    public PrimeNumbersClient getSender(){
        return sender;
    }
}
