
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nopita pratiwi patmawati 1301152636
 */
public class SA {
    public double x1;
    public double x2;
    public double fitness;

    public SA(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    public SA() {
        Random random = new Random();
        x1= ThreadLocalRandom.current().nextDouble(-10,10);
        x2 = ThreadLocalRandom.current().nextDouble(-10,10);
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }
    
    public  double fitness(double x1, double x2){
        fitness = (4-2.1*(Math.pow(x1, 2))+Math.pow(x1, 4)/3)*Math.pow(x1, 2)+(x1*x2)+(-4+4*Math.pow(x2, 2))*Math.pow(x2,2);
        return fitness;
    }

    public double getFitness() {
        return fitness;
    }
    
    public boolean cekState(ArrayList tmp, SA state){
        boolean b = false;
        for (int i=0; i<tmp.size(); i++){
            if(tmp.get(i)!=state){
                b=false; 
            }
            else{
                b=true;
            }
        }
        return b;
    }
}
