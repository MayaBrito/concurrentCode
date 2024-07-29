package Questões_Resolvidas.ForkSleep;

import java.util.Scanner;
import java.util.Random;
import Mecanismos_de_Sync.Barreira;

public class ForkSleepS {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        Random gerador = new  Random();

        Barreira bar = new Barreira(n+1);

        for (int i=0; i <= n; i++){
            Thread t = new Thread(() -> {
                waitForTime(gerador.nextInt(5000));
                bar.waitt();
            });     
            
            t.start();
            
        }

        bar.waitt();
        System.out.println("Valor de n: " + n);

    }

    public static void waitForTime (long timeout){
        try{
            
            Thread.sleep(timeout);
        }catch(InterruptedException e){

        }
        
    }
}