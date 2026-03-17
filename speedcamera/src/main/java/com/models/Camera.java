package com.models;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * The {@code Camera} class is responsible for monitoring the speed of vehicles and issuing tickets based on their speeds.
 * It keeps track of the number of tickets issued using an {@code AtomicInteger}.
 */
public class Camera {
    private int counter;
    private static final AtomicInteger ticketCounter = new AtomicInteger(0);

    /**
     * Constructs a new {@code Camera} object.
     */
    public Camera() {
        // No specific initialization required
    }

    /**
     * Gets the current value of the ticket counter.
     *
     * @return the current value of the ticket counter
     */
    public int getCounter() {
        return counter;
    }

    /**
     * Sets the value of the ticket counter.
     *
     * @param counter the new value of the ticket counter
     */
    public void setCounter(int counter) {
        this.counter = counter;
    }


   
    /**
     * Performs the second test on the speed of the vehicle.
     * <p>
     * If the current speed is 120 or above, it increments the ticket counter and returns {@code true}.
     * Otherwise, it returns {@code false}.
     * </p>
     *
     * @param speed the current speed of the vehicle
     * @return {@code true} if the current speed is 120 or above, {@code false} otherwise
     */
    private boolean secondTest(int speed) {
        if (speed >= 120) {
        	this.counter = ticketCounter.incrementAndGet();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Initiates the tests on the speed of the vehicle.
     * <p>
     * This method checks if the speed is 120 or above, and if so, increments the ticket counter and returns {@code true}.
     * Otherwise, it returns {@code false}.
     * </p>
     *
     * @param vehicle the vehicle whose speed is being tested
     * @return {@code true} if the speed before the test is 120 or above, or if the current speed is 120 or above, {@code false} otherwise
     */
    public boolean initiateTests(Vehicle vehicle) {
     if (secondTest(vehicle.getSpeed())) {
            return true;
        } else {
            return false;
        }
    }
}
