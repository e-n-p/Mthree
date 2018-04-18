package com.m3c.ne;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Starter {

    public static void main(String[] args) {
        CarPark carPark = new CarPark(10);
        CarParkManager carParkManager = new CarParkManager(carPark);
        List<Thread> threads = new ArrayList<>();
        Random randomGenerator = new Random();
        int numberCars = 100;
        for (int i = 1; i <= numberCars; i++) {
            Runnable car = () -> {
                try {
                    carParkManager.requestCarParkSpace();
                    Thread.sleep(randomGenerator.nextInt(15));
                    carParkManager.leaveCarPark();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            Thread thread = new Thread(car);
            thread.setName("Car-"+i);
            threads.add(thread);
        }

        for (Thread t : threads){
            t.start();
        }
    }
}