package com.na.threads;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

class Bucket {
    private boolean filled;
    
    public boolean isFilled() {
        return filled;
    }
    
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
}

class Filler implements Runnable {
    private final Bucket bucket;
    Filler(Bucket bucket){
        this.bucket = bucket;
    }
    
    @Override
    public void run() {
        while(true){
            synchronized(bucket) {
                if(!bucket.isFilled()){
                    bucket.setFilled(true);//fill bucket and notify drainer thread
                    Logger.getLogger(Filler.class.getName()).log(Level.INFO, "{0}-Bucket is filled.", Thread.currentThread().getName());
                    bucket.notify();  //notify drainer thread
                    sleepRandomly(10000); // sleep for random time
                }else{
                    try {
                        Logger.getLogger(Filler.class.getName()).log(Level.INFO, "{0}-Waiting for bucket to get drained.",Thread.currentThread().getName());
                        bucket.wait();//wait for bucket to get drained here...
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Filler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    void sleepRandomly(int seed) {
        long sleep = new Random().nextInt(seed);
        Logger.getLogger(Filler.class.getName()).log(Level.INFO,"{0} sleeping(in ms) for {1}", new Object[]{Thread.currentThread().getName(), sleep});
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException ex) {
            Logger.getLogger(Filler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class Drainer implements Runnable {
    private final Bucket bucket;
    Drainer(Bucket bucket){
        this.bucket = bucket;
    }
    
    @Override
    public void run() {
        while(true){
            synchronized(bucket){
                if(bucket.isFilled()){
                    bucket.setFilled(false); //drain the bucket 
                    Logger.getLogger(Drainer.class.getName()).log(Level.INFO, "{0}-Bucket is drained.",Thread.currentThread().getName());
                    bucket.notify(); // notify filler thread
                    sleepRandomly(10000); // sleep for random time
                }else{
                    try {
                        Logger.getLogger(Drainer.class.getName()).log(Level.INFO, "{0}-Waiting for bucket to get filled.",Thread.currentThread().getName());
                        bucket.wait(); //wait for bucket to get filled here...
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Drainer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    void sleepRandomly(int seed) {
        long sleep = new Random().nextInt(seed);
        Logger.getLogger(Drainer.class.getName()).log(Level.INFO, "{0} sleeping(in ms) for {1}", new Object[]{Thread.currentThread().getName(), sleep});
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException ex) {
            Logger.getLogger(Drainer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

public class BucketFillerDrainer {
    public static void main(String[] args) {
        Bucket bucket = new Bucket();
        Filler filler = new Filler(bucket);
        Drainer drainer = new Drainer(bucket);
        new Thread(filler,"Filler").start();
        new Thread(drainer,"Drainer").start();
    }
}