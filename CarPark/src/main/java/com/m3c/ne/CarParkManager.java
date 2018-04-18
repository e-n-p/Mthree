package com.m3c.ne;

public class CarParkManager {

    private CarPark carPark;

    CarParkManager(CarPark carPark) {
        this.carPark = carPark;
    }

    public synchronized void requestCarParkSpace() {
        while (!carPark.hasAvailableSpaces()) {
            try {
                this.wait();
                printWaiting(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        carPark.addCar();
        printState(Thread.currentThread().getName(), "parked");
    }

    public synchronized void leaveCarPark() {
        carPark.removeCar();
        printState(Thread.currentThread().getName(), "leaving");
        this.notifyAll();
    }

    private void printState(String car, String carState) {
        System.out.println(car + " " + carState + " - Spaces available = " + carPark.getSpaces());
    }

    private void printWaiting(String car) {
        System.out.println(car + " is waiting for a space");
    }
}
