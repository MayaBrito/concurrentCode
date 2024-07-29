package Questões_Resolvidas.ForkSleep;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ForkSleepJ {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        Random gerador = new  Random();

        ArrayList<Thread> ts = new ArrayList<Thread>();

        for (int i=0; i <= n; i++){
            Thread t = new Thread(() -> {
                waitForTime(gerador.nextInt(5000));
            });
            
            ts.add(t);
            t.start();
            
        }
        
        for (Thread t : ts){
            try {
                t.join();  
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

        System.out.println("Valor de n: " + n);

    }

    public static void waitForTime (long timeout){
        try{
            Thread.sleep(timeout);
        }catch(InterruptedException e){

        }
        
    }

}
