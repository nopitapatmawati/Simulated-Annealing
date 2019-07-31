
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
/**
 *
 * @author nopita pratiwi patmawati 1301152636
 */
public class SimulatedAnnealing {
    public static void main(String[] args) {
        SA currentState = new SA();
        ArrayList<SA> tmp = new ArrayList();
        tmp.add(currentState);
        SA BestSoFar = currentState;
        final double e = 2.71828;
        double p;
        double alfa;
        int i=0;
        double omega;
        double T = 2147483647;
//        double T=100;
        double deltaE=0;

        while (T>=0.0000000000000000000000000000000000000000000000000000000000001){
//            System.out.println("udah masuk looping");
            SA newState = new SA();
            boolean x = currentState.cekState(tmp, newState);
//		ngecek statenya sudah pernah dipakai sebelumnya atau belum. jika sudah, maka akan diacak kembali
//		To check the current state never been used before. If it already used, then random the state again
            do{
//                System.out.println("udah mulai ngecek");
                if(x==true){
                    SA temp = new SA();
                    newState = temp;
                    x = currentState.cekState(tmp, newState);
                    if(x==false){
                        System.out.println(x);
                    }
                }
            }while(x==true);
            deltaE = newState.fitness(newState.getX1(), newState.getX2()) - currentState.fitness(currentState.getX1(), currentState.getX2());
            if(deltaE<0){
                currentState = newState;
                tmp.add(currentState);
                BestSoFar = newState;
            }
            else{
                p=Math.pow(e, (-(deltaE/T)));
                omega = ThreadLocalRandom.current().nextDouble(0,1);
                if(omega<p){
                    currentState = newState;
                    tmp.add(currentState);
                }
            }
            i++;
//            System.out.println("i: "+i);
            if(i%200 == 0){
                alfa = ThreadLocalRandom.current().nextDouble(0.8888888888888, 0.999999999999);
                T=T*alfa;
//                System.out.println(T);
            }
        }
        /*
        0.88888888888, 0.9999999999999999
        int w =0;
        while (T>0.0000000000000000000000000000000000000000000000000000000000001){
//            if(w%100==0){
//                alfa = ThreadLocalRandom.current().nextDouble(0.8888 , 0.99999);
//                //System.out.println(alfa);
//                T=T*alfa;
//                System.out.println(T);
//            }
//            w++;
//            omega = ThreadLocalRandom.current().nextDouble(0,1);
//            System.out.println(omega);
        }*/

          System.out.println("Solusi: x1= "+BestSoFar.x1+"dan x2="+BestSoFar.x2);
          System.out.println("Solusi nilai fungsi minimal= "+BestSoFar.fitness(BestSoFar.getX1(),BestSoFar.getX2()));
          
    }
    
    
}
