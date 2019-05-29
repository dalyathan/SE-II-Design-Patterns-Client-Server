/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientserverarchitecture;

import java.util.ArrayList;
import java.util.concurrent.Callable;

/**
 *
 * @author Windows
 */
public class PrimeNumbersServerThread extends Thread{
    private static volatile ArrayList<Long> primeNumbers=new ArrayList();
    private static volatile int maxPrimeIndex=0;
    private Long previousMaxPrime;
    public PrimeNumbersServerThread(){
        this.primeNumbers.add(((long)2));
        maxPrimeIndex++;
    }
    @Override 
    public void run(){
        boolean isPrime=true;
        long currentTarget=2;
        long factor_threshold=currentTarget/2;
        long numberOfFactors=0;
        while (true){
            currentTarget++;
            for(int possibleFactor=1;possibleFactor<=factor_threshold;possibleFactor++){
                if(currentTarget%possibleFactor==0){
                    numberOfFactors++;
                }
                else if(numberOfFactors>2){
                    isPrime=false;
                    break;
                }
            }
            if(isPrime){
                primeNumbers.add(currentTarget);
                PrimeNumbersServer.notifyCleints(maxPrimeIndex, currentTarget);
                maxPrimeIndex++;
            }
        }
    }
    public Long getPrimeAt(int index){
        if(index>maxPrimeIndex){
            long flag=0;
            return flag;
        }
        return this.primeNumbers.get(index);
    }
}
