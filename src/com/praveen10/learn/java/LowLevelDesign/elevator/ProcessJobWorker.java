package com.praveen10.learn.java.LowLevelDesign.elevator;

class ProcessJobWorker implements Runnable {

    private Elevator elevator;

    ProcessJobWorker(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void run() {
        /**
         * start the elevator
         */
        elevator.startElevator();
    }

}
